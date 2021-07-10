package com.itcrazy.alanmall.common.exception;

import com.itcrazy.alanmall.common.result.AbstractResponse;
import com.itcrazy.alanmall.common.util.CommonCanstants;

/**
 * @Auther: mathyoung
 * @description: 异常抽象模板方法
 */
public abstract class AbstractExceptionTemplate {
    public static void wrapperHandlerException(AbstractResponse response, Exception e){
        try {
            ExceptionUtil.handlerException4biz(response,e);
        } catch (Exception ex) {
            response.setCode(CommonCanstants.SYSTEM_ERROR.getCode());
            response.setMsg(CommonCanstants.SYSTEM_ERROR.getMessage());
        }
    }

}
