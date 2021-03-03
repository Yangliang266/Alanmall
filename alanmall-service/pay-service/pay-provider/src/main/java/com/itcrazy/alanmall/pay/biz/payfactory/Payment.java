package com.itcrazy.alanmall.pay.biz.payfactory;

import com.itcrazy.alanmall.common.result.AbstractRequest;
import com.itcrazy.alanmall.common.result.AbstractResponse;
import org.springframework.stereotype.Component;

/**
 * @Auther: mathyoung
 * @description:支付接口
 */
public interface Payment {
    /**
     * @Author mathyoung
     * @Description: 微信交易执行
     * @Param: [request]
     * @Return: T
     */
    <T extends AbstractResponse> T process(AbstractRequest request) throws Exception;

    /**
     * @Author mathyoung
     * @Description: 微信交易结果处理
     * @Param: [request]
     * @Return: T
     */
    <T extends AbstractResponse> T completePayment(AbstractRequest request) throws Exception;
}
