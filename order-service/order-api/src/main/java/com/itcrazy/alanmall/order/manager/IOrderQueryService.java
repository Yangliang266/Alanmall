package com.itcrazy.alanmall.order.manager;

import com.itcrazy.alanmall.order.dto.OrderDetailRequest;
import com.itcrazy.alanmall.order.dto.OrderDetailResponse;

/**
 * @Auther: mathyoung
 * @description:
 */
public interface IOrderQueryService {
    OrderDetailResponse getOrderDetail(OrderDetailRequest request);

    OrderDetailResponse checkOrderPayStatus(OrderDetailRequest request);
}
