package com.itcrazy.alanmall.shopping.dto;

import com.itcrazy.alanmall.common.exception.ValidateException;
import com.itcrazy.alanmall.common.result.AbstractRequest;
import com.itcrazy.alanmall.shopping.constants.ShoppingRetCode;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class ProductDetailRequest extends AbstractRequest {

    private Long id;

    @Override
    public void requestCheck() {
        if(id==null){
            throw new ValidateException(ShoppingRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(), ShoppingRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
