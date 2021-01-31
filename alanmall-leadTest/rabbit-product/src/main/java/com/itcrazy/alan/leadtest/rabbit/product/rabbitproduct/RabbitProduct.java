package com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct;

import com.alibaba.fastjson.JSON;
import com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.dto.MqMessageDto;
import com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.service.MqServiceImp;
import lombok.Data;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@PropertySource("classpath:rabbitmq.properties")
@RestController
@RequestMapping("/rabbit")
public class RabbitProduct {
    @Value("${rabbit.exchange.test}")
    private String exchange;

    @Value("${rabbit.routingKey}")
    private String routingKey;

    @Autowired
    RabbitTemplate template;

    @Autowired
    MqServiceImp imp;


    @RequestMapping("/send")
    public String send() {
        MqMessageDto mqMessageDto = new MqMessageDto();
        mqMessageDto.setStatus(0);
        mqMessageDto.setExchange(exchange);
        mqMessageDto.setTag("object");

        String json = JSON.toJSONString(mqMessageDto);

        template.convertAndSend(exchange,routingKey, json, (message) -> {
            message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
            return message;
        });

        System.out.println("send: action_____________");

//        MqMessageDto dto = imp.query((long) 170017).getMessageDto();
//
//        if (dto.getStatus() == 1) {
//            System.out.println("send: success_____________");
//            return "SUCEESS";
//        }

        return "false";


    }
}
