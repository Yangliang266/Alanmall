package com.itcrazy.alanmall.search.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.itcrazy.alanmall.search.dao.persistence")
@ComponentScan(basePackages = {"com.itcrazy.alanmall.search","com.itcrazy.alanmall.common"})
@EnableElasticsearchRepositories(basePackages = "com.itcrazy.alanmall.search.es.reponsitory")
public class SearchProviderApplication {
	public static void main(String[] args) {
		SpringApplication.run(SearchProviderApplication.class, args);
	}

}
