package com.itcrazy.alanmall.pay.biz.payment;

import com.itcrazy.alanmall.common.result.AbstractRequest;
import com.itcrazy.alanmall.common.result.AbstractResponse;
import com.itcrazy.alanmall.pay.biz.paycontext.AliPayContext;
import com.itcrazy.alanmall.pay.biz.paycontext.Context;
import com.itcrazy.alanmall.pay.biz.payfactory.BasePayment;
import com.itcrazy.alanmall.pay.biz.payfactory.PayValidate;
import com.itcrazy.alanmall.pay.constants.PayChannelEnum;
import com.itcrazy.alanmall.pay.dto.PaymentRequest;
import com.itcrazy.alanmall.pay.dto.PaymentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: mathyoung
 * @description:
 */
@Service("AliPayment")
@Slf4j
public class AliPayment extends BasePayment {
    @Resource(name = "AliPayValidate")
    PayValidate validate;

    @Override
    protected String getPayChannel() {
        return PayChannelEnum.ALI_PAY.getCode();
    }

    @Override
    protected PayValidate paramValidate() {
        return validate;
    }

    @Override
    protected Context createContext(AbstractRequest request) {
        // test
        PaymentRequest paymentRequest = (PaymentRequest) request;
        AliPayContext context = new AliPayContext();
        context.setTest(paymentRequest.getPayChannel());
        return context;
    }

    @Override
    protected void afterProcess(AbstractRequest request, AbstractResponse response, Context context) {
        log.info("afterProcess:" + ((AliPayContext) context).getTest());
    }

    @Override
    protected AbstractResponse generalProcess(Context context) {
        PaymentResponse response = new PaymentResponse();
        AliPayContext chatPayContext = (AliPayContext) context;
        response.setMsg(chatPayContext.getTest());
        return response;
    }

    @Override
    protected void beforePrepare(Context context) {
        log.info("Aliprepare:" + ((AliPayContext) context).getTest());
    }

    @Override
    public <T extends AbstractResponse> T completePayment(AbstractRequest request) {
        return null;
    }
}
