package com.itcrazy.alanmall.pay.biz.payconfig;

import com.github.wxpay.sdk.WXPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: mathyoung
 * @description:
 */
@Configuration
public class WechatPayUtil {
    @Autowired
    private WeChatPayConfig weChatPayConfig;

    @Bean
    public WXPay wxPay() throws Exception {
        return new WXPay(weChatPayConfig);
    }
}
