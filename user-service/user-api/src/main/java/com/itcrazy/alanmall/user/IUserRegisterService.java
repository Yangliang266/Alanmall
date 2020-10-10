package com.itcrazy.alanmall.user;

import com.itcrazy.alanmall.user.dto.UserRegisterRequest;
import com.itcrazy.alanmall.user.dto.UserRegisterResponse;

public interface IUserRegisterService {
    UserRegisterResponse register(UserRegisterRequest userRegisterRequest);
}
