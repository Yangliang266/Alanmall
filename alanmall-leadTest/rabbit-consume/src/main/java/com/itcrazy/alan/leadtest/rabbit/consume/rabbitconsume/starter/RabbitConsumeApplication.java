package com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan({"com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume"})
@MapperScan("com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.dal")
public class RabbitConsumeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitConsumeApplication.class, args);
	}

}
