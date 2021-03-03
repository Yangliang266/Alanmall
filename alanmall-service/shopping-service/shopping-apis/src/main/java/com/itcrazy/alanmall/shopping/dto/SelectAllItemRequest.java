package com.itcrazy.alanmall.shopping.dto;

import com.itcrazy.alanmall.common.exception.ValidateException;
import com.itcrazy.alanmall.common.result.AbstractRequest;
import com.itcrazy.alanmall.shopping.constants.ShoppingRetCode;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class SelectAllItemRequest extends AbstractRequest {
    private Long userId;
    private String check;

    @Override
    public void requestCheck() {
        if (null == userId || StringUtils.isBlank(check)) {
            throw  new ValidateException(ShoppingRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(),ShoppingRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
