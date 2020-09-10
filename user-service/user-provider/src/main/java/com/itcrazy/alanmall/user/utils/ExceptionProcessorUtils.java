package com.itcrazy.alanmall.user.utils;


import com.itcrazy.alanmall.common.exception.ExceptionUtil;
import com.itcrazy.alanmall.common.result.AbstractResponse;
import com.itcrazy.alanmall.user.constants.SysRetCodeConstants;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/7/22-15:48
 */
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
