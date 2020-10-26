package com.itcrazy.alanmall.shopping.dto;

import com.itcrazy.alanmall.common.exception.ValidateException;
import com.itcrazy.alanmall.common.result.AbstractRequest;
import com.itcrazy.alanmall.shopping.constants.ShoppingRetCode;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class AddCartRequest extends AbstractRequest {
    private Long userId;
    private Long itemId;
    private Integer num;

    @Override
    public void requestCheck() {
        if(StringUtils.isBlank(userId.toString())
                && StringUtils.isBlank(userId.toString())
                && StringUtils.isBlank(userId.toString())) {
            throw new ValidateException(
                    ShoppingRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(),
                    ShoppingRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
