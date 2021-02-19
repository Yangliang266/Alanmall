package com.itcrazy.alanmall.order.handler.HandlerType;

import com.itcrazy.alanmall.order.context.CreateOrderContext;
import com.itcrazy.alanmall.order.context.TransHandlerContext;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Auther: mathyoung
 * @description: SendMessageHandler
 */
@EqualsAndHashCode(callSuper = true)
@Component
@PropertySource("classpath:base_mq.properties")
@Data
public class SendMessageHandler extends AbstracTransHandler{
    @Value("${ORDER_DELAY_ROUTING_KEY}")
    private String delayRoutingKey;

    @Value("${ORDER_DELAY_EXCHANGE}")
    private String delayExchange;

    @Autowired
    AmqpTemplate amqpTemplate;

    @Override
    public boolean isAysc() {
        return false;
    }

    @Override
    public boolean doHandler(TransHandlerContext context) {
        CreateOrderContext createOrderContext = (CreateOrderContext)context;

        amqpTemplate.convertAndSend(delayExchange, delayRoutingKey, createOrderContext.getOrderId(),message -> {
            message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
            message.getMessageProperties().setDelay(10 * 60 * 1000);
            return message;
        });

        return true;
    }
}
