package com.itcrazy.alanmall.user.dto;

import com.itcrazy.alanmall.common.result.AbstractResponse;
import lombok.Data;

@Data
public class KaptchaCodeResponse extends AbstractResponse {
    private String imageCode;

    private String uuid;

}
