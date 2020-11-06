package com.itcrazy.alanmall.shopping.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itcrazy.alanmall.common.result.ResponseData;
import com.itcrazy.alanmall.common.result.ResponseUtil;
import com.itcrazy.alanmall.shopping.constants.ShoppingRetCode;
import com.itcrazy.alanmall.shopping.forms.AddressForm;
import com.itcrazy.alanmall.user.IAddressService;
import com.itcrazy.alanmall.user.dto.*;
import com.itcrazy.alanmall.user.intercepter.TokenIntercepter;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/shopping")
@Slf4j
public class AddressController {
    @Reference(timeout = 3000)
    IAddressService iAddressService;

    @GetMapping("/addresses")
    public ResponseData addressList(HttpServletRequest request) {
        GetAddressRequest getAddressRequest = new GetAddressRequest();
        // 获取uid
        String info = (String) request.getAttribute(TokenIntercepter.USER_INFO_KEY);
        JSONObject object = JSON.parseObject(info);
        Long uid = Long.parseLong(object.get("uid").toString());
        getAddressRequest.setUserId(uid);

        GetAddressResponse addressResponse = iAddressService.getAddressDetails(getAddressRequest);
        if (addressResponse.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
            return new ResponseUtil().setData(addressResponse.getAddressDtos(),addressResponse.getMsg());
        }
        return  new ResponseUtil().setErrorMsg(addressResponse.getMsg());
    }

    // 添加地址信息
    @PostMapping("/addresses")
    public ResponseData addAddress(@RequestBody AddressForm addressForm, HttpServletRequest servletRequest) {
        String userInfo = (String) servletRequest.getAttribute(TokenIntercepter.USER_INFO_KEY);
        JSONObject object = JSON.parseObject(userInfo);
        Long uid = Long.parseLong(object.get("uid").toString());

        AddressAddRequest request = new AddressAddRequest();
        request.setUserId(addressForm.getAddressId());
        request.setStreetName(addressForm.getStreetName());
        request.setTel(addressForm.getTel());
        request.setUserName(addressForm.getUserName());
        request.setUserId(uid);
        request.setIsDefault(addressForm.is_Default() ? 1 : null);

        AddressAddResponse response = iAddressService.addAddress(request);

        if (response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
            return new ResponseUtil().setData(response.getMsg());
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }

    // 更新地址信息
    @PutMapping("/addresses")
    public ResponseData updateAddress(@RequestBody AddressForm addressForm, HttpServletRequest servletRequest) {
        String userInfo = (String) servletRequest.getAttribute(TokenIntercepter.USER_INFO_KEY);
        JSONObject object = JSON.parseObject(userInfo);
        Long uid = Long.parseLong(object.get("uid").toString());

        AddressUpdateRequest request = new AddressUpdateRequest();
        request.setStreetName(addressForm.getStreetName());
        request.setTel(addressForm.getTel());
        request.setUserName(addressForm.getUserName());
        request.setUserId(uid);
        request.setAddressId(addressForm.getAddressId());
        request.setIsDefault(addressForm.is_Default() ? 1 : null);

        AddressUpdateResponse response = iAddressService.updateAddress(request);

        if (response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
            return new ResponseUtil().setData(response.getMsg());
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }

    @DeleteMapping("/addresses/{userId}/{addressId}")
    public ResponseData deleteAddress(@PathVariable long userId,@PathVariable long addressId) {
        DeleteAddressRequest request = new DeleteAddressRequest();
        request.setUserId(userId);
        request.setAddressId(addressId);
        DeleteAddressResponse response = iAddressService.deleteAddress(request);

        if (response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
            return new ResponseUtil().setData(response.getMsg());
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }

}
