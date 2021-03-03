package com.itcrazy.alanmall.pay.biz.payconfig;

import com.alipay.easysdk.kernel.Config;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * @Auther: mathyoung
 * @description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@PropertySource("classpath:alipayconfig.properties")
@Configuration
public class AliPayConfig extends Config {
    @Value("${alipay.appId}")
    private String appId;
    @Value("${alipay.protocol}")
    private String protocol;
    @Value("${alipay.gatewayHost}")
    private String gatewayHost;
    @Value("${alipay.signType}")
    private String signType;
    @Value("${alipay.merchantPrivateKey}")
    private String merchantPrivateKey;
    @Value("${alipay.merchantCertPath}")
    private String merchantCertPath;
    @Value("${alipay.alipayCertPath}")
    private String alipayCertPath;
    @Value("${alipay.alipayRootCertPath}")
    private String alipayRootCertPath;
    @Value("${alipay.notifyUrl}")
    private String notifyUrl;
    @Value("${alipay.encryptKey}")
    private String encryptKey;

    @Bean
    public Config getOptions() {
        Config config = new Config();
        config.protocol = this.protocol;
        config.gatewayHost = this.gatewayHost;
        config.signType = this.signType;
        config.appId = this.appId;
        // 为避免私钥随源码泄露，推荐从文件中读取私钥字符串而不是写入源码中
        config.merchantPrivateKey = this.merchantPrivateKey;
        //注：证书文件路径支持设置为文件系统中的路径或CLASS_PATH中的路径，优先从文件系统中加载，加载失败后会继续尝试从CLASS_PATH中加载
        config.merchantCertPath = this.merchantCertPath;
        config.alipayCertPath = this.alipayCertPath;
        config.alipayRootCertPath = this.alipayRootCertPath;
        //注：如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
        // config.alipayPublicKey = "<-- 请填写您的支付宝公钥，例如：MIIBIjANBg... -->";
        //可设置异步通知接收服务地址（可选）
        config.notifyUrl = this.notifyUrl;
        //可设置AES密钥，调用AES加解密相关接口时需要（可选）
        config.encryptKey = this.encryptKey;
        return config;
    }
}
