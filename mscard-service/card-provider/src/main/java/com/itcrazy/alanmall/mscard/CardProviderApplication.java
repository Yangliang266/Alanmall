package com.itcrazy.alanmall.mscard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.itcrazy.alanmall.common", "com.itcrazy.alanmall.mscard"})
@MapperScan({"com.itcrazy.alanmall.mscard.dao","com.itcrazy.alanmall.mscard.report"})
public class CardProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardProviderApplication.class, args);
    }

}
