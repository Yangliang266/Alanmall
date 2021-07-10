package com.itcrazy.alanmall.pay.biz.payfactory;

import com.itcrazy.alanmall.common.result.AbstractRequest;

/**
 * @Auther: mathyoung
 * @description:
 */
public abstract class BaseValidate implements PayValidate {
    @Override
    public void check(AbstractRequest request) {
        //基本参数校验
//        ParamValidatorUtils.validateV2(request);
        //特殊校验
        specialValidate(request);
    }

    public abstract void specialValidate(AbstractRequest request);
}
