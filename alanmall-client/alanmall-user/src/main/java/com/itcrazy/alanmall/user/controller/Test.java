package com.itcrazy.alanmall.user.controller;

import com.itcrazy.alanmall.user.annotation.Anoymous;
import com.itcrazy.alanmall.user.manager.ITestService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Test {
//    @DubboReference
//    IUserLoginService iUserLoginService;
//    ITestService iTestService;

//    @Anoymous
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
