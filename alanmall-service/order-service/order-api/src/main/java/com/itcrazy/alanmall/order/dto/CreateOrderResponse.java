package com.itcrazy.alanmall.order.dto;

import com.itcrazy.alanmall.common.result.AbstractResponse;
import lombok.Data;

@Data
public class CreateOrderResponse extends AbstractResponse {
    private String orderId;

}
