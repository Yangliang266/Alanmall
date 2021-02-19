package com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.producer;

import com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.model.Company;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:rabbitmq.properties")
public class Producer {

	@Autowired
	private AmqpTemplate template;
	
	@Value("${jsa.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${jsa.rabbitmq.routingkey}")
	private String routingkey;

	public void produce(Company company){
		template.convertAndSend(exchange, routingkey, company);
		System.out.println("Send msg = " + company);
	}
}