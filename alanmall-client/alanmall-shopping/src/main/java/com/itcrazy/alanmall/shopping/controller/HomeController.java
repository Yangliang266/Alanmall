package com.itcrazy.alanmall.shopping.controller;

import com.itcrazy.alanmall.common.result.ResponseData;
import com.itcrazy.alanmall.common.result.ResponseUtil;
import com.itcrazy.alanmall.shopping.constants.ShoppingRetCode;
import com.itcrazy.alanmall.shopping.dto.AllProductCateRequest;
import com.itcrazy.alanmall.shopping.dto.AllProductCateResponse;
import com.itcrazy.alanmall.shopping.dto.HomePageResponse;
import com.itcrazy.alanmall.shopping.dto.NavListResponse;
import com.itcrazy.alanmall.shopping.manager.IContentService;
import com.itcrazy.alanmall.shopping.manager.IHomeService;
import com.itcrazy.alanmall.shopping.manager.IProductCateService;
import com.itcrazy.alanmall.user.annotation.Anoymous;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/shopping")
@RestController
public class HomeController {
    @DubboReference(mock = "com.itcrazy.alanmall.shopping.mock.IHomeServiceMock")
    IHomeService iHomeService;

    @DubboReference(mock = "com.itcrazy.alanmall.shopping.mock.IContentServiceMock")
    IContentService iContentService;

    @DubboReference(mock = "com.itcrazy.alanmall.shopping.mock.IProductCateServiceMock")
    IProductCateService iProductCateService;

    @Anoymous
    @GetMapping("/homepage")
    public ResponseData homepage() {
        HomePageResponse response=iHomeService.home();
        if(ShoppingRetCode.SUCCESS.getCode().equals(response.getCode())) {
            return new ResponseUtil().setData(response.getPanelContentItemDtos());
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }

    @Anoymous
    @GetMapping("/navigation")
    public ResponseData navigate() {
        NavListResponse response = iContentService.queryNavList();

        if(ShoppingRetCode.SUCCESS.getCode().equals(response.getCode())) {
            return new ResponseUtil().setData(response.getPannelContentDtos());
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }

    @Anoymous
    @GetMapping("/categories")
    public  ResponseData productCates(@RequestParam(value = "sort", required = false, defaultValue = "1") String sort) {
        AllProductCateRequest request = new AllProductCateRequest();
        request.setSort(sort);

        AllProductCateResponse response = iProductCateService.getProductCate(request);

        if(ShoppingRetCode.SUCCESS.getCode().equals(response.getCode())) {
            return new ResponseUtil().setData(response.getProductCateDtoList());
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());

    }
}
