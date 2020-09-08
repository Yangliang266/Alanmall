package com.itcrazy.alanmall.merchant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.itcrazy.alanmall.common", "com.itcrazy.alanmall.merchant"})
@MapperScan("com.itcrazy.alanmall.merchant.dao")
public class MerchantProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MerchantProviderApplication.class, args);
    }

}
