//package com.itcrazy.alanmall.test.controller.rocket;
//
//import com.itcrazy.alanmall.test.controller.Test;
//import com.itcrazy.alanmall.test.manager.MessageResult;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
//import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
//import org.apache.rocketmq.spring.annotation.ConsumeMode;
//import org.apache.rocketmq.spring.annotation.MessageModel;
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.stereotype.Service;
//
//@Service
//@RocketMQMessageListener(consumerGroup = "consume_group",
//                         topic = Test.topic,
//                         consumeMode = ConsumeMode.CONCURRENTLY,
//                         messageModel = MessageModel.CLUSTERING)
//public class Consume implements RocketMQListener<String> {
//
//    @Override
//    public void onMessage(String msg) {
//        System.out.println("i am consume:" + msg);
//    }
//
//
//}
