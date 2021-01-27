//package com.itcrazy.alanmall.test.manager;
//
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
//import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//
//public interface MessageResult<String> extends RocketMQListener<String> {
//    /**
//     * 并发消费
//     * @param obj
//     * @return
//     */
//    ConsumeConcurrentlyStatus ConcurrentConsumeSendMsg(String obj);
//
//    /**
//     * 顺序消费
//     * @param obj
//     * @return
//     */
//    ConsumeOrderlyStatus orderlyConsumeSendMsg(String obj);
//}
