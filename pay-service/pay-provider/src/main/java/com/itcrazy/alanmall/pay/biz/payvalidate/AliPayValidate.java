package com.itcrazy.alanmall.pay.biz.payvalidate;

import com.itcrazy.alanmall.common.result.AbstractRequest;
import com.itcrazy.alanmall.pay.biz.payfactory.BaseValidate;
import org.springframework.stereotype.Service;

/**
 * @Auther: mathyoung
 * @description:
 */
@Service("AliPayValidate")
public class AliPayValidate extends BaseValidate {
    @Override
    public void specialValidate(AbstractRequest request) {
        System.out.println("alipay validate---------------------------------alipay validate");
    }
}
