package com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct;

import lombok.Data;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/send")
    public String send() {
        template.convertAndSend(exchange,routingKey, "test");
        System.out.println("product:ok");

        return "SUCEESS";
    }
}
