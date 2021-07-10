package com.itcrazy.alanmall.pay.service;

import com.alibaba.fastjson.JSON;
import com.itcrazy.alanmall.pay.biz.payfactory.BasePayment;
import com.itcrazy.alanmall.pay.dto.PaymentNotifyRequest;
import com.itcrazy.alanmall.pay.dto.PaymentNotifyResponse;
import com.itcrazy.alanmall.pay.dto.PaymentRequest;
import com.itcrazy.alanmall.pay.dto.PaymentResponse;
import com.itcrazy.alanmall.pay.manager.PayCoreService;
import com.itcrazy.alanmall.pay.util.ExceptionProcessorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: mathyoung
 * @description:
 */
@Service
@Slf4j
@DubboService
public class PayCoreServiceImp implements PayCoreService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PaymentResponse execPay(PaymentRequest request) {
        log.info("paymentResultExecPay request:{}", JSON.toJSONString(request));
        PaymentResponse response = new PaymentResponse();
        try {
            response = BasePayment.getInstance().get(request.getPayChannel()).process(request);
        }catch (Exception e) {
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }finally {
            log.info("paymentResultExecPay return result:{}", JSON.toJSONString(response));
        }
        return response;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PaymentNotifyResponse paymentResultNotify(PaymentNotifyRequest request) {
        log.info("paymentResultNotify request:{}", JSON.toJSONString(request));
        PaymentNotifyResponse response=new PaymentNotifyResponse();
        try{
            response = BasePayment.getInstance().get(request.getPayChannel()).completePayment(request);
        }catch (Exception e){
            log.error("paymentResultNotify occur exception:"+e);
            ExceptionProcessorUtils.wrapperHandlerException(response,e);
        }finally {
            log.info("paymentResultNotify return result:{}", JSON.toJSONString(response));
        }
        return response;

    }
}
