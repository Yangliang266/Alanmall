package com.itcrazy.alanmall.user.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.itcrazy.alanmall.user","com.itcrazy.alanmall.common"})
public class AlanmallUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlanmallUserApplication.class, args);
    }

}
