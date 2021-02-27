package com.itcrazy.alanmall.pay.biz.payconfig;

import com.github.wxpay.sdk.IWXPayDomain;
import com.github.wxpay.sdk.WXPayConstants;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;

/**
 * @Auther: mathyoung
 * @description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Service("WeChatPayConfig")
@PropertySource("classpath:WxPayConfig.properties")
public class WeChatPayConfig extends com.github.wxpay.sdk.WXPayConfig {
    //微信支付信息
    @Value("${payconfig.weixin.wxappId}")
    private String wxappId; //应用ID
    @Value("${payconfig.weixin.wxmchID}")
    private String wxmchID; //商户号
    @Value("${payconfig.weixin.wzappsecret}")
    private String wxappsecret; // //默认为微信证书base64证书密文
    @Value("${payconfig.weixin.wxmchsecret}")
    private String wxmchsecret; //
    @Value("${payconfig.weixin.wxkey}")
    private String wxkey; //秘钥
    @Value("${payconfig.weixin.wxnotifyUrl}")
    private String wxnotifyUrl; //回调地址
    @Value("${payconfig.weixin.wxcertPath}")
    private String wxcertPath; //证书路径
    //证书字节数组
    private byte[] certData;

    @Override
    protected String getAppID() {
        return this.wxappId;
    }

    @Override
    protected String getMchID() {
        return this.wxmchID;
    }

    @Override
    protected String getKey() {
        return this.wxkey;
    }

    @Override
    protected IWXPayDomain getWXPayDomain() {
        // 这个方法需要这样实现, 否则无法正常初始化WXPay
        return new IWXPayDomain() {
            @Override
            public void report(String domain, long elapsedTimeMillis, Exception ex) {
            }

            @Override
            public DomainInfo getDomain(com.github.wxpay.sdk.WXPayConfig wxPayConfig) {
                return new DomainInfo(WXPayConstants.DOMAIN_API,true);
            }
        };
    }


    /**
     * @Author mathyoung
     * @Description: 证书初始化
     * @Param: []
     * @Return: java.io.InputStream
     */
    @Override
    public InputStream getCertStream() {
        if (wxappsecret != null) {
            return new ByteArrayInputStream(Base64.getDecoder().decode(wxappsecret));
        } else {
            if(certData==null){
                synchronized (WeChatPayConfig.class){
                    try {
                        if(certData==null) {
                            File file = new File(wxcertPath);
                            InputStream certStream = new FileInputStream(file);
                            this.certData = new byte[(int) file.length()];
                            certStream.read(this.certData);
                            certStream.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return new ByteArrayInputStream(this.certData);
        }
    }


}
