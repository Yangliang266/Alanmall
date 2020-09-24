package com.itcrazy.alanmall.user.controller;

import com.itcrazy.alanmall.user.ITestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test {
    @Reference
//    IUserLoginService iUserLoginService;
    ITestService iTestService;

    @GetMapping("/test")
    public void test() {
        iTestService.Test();
    }
}
