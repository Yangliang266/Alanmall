package com.itcrazy.alanmall.shopping.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.itcrazy.alanmall.shopping")
public class AlanmallShoppingApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AlanmallShoppingApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AlanmallShoppingApplication.class);
    }


}
