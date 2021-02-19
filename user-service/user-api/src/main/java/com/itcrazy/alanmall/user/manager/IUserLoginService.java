package com.itcrazy.alanmall.user.manager;

import com.itcrazy.alanmall.user.dto.CheckAuthRequest;
import com.itcrazy.alanmall.user.dto.CheckAuthResponse;
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
     * token 验证
     * @param checkAuthRequest
     * @return
     */
    CheckAuthResponse validToken(CheckAuthRequest checkAuthRequest);


}
