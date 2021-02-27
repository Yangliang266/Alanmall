package com.itcrazy.alanmall.shopping.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itcrazy.alanmall.common.result.ResponseData;
import com.itcrazy.alanmall.common.result.ResponseUtil;
import com.itcrazy.alanmall.order.dto.*;
import com.itcrazy.alanmall.order.manager.IOrderQueryService;
import com.itcrazy.alanmall.order.manager.IOrderService;
import com.itcrazy.alanmall.shopping.constants.ShoppingRetCode;
import com.itcrazy.alanmall.shopping.forms.OrderDetail;
import com.itcrazy.alanmall.shopping.forms.OrderPay;
import com.itcrazy.alanmall.user.intercepter.TokenIntercepter;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
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

    @DubboReference(timeout = 3000)
    IOrderQueryService iOrderQueryService;

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

    @GetMapping("/order/{id}")
    public ResponseData<OrderDetail> getOrderDetails(@PathVariable String id) {
        // 根据订单id 查询具体订单
        OrderDetailRequest request = new OrderDetailRequest();
        request.setOrderId(id);
        // 总订单详情
        OrderDetailResponse response  = iOrderQueryService.getOrderDetail(request);

        if (ShoppingRetCode.SUCCESS.getCode().equals(response.getCode())) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderTotal(response.getPayment());
            orderDetail.setUserId(response.getUserId());
            orderDetail.setUserName(response.getBuyerNick());
            orderDetail.setGoodsList(response.getOrderItemDto());
            orderDetail.setTel(response.getOrderShippingDto().getReceiverPhone());
            orderDetail.setStreetName(response.getOrderShippingDto().getReceiverAddress());
            return new ResponseUtil<OrderDetail>().setData(orderDetail);
        }
        return new ResponseUtil<OrderDetail>().setErrorMsg(response.getMsg());
    }

    @GetMapping("/order/status/{orderId}/{status}")
    public ResponseData<OrderDetailResponse> getOrderPayStatus(@PathVariable String orderId,@PathVariable Integer status) {
        // 根据订单id 查询具体订单
        OrderDetailRequest request = new OrderDetailRequest();
        request.setOrderId(orderId);
        request.setStatus(status);
        // 总订单详情
        OrderDetailResponse response  = iOrderQueryService.checkOrderPayStatus(request);

        if (ShoppingRetCode.SUCCESS.getCode().equals(response.getCode())) {
            return new ResponseUtil<OrderDetailResponse>().setData(response);
        }
        return new ResponseUtil<OrderDetailResponse>().setErrorMsg(response.getMsg());
    }

    @PutMapping("/order/{id}")
    public ResponseData<CancelOrderResponse> cancelOrder(@PathVariable String id) {
        CancelOrderRequest request =new CancelOrderRequest ();
        request.setOrderId(id);
        return new ResponseUtil<CancelOrderResponse>().setData(iOrderService.cancelOrder(request));
    }

}
