package com.itcrazy.alanmall.user.service;

import com.itcrazy.alanmall.user.ITestService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class TestImp implements ITestService {
    @Override
    public void Test() {
        System.out.println("hello");
    }
}
