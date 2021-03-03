package com.itcrazy.alanmall.shopping.dto;

import com.itcrazy.alanmall.common.exception.ValidateException;
import com.itcrazy.alanmall.common.result.AbstractRequest;
import com.itcrazy.alanmall.shopping.constants.ShoppingRetCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClearCartItemRequest extends AbstractRequest {

    private static final long serialVersionUID = 6502418352083841432L;
    private Long userId;
    private List<Long> productIds;
    @Override
    public void requestCheck() {
        if(userId==null){
            throw new ValidateException(ShoppingRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(),ShoppingRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
