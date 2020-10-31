package com.itcrazy.alanmall.shopping.controller;

import com.itcrazy.alanmall.common.result.ResponseData;
import com.itcrazy.alanmall.common.result.ResponseUtil;
import com.itcrazy.alanmall.shopping.constants.ShoppingRetCode;
import com.itcrazy.alanmall.shopping.dto.ProductDetailRequest;
import com.itcrazy.alanmall.shopping.dto.ProductDetailResponse;
import com.itcrazy.alanmall.shopping.manager.IProductService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/shopping")
@RestController
public class ProductController {

    @Reference(timeout = 3000)
    IProductService iProductService;

    @GetMapping("/product/{id}")
    public ResponseData product(@PathVariable long id) {
        ProductDetailRequest request = new ProductDetailRequest();
        request.setId(id);
        request.requestCheck();
        ProductDetailResponse response = iProductService.getProductDetail(request);
        if(response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
            return new ResponseUtil().setData(response.getProductDetailDto());
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }


}
