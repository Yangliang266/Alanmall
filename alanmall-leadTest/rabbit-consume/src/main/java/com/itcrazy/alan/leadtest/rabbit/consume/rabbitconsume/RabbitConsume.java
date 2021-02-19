//package com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume;
//
//import com.alibaba.fastjson.JSON;
//import com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.dto.AddAndUpdateMqRequest;
//import com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.dto.MqMessageDto;
//import com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.manager.IMqService;
//import com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.service.MqServiceImp;
//import com.rabbitmq.client.Channel;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Arrays;
//
//@Service
//@RabbitListener(queues = "queueDirctTest2", containerFactory = "rabbitListenerContainerFactory")
//public class RabbitConsume {
//    @Autowired
//    MqServiceImp imp;
//
//    @RabbitHandler
//    public void process(String msg, Message message, Channel channel) throws IOException, InterruptedException {
////        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
//        MqMessageDto msg1 = JSON.parseObject(msg, MqMessageDto.class);
//
//        System.out.println("queue received msg : " + msg1.getExchange() + ":" + msg1.getTag());
//
////        System.out.println(msg);
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
//
////        AddAndUpdateMqRequest request = new AddAndUpdateMqRequest();
////        request.setQueue("queueDirctTest");
////        request.setStatus(1);
////        request.setUserId((long) 170017);
////
////        imp.addMqMessage(request);
//        System.out.println("consume: succsse____________");
//    }
//}
//
//
//
