package com.itcrazy.alanmall.pay.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.itcrazy.alanmall.pay"})
public class AlanmallPayApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AlanmallPayApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AlanmallPayApplication.class);
    }
}
