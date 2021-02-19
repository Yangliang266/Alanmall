package com.itcrazy.alanmall.shopping.forms;

import com.itcrazy.alanmall.order.dto.OrderItemDto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: mathyoung
 * @description: 传输数据载体
 */
@Data
public class OrderDetail {
    private String userName;
    private BigDecimal orderTotal;
    private long userId;
    private List<OrderItemDto> goodsList;
    private String tel;
    private String streetName;
}
