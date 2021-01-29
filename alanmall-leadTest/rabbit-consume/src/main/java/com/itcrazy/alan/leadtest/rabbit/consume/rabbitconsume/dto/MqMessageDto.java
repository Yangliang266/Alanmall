package com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: mathyoung
 * @description: mq dto
 */
@Data
public class MqMessageDto {
    private Long userId;

    private String exchange;

    private String queue;

    private String tag;

    private Integer status;

    private Date created;

    private Date updated;
}
