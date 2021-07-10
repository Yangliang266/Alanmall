package com.itcrazy.alanmall.user.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.itcrazy.alanmall.user"})
public class AlanmallUserApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AlanmallUserApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AlanmallUserApplication.class);
    }

}
