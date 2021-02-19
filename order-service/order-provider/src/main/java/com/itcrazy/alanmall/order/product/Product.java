//package com.itcrazy.alanmall.order.product;
//
//import com.itcrazy.alanmall.common.redis.config.RedissonConfig;
//import com.itcrazy.alanmall.order.context.CreateOrderContext;
//import com.itcrazy.alanmall.order.context.TransHandlerContext;
//import com.itcrazy.alanmall.order.dto.MqResponse;
//import com.itcrazy.alanmall.order.manager.IMqService;
//import com.itcrazy.alanmall.order.utils.MqFactory;
//import lombok.Data;
//import org.redisson.api.RCountDownLatch;
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.amqp.core.MessageDeliveryMode;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * @Auther: mathyoung
// * @description:
// */
//@RequestMapping("rabbit")
//@PropertySource("classpath:base_mq.properties")
//@Data
//@RestController
//public class Product {
//    @Autowired
//    RedissonConfig redissonConfig;
//
//    @Autowired
//    AmqpTemplate rabbitTemplate;
//
//    @Autowired
//    IMqService iMqService;
//
//    @Autowired
//    MqFactory factory;
//
//    @Value("${BINDING_KEY}")
//    private String bindingKey;
//
//    @Value("${ORDER_EXCHANGE}")
//    private String exchange;
//
//    @Value("${CREATE_ORDER_VALIDATE_QUEUE}")
//    private String queue;
//
//    @Value("${MQ_STATUS}")
//    private boolean mqStatus;
//
//
//    @RequestMapping("/validate")
//    public String doHandler() {
//        try {
//            CreateOrderContext context = new CreateOrderContext();
//            context.setUserId((long) 62);
//            // 参数条件控制，由provider提供
//            MqFactory.getFlyweight(context,exchange,queue);
//            // 传输前condition pool池的存储数
//            System.out.println("product1:" + MqFactory.mqTransCondition);
//            // 发送信息
//            rabbitTemplate.convertAndSend(exchange, bindingKey, "condition",message -> {
//                message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
//                return message;
//            });
//            // api 验证消费是否消费成功
//            RCountDownLatch rCountDownLatch = redissonConfig.getMqLock("validate",1);
//            rCountDownLatch.await();
//            System.out.println("product2:" + MqFactory.mqTransCondition);
//            MqResponse mqMessage = iMqService.queryMqStatus(MqFactory.mqTransCondition.getMsgId());
////            mqStatus = mqMessage.getMessageDto().getStatus() == 1;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "success";
//
//    }
//}
