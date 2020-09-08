package com.itcrazy.alanmall.user.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

// com.itcrazy.alanmall.user.dal.mapper
@SpringBootApplication
@ComponentScan(basePackages = {"com.itcrazy.alanmall.user","com.itcrazy.alanmall.common"})
@MapperScan("com.itcrazy.alanmall.user.dal")
public class UserProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserProviderApplication.class, args);
    }

}
