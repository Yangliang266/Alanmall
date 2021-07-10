package com.itcrazy.alanmall.tomcat.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.itcrazy.alanmall.tomcat"})
@MapperScan("com.itcrazy.alanmall.tomcat.dal")
//@EnableCaching
public class TomcatProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(TomcatProviderApplication.class, args);
	}

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(TomcatProviderApplication.class);
//	}
}
