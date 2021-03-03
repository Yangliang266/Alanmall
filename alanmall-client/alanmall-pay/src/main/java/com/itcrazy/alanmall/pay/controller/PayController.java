package com.itcrazy.alanmall.pay.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itcrazy.alanmall.common.client.util.IPUtil;
import com.itcrazy.alanmall.common.result.ResponseData;
import com.itcrazy.alanmall.common.result.ResponseUtil;
import com.itcrazy.alanmall.pay.constants.PayReturnCodeEnum;
import com.itcrazy.alanmall.pay.dto.PaymentRequest;
import com.itcrazy.alanmall.pay.dto.PaymentResponse;
import com.itcrazy.alanmall.pay.form.PayForm;
import com.itcrazy.alanmall.pay.manager.PayCoreService;
import com.itcrazy.alanmall.user.intercepter.TokenIntercepter;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: mathyoung
 * @description:
 */
@RestController
@RequestMapping("/cashier")
@Slf4j
public class PayController {
    @DubboReference(timeout = 3000)
    PayCoreService payCoreService;

    @PostMapping("/pay")
    public ResponseData<PaymentResponse> cashier(@RequestBody PayForm payForm, HttpServletRequest httpServletRequest) {
        // 获取用户id
        String userInfo=(String)httpServletRequest.getAttribute(TokenIntercepter.USER_INFO_KEY);
        JSONObject object= JSON.parseObject(userInfo);
        Long uid=Long.parseLong(object.get("uid").toString());
        // 表单赋值
        PaymentRequest request = new PaymentRequest();
        request.setUserId(uid);
        request.setOrderFee(payForm.getMoney());
        request.setPayChannel(payForm.getPayType());
        request.setSubject(payForm.getInfo());
        request.setTradeNo(payForm.getOrderId());
        request.setTotalFee(payForm.getMoney());
        request.setSpbillCreateIp(IPUtil.getRemortIP(httpServletRequest));

        PaymentResponse response = payCoreService.execPay(request);
        log.info("微信二维码 payCoreService.result:{}",response);
        if(response.getCode().equals(PayReturnCodeEnum.SUCCESS.getCode())){
            return new ResponseUtil<PaymentResponse>().setData(response);
        }
        return new ResponseUtil<PaymentResponse>().setErrorMsg(response.getMsg());

    }
}
