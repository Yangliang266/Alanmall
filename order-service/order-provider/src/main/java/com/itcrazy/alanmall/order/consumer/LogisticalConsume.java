package com.itcrazy.alanmall.order.consumer;

import com.itcrazy.alanmall.order.constant.OrderConstants;
import com.itcrazy.alanmall.order.dal.mapper.OrderShippingMapper;
import com.itcrazy.alanmall.order.dto.OrderShippingRequest;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Auther: mathyoung
 * @description: logisticalConsume
 */
@Component
@RabbitListener(queues = "CANCEL_ORDER_QUEUE", containerFactory = "simpleRabbitListenerContainerFactory")
public class LogisticalConsume {
    @Resource
    OrderShippingMapper orderShippingMapper;

    @RabbitHandler
    public void process(String context, Channel channel, Message message) {
        try {
            OrderShippingRequest request = new OrderShippingRequest();
            request.setOrderId(context);
            request.setReceiverStatus(OrderConstants.ORDERSHIPPING_STATUS_CANCEL);
            orderShippingMapper.updateOrderShipping(request);

            channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
