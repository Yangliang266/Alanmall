package com.itcrazy.alanmall.pay.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.itcrazy.alanmall.pay"})
public class AlanmallPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlanmallPayApplication.class, args);
    }


}
