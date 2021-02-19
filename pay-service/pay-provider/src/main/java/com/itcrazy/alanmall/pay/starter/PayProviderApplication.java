package com.itcrazy.alanmall.pay.starter;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.itcrazy.alanmall.pay","com.itcrazy.alanmall.common"})
@MapperScan("com.itcrazy.alanmall.pay.dal")
public class PayProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayProviderApplication.class, args);
	}

}
