package com.itcrazy.alanmall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

// com.itcrazy.alanmall.user.dal.mapper
@SpringBootApplication
@ComponentScan(basePackages = {"com.itcrazy.alanmall.common", "com.itcrazy.alanmall.user"})
@MapperScan("com.itcrazy.alanmall.user.dao")
public class UserProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserProviderApplication.class, args);
    }

}
