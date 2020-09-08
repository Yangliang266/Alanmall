package com.itcrazy.alanmall.test.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.itcrazy.alanmall.test")
public class AlanmallTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlanmallTestApplication.class, args);
    }

}
