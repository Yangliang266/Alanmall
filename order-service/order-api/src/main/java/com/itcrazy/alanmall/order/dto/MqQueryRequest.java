package com.itcrazy.alanmall.order.dto;

import com.itcrazy.alanmall.common.exception.ValidateException;
import com.itcrazy.alanmall.common.result.AbstractRequest;
import com.itcrazy.alanmall.order.constant.OrderRetCode;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @Auther: mathyoung
 * @description: mq 消息请求
 */
@Data
public class MqQueryRequest extends AbstractRequest {
    private Long msgId;

    @Override
    public void requestCheck() {
        if(null != msgId){
            throw new ValidateException(OrderRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(),OrderRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
