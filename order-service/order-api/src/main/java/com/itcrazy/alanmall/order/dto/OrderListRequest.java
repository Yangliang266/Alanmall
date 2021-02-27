package com.itcrazy.alanmall.order.dto;

import com.itcrazy.alanmall.common.exception.ValidateException;
import com.itcrazy.alanmall.common.result.AbstractRequest;
import com.itcrazy.alanmall.order.constant.OrderRetCode;
import lombok.Data;

@Data
public class OrderListRequest extends AbstractRequest {

    private Long userId;
    private Integer page;
    private Integer size;
    private String sort;

    @Override
    public void requestCheck() {
        if(page == null || page < 1){
            page = 1;
        }
        if(size == null || size < 1){
            size = 5;
        }
        if(userId==null){
            throw new ValidateException(OrderRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(),OrderRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());

        }
    }
}
