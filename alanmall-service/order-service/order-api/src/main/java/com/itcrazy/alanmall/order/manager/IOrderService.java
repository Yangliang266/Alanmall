package com.itcrazy.alanmall.order.manager;

import com.itcrazy.alanmall.order.dto.*;
import org.springframework.core.annotation.Order;

public interface IOrderService {
    CreateOrderResponse createOrder(CreateOrderRequest request);

    CancelOrderResponse cancelOrder(CancelOrderRequest request);

    DeleteOrderResponse deleteOrder(DeleteOrderRequest request);

    void updateOrder(Integer status,String orderId);
}
