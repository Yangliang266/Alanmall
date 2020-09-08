package com.itcrazy.alanmall.common.result;

import lombok.Data;

/**
 * @author mathyoung
 * @Description
 * @ClassName ResponseData
 * @date 2020/7/8 17:17
 */
@Data
public class ResponseData<T> {
    private boolean success;

    private String message; //消息

    private int code;

    private T result; //返回的数据

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();
}
