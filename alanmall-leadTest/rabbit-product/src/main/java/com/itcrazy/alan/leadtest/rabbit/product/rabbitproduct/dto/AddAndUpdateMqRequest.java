package com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.dto;

import com.itcrazy.alanmall.common.result.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @Auther: mathyoung
 * @description: mq 添加
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AddAndUpdateMqRequest extends AbstractRequest {
    private Long userId;

    private String exchange;

    private String queue;

    private String tag;

    private Integer status;

    private Date created;

    private Date updated;

    @Override
    public void requestCheck() {

    }
}
