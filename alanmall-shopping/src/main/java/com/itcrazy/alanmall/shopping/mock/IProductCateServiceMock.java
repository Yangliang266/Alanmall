package com.itcrazy.alanmall.shopping.mock;

import com.itcrazy.alanmall.shopping.constants.ShoppingRetCode;
import com.itcrazy.alanmall.shopping.dto.AllProductCateRequest;
import com.itcrazy.alanmall.shopping.dto.AllProductCateResponse;
import com.itcrazy.alanmall.shopping.manager.IProductCateService;

public class IProductCateServiceMock implements IProductCateService {
    @Override
    public AllProductCateResponse getProductCate(AllProductCateRequest allProductCateRequest) {
        System.out.println("SYSTEM_TIMEOUT null");
        AllProductCateResponse response = new AllProductCateResponse();
        response.setCode(ShoppingRetCode.SYSTEM_TIMEOUT.getCode());
        response.setMsg(ShoppingRetCode.SYSTEM_TIMEOUT.getMessage());
        return response;
    }
}
