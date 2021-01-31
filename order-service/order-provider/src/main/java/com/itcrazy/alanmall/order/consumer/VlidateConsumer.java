package com.itcrazy.alanmall.order.consumer;

import com.itcrazy.alanmall.common.cache.CachePrefixFactory;
import com.itcrazy.alanmall.common.redis.config.RedissonConfig;
import com.itcrazy.alanmall.order.constant.OrderRetCode;
import com.itcrazy.alanmall.order.context.CreateOrderContext;
import com.itcrazy.alanmall.order.context.TransHandlerContext;
import com.itcrazy.alanmall.order.conveter.MqConverter;
import com.itcrazy.alanmall.order.dto.AddAndUpdateMqRequest;
import com.itcrazy.alanmall.order.dto.MqAddAndUpdateResponse;
import com.itcrazy.alanmall.order.dto.MqResponse;
import com.itcrazy.alanmall.order.manager.IMqService;
import com.itcrazy.alanmall.order.utils.ExceptionProcessorUtils;
import com.itcrazy.alanmall.order.utils.MqFactory;
import com.itcrazy.alanmall.order.utils.MqTransCondition;
import com.itcrazy.alanmall.user.dto.QueryMemberRequest;
import com.itcrazy.alanmall.user.dto.QueryMemberResponse;
import com.itcrazy.alanmall.user.manager.IMemberService;
import com.rabbitmq.client.Channel;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Auther: mathyoung
 * @description: 订单验证
 */
@Component
@PropertySource("classpath:base_mq.properties")
@RabbitListener(queues = "${ORDER_EXCHANGE}",containerFactory = "simpleRabbitListenerContainerFactory")

public class VlidateConsumer {
    @DubboReference(timeout = 3000)
    IMemberService iMemberService;

    @Autowired
    RedissonConfig redisTemplate;

    @Autowired
    MqConverter mqConverter;

    @Autowired
    IMqService iMqService;

    @Autowired
    MqFactory factory;

    @Value("${ORDER_EXCHANGE}")
    private String exchange;

    @Value("${CREATE_ORDER_VALIDATE_QUEUE}")
    private String queue;

    @RabbitHandler
    public void process(MqTransCondition condition, Channel channel, Message message) {
        MqResponse mqResponse = new MqResponse();
        QueryMemberRequest request = new QueryMemberRequest();
        request.setUserId(condition.getUserId());
        try {
            // 消费之前进行消费去重
            mqResponse = iMqService.queryMqStatus(condition.getMsgId());
            if (OrderRetCode.SUCCESS.getCode().equals(mqResponse.getCode())) {
                // 查询订单用户是否权限合理
                QueryMemberResponse queryMemberResponse = iMemberService.queryMemberById(request);
                if (OrderRetCode.SUCCESS.getCode().equals(queryMemberResponse.getCode())) {
                    // 1 调用provider api告知生产者
                    AddAndUpdateMqRequest addAndUpdateMqRequest = mqConverter.mqTransCondition2Request(condition);
                    MqAddAndUpdateResponse mqAddAndUpdateResponse = iMqService.addMqMessage(addAndUpdateMqRequest);
                    if (OrderRetCode.SUCCESS.getCode().equals(mqAddAndUpdateResponse.getCode())) {
                        // 1 放入上下文缓存
                        condition.setBuyerNickName(queryMemberResponse.getUsername());
                        MqFactory.getFlyweight(condition, exchange, queue);
                        // 2 消息落库 - 确认正确消费
                        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
                    }
                }
            } else {
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            }

        }catch (Exception e) {
            // 启动定时任务进行重新消费
            // 消费之前进行msgId判断{1 不存在，添加msgId且进行消费，2 存在，跳过}

            // todo
            ExceptionProcessorUtils.wrapperHandlerException(mqResponse, e);
        }

    }
}
