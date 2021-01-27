package com.itcrazy.alanmall.test.controller.rabbit;

import lombok.Data;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


@PropertySource("classpath:rabbitmq.properties")
@Component
public class RabbitProduct {
    @Value("${rabbit.exchange.test}")
    private String exchange;

    @Value("${rabbit.routingKey}")
    private String routingKey;

    @Autowired
    AmqpTemplate rabbitTemplate;

    @RequestMapping("/send")
    public void send() {
        rabbitTemplate.convertAndSend(exchange,routingKey, "test");
//        rabbitTemplate.convertAndSend("DIRCT_EXCHANGE","test","-------- a dirct msg");
//        System.out.println("product:ok");
    }
}
