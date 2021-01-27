package com.itcrazy.alanmall.shopping.controller;

import com.itcrazy.alanmall.common.result.ResponseData;
import com.itcrazy.alanmall.common.result.ResponseUtil;
import com.itcrazy.alanmall.shopping.constants.ShoppingRetCode;
import com.itcrazy.alanmall.shopping.dto.*;
import com.itcrazy.alanmall.shopping.forms.PageInfo;
import com.itcrazy.alanmall.shopping.forms.PageResponse;
import com.itcrazy.alanmall.shopping.manager.IProductService;
import com.itcrazy.alanmall.user.annotation.Anoymous;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/shopping")
@RestController
public class ProductController {

    @DubboReference
    IProductService iProductService;

    @Anoymous
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

    @Anoymous
    @GetMapping("/goods")
    public ResponseData goods(PageInfo pageInfo) {
        AllProductRequest request = new AllProductRequest();
        request.setCid(pageInfo.getCid());
        request.setPage(pageInfo.getPage());
        request.setPriceGt(pageInfo.getPriceGt());
        request.setPriceLte(pageInfo.getPriceLte());
        request.setSize(pageInfo.getSize());
        request.setSort(pageInfo.getSort());

        AllProductResponse response=iProductService.getAllProduct(request);
        if(response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
            PageResponse pageResponse=new PageResponse();
            pageResponse.setData(response.getProductDtoList());
            pageResponse.setTotal(response.getTotal());
            return new ResponseUtil().setData(pageResponse);
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }

    @Anoymous
    @GetMapping("/recommend")
    public ResponseData recommend() {
        RecommendResponse response = iProductService.recommend();

        if(response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
            return new ResponseUtil().setData(response.getPanelDtos());
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }

}
