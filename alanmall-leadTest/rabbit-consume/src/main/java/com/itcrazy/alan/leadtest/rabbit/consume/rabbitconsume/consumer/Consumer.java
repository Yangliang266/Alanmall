package com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.consumer;

import com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.model.Company;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	
	@RabbitListener(queues="jsa.queue", containerFactory="jsaFactory")
    public void recievedMessage(Company company) {
        System.out.println("Recieved Message: " + company);
    }
}