package com.itcrazy.alanmall.order.dto;

import com.itcrazy.alanmall.common.result.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Auther: mathyoung
 * @description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderStatusResponse extends AbstractResponse {
    private Integer initNum = 0;

    private Integer payNum = 0;

    private Integer unPushNum = 0;

    private Integer pushNum = 0;

    private Integer successNum = 0;
}
