package com.itcrazy.alanmall.user.dto;

import com.itcrazy.alanmall.common.exception.ValidateException;
import com.itcrazy.alanmall.common.result.AbstractRequest;
import com.itcrazy.alanmall.user.constants.SysRetCodeConstants;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class KaptchaCodeRequest extends AbstractRequest {
    // 为什么需要uuid 是否一个user 对应一个验证码
    private String uuid;

    private String code;

    @Override
    public void requestCheck() {
        if(StringUtils.isBlank(uuid)||StringUtils.isBlank(code)){
            throw new ValidateException(
                    SysRetCodeConstants.REQUEST_CHECK_FAILURE.getCode(),
                    SysRetCodeConstants.REQUEST_CHECK_FAILURE.getMessage());
        }
    }
}

