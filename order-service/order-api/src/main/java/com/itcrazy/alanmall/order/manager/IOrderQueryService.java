package com.itcrazy.alanmall.order.manager;

import com.itcrazy.alanmall.order.dto.*;
import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * @Auther: mathyoung
 * @description:
 */
public interface IOrderQueryService {
    OrderDetailResponse getOrderDetail(OrderDetailRequest request);

    OrderDetailResponse checkOrderPayStatus(OrderDetailRequest request);

    OrderStatusResponse getOrderAllStatus(OrderListRequest request);

    OrderListResponse getOrderList(OrderListRequest request);
}
