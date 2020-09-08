package com.itcrazy.alanmall.user.inter;

import com.itcrazy.alanmall.user.dto.UserLoginRequest;
import com.itcrazy.alanmall.user.dto.UserLoginResponse;

public interface IUserLoginService {

    /**
     * 用户登录
     * @param userLoginRequest
     * @return
     */
    UserLoginResponse login(UserLoginRequest userLoginRequest);

    /**
     * redis 测试
     * @return
     */
    void redissonTest();

    String jedisTest();
}
