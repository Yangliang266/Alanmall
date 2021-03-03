package com.itcrazy.alanmall.order.dto;

import com.itcrazy.alanmall.common.result.AbstractResponse;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: mathyoung
 * @description: mq 消息响应
 */
@Data
public class MqResponse extends AbstractResponse {
    private MqMessageDto messageDto;
}
