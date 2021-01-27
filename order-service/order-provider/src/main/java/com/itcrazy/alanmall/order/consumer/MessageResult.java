package com.itcrazy.alanmall.order.consumer;

import com.itcrazy.alanmall.order.context.TransHandlerContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.spring.core.RocketMQListener;

public interface MessageResult<T extends TransHandlerContext> extends RocketMQListener<T> {
    /**
     * 并发消费
     * @param obj
     * @return
     */
    ConsumeConcurrentlyStatus ConcurrentConsumeSendMsg(T obj);

    /**
     * 顺序消费
     * @param obj
     * @return
     */
    ConsumeOrderlyStatus orderlyConsumeSendMsg(T obj);
}
