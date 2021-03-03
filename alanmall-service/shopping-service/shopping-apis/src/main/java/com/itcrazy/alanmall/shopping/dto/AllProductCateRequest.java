package com.itcrazy.alanmall.shopping.dto;


import com.itcrazy.alanmall.common.result.AbstractRequest;
import lombok.Data;

@Data
public class AllProductCateRequest extends AbstractRequest {
    private String sort;

    @Override
    public void requestCheck() {

    }
}
