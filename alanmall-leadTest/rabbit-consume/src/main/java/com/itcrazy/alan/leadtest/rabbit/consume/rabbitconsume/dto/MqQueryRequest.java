package com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.dto;

import com.itcrazy.alanmall.common.result.AbstractRequest;
import lombok.Data;

/**
 * @Auther: mathyoung
 * @description: mq 消息请求
 */
@Data
public class MqQueryRequest extends AbstractRequest {
    private Long userId;

    @Override
    public void requestCheck() {
        if(null != userId){
        }
    }
}
