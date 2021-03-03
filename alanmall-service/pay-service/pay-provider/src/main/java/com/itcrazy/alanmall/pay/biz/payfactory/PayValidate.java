package com.itcrazy.alanmall.pay.biz.payfactory;

import com.itcrazy.alanmall.common.result.AbstractRequest;
import org.springframework.stereotype.Component;

/**
 * @Auther: mathyoung
 * @description:
 */
public interface PayValidate {
    void check(AbstractRequest request);
}
