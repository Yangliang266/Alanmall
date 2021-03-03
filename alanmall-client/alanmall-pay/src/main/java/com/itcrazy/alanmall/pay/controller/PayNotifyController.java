package com.itcrazy.alanmall.pay.controller;

import com.alibaba.fastjson.JSON;
import com.itcrazy.alanmall.pay.dto.PaymentNotifyRequest;
import com.itcrazy.alanmall.pay.dto.PaymentNotifyResponse;
import com.itcrazy.alanmall.pay.manager.PayCoreService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Auther: mathyoung
 * @description:
 */
@RestController
@RequestMapping("/pay")
@Slf4j
public class PayNotifyController {
    @DubboReference(timeout = 3000)
    PayCoreService payCoreService;

    @RequestMapping("/wechatPayNotify")
    public String doWeChatPay(HttpServletRequest httpServletRequest) throws Exception {
        return commonWeChatDo("wechat_pay", httpServletRequest);
    }

    private String commonWeChatDo(String payChannel, HttpServletRequest httpServletRequest) throws Exception {
        log.info("{}异步回调", payChannel);
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;

        try {
            inputStream = httpServletRequest.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String readLine;
            while ((readLine = bufferedReader.readLine()) != null) {
                stringBuffer.append(readLine);
            }
            log.info("微信支付回调通知:{}", stringBuffer.toString());
        }catch (Exception e) {
            log.error("解析微信回调数据错误{}", e.getMessage());
            e.printStackTrace();
        }finally {
            if(null == bufferedReader && null == inputStream) {
                try {
                    inputStream.close();
                    bufferedReader.close();
                }catch (IOException e) {
                    e.printStackTrace();
                    log.error("关闭流错误{}", e.getMessage());
                }
            }
        }

        PaymentNotifyRequest paymentNotifyRequest = new PaymentNotifyRequest();
        paymentNotifyRequest.setPayChannel(payChannel);
        paymentNotifyRequest.setXml(stringBuffer.toString());
        PaymentNotifyResponse paymentNotifyResponse = payCoreService.paymentResultNotify(paymentNotifyRequest);
        log.info("{}微信通知结果返回:{}", payChannel, JSON.toJSONString(paymentNotifyResponse));
        return paymentNotifyResponse.getResult();

    }

}
