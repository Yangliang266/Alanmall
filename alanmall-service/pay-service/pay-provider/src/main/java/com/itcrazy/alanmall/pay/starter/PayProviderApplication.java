package com.itcrazy.alanmall.pay.starter;

import com.github.wxpay.sdk.WXPay;
import com.itcrazy.alanmall.pay.biz.payconfig.WeChatPayConfig;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.itcrazy.alanmall.pay","com.itcrazy.alanmall.common"})
@MapperScan("com.itcrazy.alanmall.pay.dal")
public class PayProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayProviderApplication.class, args);
	}

	@Bean
	public WXPay wxPay(WeChatPayConfig weixinPayConfig) throws Exception {
		
		return new WXPay(weixinPayConfig);
	}
}
