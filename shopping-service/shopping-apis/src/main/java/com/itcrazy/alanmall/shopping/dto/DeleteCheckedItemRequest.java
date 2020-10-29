package com.itcrazy.alanmall.shopping.dto;

import com.itcrazy.alanmall.common.exception.ValidateException;
import com.itcrazy.alanmall.common.result.AbstractRequest;
import com.itcrazy.alanmall.shopping.constants.ShoppingRetCode;
import lombok.Data;

@Data
public class DeleteCheckedItemRequest extends AbstractRequest {

    private Long userId;

    @Override
    public void requestCheck() {
        if(userId==null){
            throw new ValidateException(ShoppingRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(),ShoppingRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());

        }
    }
}
