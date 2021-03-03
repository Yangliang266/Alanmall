package com.itcrazy.alanmall.pay.biz.payconfig;

import com.itcrazy.alanmall.common.client.util.Signature;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Auther: mathyoung
 * @description:
 */
@Configuration("WeChatSignConfig")
@PropertySource("classpath:WxPayConfig.properties")
@Data
public class WeChatSignConfig {
    @Value("${payconfig.aes.skey}")
    private String skey;

    @Value("${payconfig.aes.salt}")
    private String salt;

    @Bean
    public Signature signature() {
        return new Signature(skey, salt);
    }
}
