package com.itcrazy.alanmall.order.manager;

import com.itcrazy.alanmall.order.dto.*;
import org.springframework.core.annotation.Order;

public interface IOrderService {
    CreateOrderResponse createOrder(CreateOrderRequest request);

    CancelOrderResponse cancelOrder(CancelOrderRequest request);


}
