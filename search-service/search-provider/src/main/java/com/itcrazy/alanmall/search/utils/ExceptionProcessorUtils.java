package com.itcrazy.alanmall.search.utils;


import com.itcrazy.alanmall.common.exception.ExceptionUtil;
import com.itcrazy.alanmall.common.result.AbstractResponse;
import com.itcrazy.alanmall.search.consts.SearchRetCode;

public class ExceptionProcessorUtils {

    public static void wrapperHandlerException(AbstractResponse response, Exception e){
        try {
            ExceptionUtil.handlerException4biz(response,e);
        } catch (Exception ex) {
            response.setCode(SearchRetCode.SYSTEM_ERROR.getCode());
            response.setMsg(SearchRetCode.SYSTEM_ERROR.getMsg());
        }
    }
}
