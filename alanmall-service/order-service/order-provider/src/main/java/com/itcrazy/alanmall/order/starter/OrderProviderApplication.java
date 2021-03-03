package com.itcrazy.alanmall.order.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.itcrazy.alanmall.order","com.itcrazy.alanmall.common"})
@MapperScan("com.itcrazy.alanmall.order.dal")
public class OrderProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderProviderApplication.class, args);
	}

}
