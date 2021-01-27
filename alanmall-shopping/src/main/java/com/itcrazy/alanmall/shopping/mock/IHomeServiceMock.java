package com.itcrazy.alanmall.shopping.mock;

import com.itcrazy.alanmall.shopping.constants.ShoppingRetCode;
import com.itcrazy.alanmall.shopping.dto.HomePageResponse;
import com.itcrazy.alanmall.shopping.manager.IHomeService;

public class IHomeServiceMock implements IHomeService {
    @Override
    public HomePageResponse home() {
        System.out.println("SYSTEM_TIMEOUT");
        HomePageResponse response=new HomePageResponse();
        response.setCode(ShoppingRetCode.SYSTEM_TIMEOUT.getCode());
        response.setMsg(ShoppingRetCode.SYSTEM_TIMEOUT.getMessage());
        return response;
    }
}
