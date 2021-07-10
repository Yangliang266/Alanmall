package com.itcrazy.alanmall.tomcat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: mathyoung
 * @description:
 */
@RequestMapping("/test")
@RestController
public class Test {

    @RequestMapping("/tomcat")
    public String test() {
        return "success";
    }
}
