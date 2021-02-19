package com.itcrazy.alanmall.order.manager;

import com.itcrazy.alanmall.order.dto.CancelOrderRequest;
import com.itcrazy.alanmall.order.dto.CancelOrderResponse;
import com.itcrazy.alanmall.order.dto.CreateOrderRequest;
import com.itcrazy.alanmall.order.dto.CreateOrderResponse;

public interface IOrderService {
    CreateOrderResponse createOrder(CreateOrderRequest request);

    CancelOrderResponse cancelOrder(CancelOrderRequest request);
}
