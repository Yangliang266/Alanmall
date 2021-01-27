package com.itcrazy.alanmall.user.service;

import com.itcrazy.alanmall.user.manager.ITestService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class TestImp implements ITestService {
    @Override
    public void Test() {
        System.out.println("hello");
    }
}
