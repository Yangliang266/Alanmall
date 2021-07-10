package com.itcrazy.alanmall.shopping.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.itcrazy.alanmall.shopping.dal")
@ComponentScan(basePackages = {"com.itcrazy.alanmall.shopping", "com.itcrazy.alanmall.common"})
@SpringBootApplication
@EnableCaching
public class ShoppingProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingProviderApplication.class, args);
	}
}
