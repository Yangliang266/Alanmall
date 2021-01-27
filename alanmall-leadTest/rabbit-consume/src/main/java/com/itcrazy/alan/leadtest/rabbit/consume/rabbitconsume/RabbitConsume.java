package com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queueDirctTest", containerFactory = "rabbitListenerContainerFactory")
public class RabbitConsume {
    @RabbitHandler
    public void process(String msg){
        System.out.println(" second queue received msg : " + msg);
    }
}



