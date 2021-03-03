package com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.dto;

import com.itcrazy.alanmall.common.result.AbstractResponse;
import lombok.Data;

/**
 * @Auther: mathyoung
 * @description: mq 消息响应
 */
@Data
public class MqResponse extends AbstractResponse {
    private MqMessageDto messageDto;
}
