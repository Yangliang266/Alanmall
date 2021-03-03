package com.itcrazy.alanmall.shopping.mock;

import com.itcrazy.alanmall.shopping.constants.ShoppingRetCode;
import com.itcrazy.alanmall.shopping.dto.NavListResponse;
import com.itcrazy.alanmall.shopping.manager.IContentService;

public class IContentServiceMock implements IContentService {
    @Override
    public NavListResponse queryNavList() {
        System.out.println("SYSTEM_TIMEOUT null");
        NavListResponse response = new NavListResponse();
        response.setCode(ShoppingRetCode.SYSTEM_TIMEOUT.getCode());
        response.setMsg(ShoppingRetCode.SYSTEM_TIMEOUT.getMessage());
        return response;
    }
}
