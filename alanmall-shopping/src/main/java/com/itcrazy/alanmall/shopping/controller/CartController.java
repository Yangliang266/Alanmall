package com.itcrazy.alanmall.shopping.controller;

import com.alibaba.fastjson.JSON;
import com.itcrazy.alanmall.common.result.ResponseData;
import com.itcrazy.alanmall.common.result.ResponseUtil;
import com.itcrazy.alanmall.shopping.constants.ShoppingRetCode;
import com.itcrazy.alanmall.shopping.dto.*;
import com.itcrazy.alanmall.shopping.form.CartForm;
import com.itcrazy.alanmall.shopping.manager.ICartService;
import com.itcrazy.alanmall.user.intercepter.TokenIntercepter;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("shopping")
public class CartController {
    @Reference(timeout = 3000)
    ICartService iCartService;

    // 添加到购物车
    @PostMapping("/carts")
    public ResponseData addToCart(@RequestBody CartForm cartForm) {
        // 传参
        AddCartRequest addCartRequest = new AddCartRequest();
        addCartRequest.setItemId(cartForm.getProductId());
        addCartRequest.setUserId(cartForm.getUserId());
        addCartRequest.setNum(cartForm.getProductNum());

        // 验证
        addCartRequest.requestCheck();

        // 加入redis缓存
        AddCartResponse addCartResponse = iCartService.addToCart(addCartRequest);


        return new ResponseUtil().setData(addCartResponse.getMsg());
    }

    // 获取购物车列表
    @GetMapping("/carts")
    public ResponseData carts(HttpServletRequest request) {
        // 获取之前存储的token信息 包含uid
        String userInfo = (String) request.getAttribute(TokenIntercepter.USER_INFO_KEY);

        // 获取userId 解析
        long uid = Long.parseLong(JSON.parseObject(userInfo).getString("uid"));

        CartListByIdRequest cartListByIdRequest = new CartListByIdRequest();
        cartListByIdRequest.setUserId(uid);
        CartListByIdResponse response = iCartService.getCartListById(cartListByIdRequest);

        if (response.getCode() == ShoppingRetCode.SUCCESS.getCode()) {
            return new ResponseUtil().setData(response.getCartProductDto());
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }

    // 删除购物车
    @DeleteMapping("/carts/{uid}/{pid}")
    public ResponseData deleteCarts(@PathVariable long uid, @PathVariable long pid) {
        DeleteCartItemRequest request = new DeleteCartItemRequest();
        request.setUserId(uid);
        request.setItemId(pid);

        DeleteCartItemResponse response = iCartService.deleteCartItem(request);

        if (ShoppingRetCode.SUCCESS.getCode() == response.getCode()) {
            return new ResponseUtil().setData(response.getMsg());
        }

        return new ResponseUtil().setErrorMsg(response.getMsg());
    }

}
