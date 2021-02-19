package com.itcrazy.alanmall.shopping.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itcrazy.alanmall.common.result.ResponseData;
import com.itcrazy.alanmall.common.result.ResponseUtil;
import com.itcrazy.alanmall.order.dto.CancelOrderRequest;
import com.itcrazy.alanmall.order.dto.CancelOrderResponse;
import com.itcrazy.alanmall.order.dto.CreateOrderRequest;
import com.itcrazy.alanmall.order.dto.CreateOrderResponse;
import com.itcrazy.alanmall.order.manager.IOrderService;
import com.itcrazy.alanmall.shopping.constants.ShoppingRetCode;
import com.itcrazy.alanmall.user.intercepter.TokenIntercepter;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.alibaba.fastjson.JSON.parseObject;

/**
 * @Auther: mathyoung
 * @description:
 */
@RequestMapping("shopping")
@RestController
@Slf4j
public class OrderController {
    @DubboReference(timeout = 3000)
    IOrderService iOrderService;

    @PostMapping("/order")
    public ResponseData<String> createOrder(@RequestBody CreateOrderRequest request, HttpServletRequest httpServletRequest) {
        // 包含uid 的json字符串
        String userId = (String) httpServletRequest.getAttribute(TokenIntercepter.USER_INFO_KEY);
        JSONObject jsonObject = JSON.parseObject(userId);
        // 获取uid
        Object uidstr = jsonObject.get("uid");
        Long uid=Long.parseLong(uidstr.toString());
        request.setUserId(uid);
        CreateOrderResponse response = iOrderService.createOrder(request);
        if (ShoppingRetCode.SUCCESS.getCode().equals(response.getCode())) {
            return new ResponseUtil<String>().setData(response.getOrderId());
        }
        return new ResponseUtil<String>().setErrorMsg(response.getMsg());
    }

    @PutMapping("/order/{id}")
    public ResponseData<CancelOrderResponse> cancelOrder(@PathVariable String id) {
        CancelOrderRequest request =new CancelOrderRequest ();
        request.setOrderId(id);
        return new ResponseUtil<CancelOrderResponse>().setData(iOrderService.cancelOrder(request));
    }

}
