package com.itcrazy.alanmall.common.util;

/**
 * @Auther: mathyoung
 * @description: 公共常量
 */
public enum CommonCanstants {
    SYSTEM_ERROR      ("001099", "系统错误");

    private String code;
    private String message;

    CommonCanstants(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
