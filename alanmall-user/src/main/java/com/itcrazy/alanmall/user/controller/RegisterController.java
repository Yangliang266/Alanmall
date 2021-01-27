package com.itcrazy.alanmall.user.controller;

import com.itcrazy.alanmall.common.result.ResponseData;
import com.itcrazy.alanmall.common.result.ResponseUtil;
import com.itcrazy.alanmall.common.util.CookieUtil;
import com.itcrazy.alanmall.user.annotation.Anoymous;
import com.itcrazy.alanmall.user.constants.SysRetCodeConstants;
import com.itcrazy.alanmall.user.dto.KaptchaCodeRequest;
import com.itcrazy.alanmall.user.dto.KaptchaCodeResponse;
import com.itcrazy.alanmall.user.dto.UserRegisterRequest;
import com.itcrazy.alanmall.user.dto.UserRegisterResponse;
import com.itcrazy.alanmall.user.manager.IKaptchaService;
import com.itcrazy.alanmall.user.manager.IUserRegisterService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class RegisterController {
    @DubboReference
    IKaptchaService kaptchaService;

    @DubboReference
    IUserRegisterService iUserRegisterService;

    @PostMapping("/register")
    @Anoymous
    public ResponseData register(@RequestBody Map<String,String> map, HttpServletRequest request) {
        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
        // check username passworld
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setUserName(map.get("userName"));
        userRegisterRequest.setUserPwd(map.get("userPwd"));
        userRegisterRequest.setEmail(map.get("email"));
        userRegisterRequest.requestCheck();

        // check imgCode
        KaptchaCodeRequest kaptchaCodeRequest = new KaptchaCodeRequest();
        String uuid = CookieUtil.getCookieValue(request, "kaptcha_uuid");
        kaptchaCodeRequest.setUuid(uuid);
        kaptchaCodeRequest.setCode(map.get("captcha"));
        KaptchaCodeResponse kaptchaCodeResponse = kaptchaService.validateKaptcha(kaptchaCodeRequest);

        // register user
        if (kaptchaCodeResponse.getCode().equals(SysRetCodeConstants.SUCCESS.getCode())) {
            // imgCode验证通过
            userRegisterResponse = iUserRegisterService.register(userRegisterRequest);

            if(userRegisterResponse.getCode().equals(SysRetCodeConstants.SUCCESS.getCode())) {
                return new ResponseUtil().setData(null);
            }
            // 返回用户注册错误
            return new ResponseUtil<>().setErrorMsg(userRegisterResponse.getMsg());
        }

        // 返回code验证错误
        return new ResponseUtil<>().setErrorMsg(kaptchaCodeResponse.getMsg());
    }
}
