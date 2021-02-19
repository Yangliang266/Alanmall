package com.itcrazy.alanmall.order.dto;

import com.itcrazy.alanmall.common.result.AbstractResponse;
import lombok.Data;

import javax.annotation.security.DenyAll;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Auther: mathyoung
 * @description:
 */
@Data
public class OrderDetailResponse extends AbstractResponse {
    private String orderId;
    private BigDecimal payment;
    private Integer paymentType;
    private BigDecimal postFee;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private Date paymentTime;
    private Date consignTime;
    private Date endTime;
    private Date closeTime;
    private String shippingName;
    private String shippingCode;
    private Long userId;
    private String buyerMessage;
    private String buyerNick;
    private Integer buyerComment;
    private List<OrderItemDto> orderItemDto;
    private OrderShippingDto orderShippingDto;
}
