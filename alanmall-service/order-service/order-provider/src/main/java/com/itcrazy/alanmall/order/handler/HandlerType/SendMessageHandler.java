package com.itcrazy.alanmall.order.handler.HandlerType;

import com.itcrazy.alanmall.order.context.CreateOrderContext;
import com.itcrazy.alanmall.order.context.TransHandlerContext;
import com.itcrazy.alanmall.order.utils.RabbitConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @Auther: mathyoung
 * @description: SendMessageHandler
 */
@EqualsAndHashCode(callSuper = true)
@Component
@PropertySource("classpath:base_mq.properties")
@Data
@Slf4j
public class SendMessageHandler extends AbstracTransHandler{
    @Value("${ORDER_DELAY_ROUTING_KEY}")
    private String delayRoutingKey;

    @Value("${ORDER_DELAY_EXCHANGE}")
    private String delayExchange;

    @Value("${sendTag}")
    private boolean sendTag;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public boolean isAysc() {
        return false;
    }

    @Override
    public boolean doHandler(TransHandlerContext context) {
        CreateOrderContext createOrderContext = (CreateOrderContext)context;
//        final SortedSet<Message> confirmSet = Collections.synchronizedSortedSet(new TreeSet<>());

        rabbitTemplate.convertAndSend(delayExchange, delayRoutingKey, createOrderContext.getOrderId(),message -> {
            message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
            message.getMessageProperties().setDelay(10 * 60 * 1000);
            return message;
        });

//        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
//            @Override
//            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//                if (ack) {
//                    // ACK
//                    log.info("rabbitmq product send success result:{}", ack);
//                    sendTag = true;
//                } else {
//                    // NACK
//                    log.info("rabbitmq product send error result:{}", ack);
//                    // 重发
//                    confirmSet.headSet(correlationData.getReturnedMessage());
//                    confirmSet.add(correlationData.getReturnedMessage());
//                    // todo
//                    confirmSet.forEach(obj -> {
//                        rabbitTemplate.convertAndSend(delayExchange, delayRoutingKey, obj.getBody(),message -> {
//                            message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
//                            message.getMessageProperties().setDelay(10 * 60 * 1000);
//                            return message;
//                        });
//                    });
//                }
//            }
//        });

        return true;
    }
}
