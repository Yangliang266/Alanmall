package com.itcrazy.alanmall.user;

import com.itcrazy.alanmall.user.dto.KaptchaCodeRequest;
import com.itcrazy.alanmall.user.dto.KaptchaCodeResponse;

public interface IKaptchaService {
    /**
     * 获取验证码
     * @param kaptchaCodeRequest
     * @return
     */
    KaptchaCodeResponse getKaptchaCode(KaptchaCodeRequest kaptchaCodeRequest);

    /**
     * 验证验证码
     * @param kaptchaCodeRequest
     * @return
     */
    KaptchaCodeResponse validateKaptcha(KaptchaCodeRequest kaptchaCodeRequest);
}
