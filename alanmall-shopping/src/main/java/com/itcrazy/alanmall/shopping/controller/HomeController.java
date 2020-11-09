package com.itcrazy.alanmall.shopping.controller;

import com.itcrazy.alanmall.common.result.ResponseData;
import com.itcrazy.alanmall.common.result.ResponseUtil;
import com.itcrazy.alanmall.shopping.constants.ShoppingRetCode;
import com.itcrazy.alanmall.shopping.dto.HomePageResponse;
import com.itcrazy.alanmall.shopping.dto.NavListResponse;
import com.itcrazy.alanmall.shopping.manager.IContentService;
import com.itcrazy.alanmall.shopping.manager.IHomeService;
import com.itcrazy.alanmall.user.annotation.Anoymous;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/shopping")
@RestController
public class HomeController {
    @Reference(timeout = 3000)
    IHomeService iHomeService;

    @Reference(timeout = 3000)
    IContentService iContentService;

    @Anoymous
    @GetMapping("/homepage")
    public ResponseData homepage(){
        HomePageResponse response=iHomeService.home();
        if(response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
            return new ResponseUtil().setData(response.getPanelContentItemDtos());
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }

    @Anoymous
    @GetMapping("/navigation")
    public ResponseData navigate() {
        NavListResponse response = iContentService.queryNavList();

        if(response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
            return new ResponseUtil().setData(response.getPannelContentDtos());
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }
}
