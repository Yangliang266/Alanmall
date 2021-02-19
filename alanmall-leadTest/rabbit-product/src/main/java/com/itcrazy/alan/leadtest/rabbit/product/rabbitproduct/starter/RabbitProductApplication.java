package com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.starter;

import com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.model.Company;
import com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.model.Product;
import com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@ComponentScan({"com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct","com.itcrazy.alanmall.common"})
@MapperScan("com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.dal")
public class RabbitProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitProductApplication.class, args);
	}





}
