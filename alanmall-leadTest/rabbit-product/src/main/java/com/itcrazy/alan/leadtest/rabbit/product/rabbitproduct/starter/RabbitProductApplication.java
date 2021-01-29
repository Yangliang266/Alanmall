package com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan({"com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct"})
@MapperScan("com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.dal")
public class RabbitProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitProductApplication.class, args);
	}

}
