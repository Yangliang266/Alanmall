package com.itcrazy.alanmall.order.handler.HandlerType;

import com.itcrazy.alanmall.order.context.TransHandlerContext;
import com.itcrazy.alanmall.order.dto.AddAndUpdateMqRequest;
import com.itcrazy.alanmall.order.dto.MqResponse;
import com.itcrazy.alanmall.order.manager.IMqService;
import com.itcrazy.alanmall.order.utils.MqFactory;
import com.itcrazy.alanmall.order.utils.MqTransCondition;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = true)
@Component
@PropertySource("classpath:base_mq.properties")
@Data
public class ValidateHandler extends AbstracTransHandler {
    @Autowired
    RabbitTemplate template;

    @Autowired
    IMqService iMqService;

    @Autowired
    MqFactory factory;

    @Value("${BINDING_KEY}")
    private String bindingKey;

    @Value("${ORDER_EXCHANGE}")
    private String exchange;

    @Value("${CREATE_ORDER_VALIDATE_QUEUE}")
    private String queue;

    @Value("${MQ_STATUS}")
    private boolean mqStatus;

    @Override
    public boolean isAysc() {
        return false;
    }

    @Override
    public boolean doHandler(TransHandlerContext context) {
        try {
            // 参数条件控制，由provider提供
            MqTransCondition condition = MqFactory.getFlyweight(context,exchange,queue);
            // 发送信息
            template.convertAndSend(exchange, bindingKey, condition, message -> {
                message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                return message;
            });
//
            // api 验证消费是否消费成功
            MqResponse mqMessage = iMqService.queryMqStatus(condition.getMsgId());
            if (mqMessage.getMessageDto().getStatus() == 1) {
                mqStatus = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mqStatus;

    }

}
