package com.itcrazy.alanmall.order.product;

import lombok.Data;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Auther: mathyoung
 * @description:
 */
@Component
@PropertySource("classpath:base_mq.properties")
@Data
public class CancelOrderProduct {
    @Autowired
    AmqpTemplate amqpTemplate;

    @Value("${ORDER_CANCEL_EXCHANGE}")
    private String cancelExchange;

    @Value("${ORDER_DELAY_ROUTING_KEY}")
    private String cancelRoutingKey;

    public void sendCancelOrderMessage(String msg) {
        amqpTemplate.convertAndSend(cancelExchange, cancelRoutingKey, msg, message -> {
            message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
            return message;
        });
    }
}
