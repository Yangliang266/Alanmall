//package com.itcrazy.alanmall.test.controller.rocket;
//
//import com.itcrazy.alanmall.test.controller.Test;
//import org.apache.rocketmq.client.producer.SendResult;
//import org.apache.rocketmq.common.message.Message;
//import org.apache.rocketmq.spring.core.RocketMQTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping("/rocketmq")
//public class Product {
//
//    @Autowired
//    RocketMQTemplate rocketMQTemplate;
//
//    @GetMapping("/sync")
//    public String sync() {
//
//            Message messages = new Message(Test.topic, "TagA", "test00", ("Hello world").getBytes());
//            SendResult sendResult = rocketMQTemplate.syncSend(Test.topic, messages, 3000);
//            System.out.println("i am product:" + sendResult);
//
////        messages.add(new Message(Test.topic, "TagA", "OrderID001", ("Hello world1").getBytes()));
////        SendResult sendResult = rocketMQTemplate.syncSend(Test.topic, messages, 3000);
////        System.out.println("i am product:" + sendResult);
////
////        messages.add(new Message(Test.topic, "TagA", "OrderID002", ("Hello world2").getBytes()));
////        SendResult sendResult1 = rocketMQTemplate.syncSend(Test.topic, messages, 3000);
////        System.out.println("i am product:" + sendResult);
////
////        messages.add(new Message(Test.topic, "TagA", "OrderID003", ("Hello world3").getBytes()));
////        SendResult sendResult2 = rocketMQTemplate.syncSend(Test.topic, messages, 3000);
////        System.out.println("i am product:" + sendResult);
////
////        messages.add(new Message(Test.topic, "TagA", "OrderID004", ("Hello world4").getBytes()));
////        SendResult sendResult3 = rocketMQTemplate.syncSend(Test.topic, messages, 3000);
////        System.out.println("i am product:" + sendResult);
////
////        messages.add(new Message(Test.topic, "TagA", "OrderID004", ("Hello world4").getBytes()));
////        SendResult sendResult4 = rocketMQTemplate.syncSend(Test.topic, messages, 3000);
////        System.out.println("i am product:" + sendResult);
////
////        messages.add(new Message(Test.topic, "TagA", "OrderID005", ("Hello world5").getBytes()));
////        SendResult sendResult5 = rocketMQTemplate.syncSend(Test.topic, messages, 3000);
////        System.out.println("i am product:" + sendResult);
//
//        return "success";
//    }
//}
