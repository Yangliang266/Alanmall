package com.itcrazy.alanmall.user.utils;

import com.itcrazy.alanmall.common.exception.ExceptionUtil;
import com.itcrazy.alanmall.common.result.AbstractResponse;
import com.itcrazy.alanmall.user.constants.SysRetCodeConstants;

public class ExceptionProcessorUtils {

    public static void wrapperHandlerException(AbstractResponse response, Exception e){
        try {
            ExceptionUtil.handlerException4biz(response,e);
        } catch (Exception ex) {
            response.setCode(SysRetCodeConstants.SYSTEM_ERROR.getCode());
            response.setMsg(SysRetCodeConstants.SYSTEM_ERROR.getMessage());
        }
    }
}
