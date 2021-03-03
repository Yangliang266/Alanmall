package com.itcrazy.alanmall.users.controller;

//import com.itcrazy.alanmall.user.IUserLoginService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class Test {
//    @Reference
//    IUserLoginService iUserLoginService;
//
//    @GetMapping("/test")
//    public void test() {
//        iUserLoginService.jedisTest();
//    }
    @GetMapping("/test")
    public String test() {
        return "string";
    }

}
