package com.itcrazy.alanmall.shopping.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.itcrazy.alanmall.shopping")
public class AlanmallShoppingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlanmallShoppingApplication.class, args);
    }


}
