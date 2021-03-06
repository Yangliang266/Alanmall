package com.itcrazy.alanmall.order.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Auther: mathyoung
 * @description:
 */
@Data
public class OrderItemDto implements Serializable {

    private String id;
    private String itemId;
    private String orderId;
    private Integer status;
    private Integer num;
    private String title;
    private BigDecimal price;
    private BigDecimal totalFee;
    private String picPath;
}
