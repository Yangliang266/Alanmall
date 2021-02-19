package com.itcrazy.alanmall.order.service;

import com.itcrazy.alanmall.order.constant.OrderRetCode;
import com.itcrazy.alanmall.order.conveter.QueryOrderDetailConverter;
import com.itcrazy.alanmall.order.dal.entity.Order;
import com.itcrazy.alanmall.order.dal.entity.OrderItem;
import com.itcrazy.alanmall.order.dal.entity.OrderShipping;
import com.itcrazy.alanmall.order.dal.mapper.OrderItemMapper;
import com.itcrazy.alanmall.order.dal.mapper.OrderMapper;
import com.itcrazy.alanmall.order.dal.mapper.OrderShippingMapper;
import com.itcrazy.alanmall.order.dto.OrderDetailRequest;
import com.itcrazy.alanmall.order.dto.OrderDetailResponse;
import com.itcrazy.alanmall.order.manager.IOrderQueryService;
import com.itcrazy.alanmall.order.utils.ExceptionProcessorUtils;
import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: mathyoung
 * @description:
 */
@DubboService
@Slf4j
public class OrderQueryServiceImp implements IOrderQueryService {
    @Resource
    OrderMapper orderMapper;

    @Resource
    OrderShippingMapper orderShippingMapper;

    @Resource
    OrderItemMapper orderItemMapper;

    @Autowired
    QueryOrderDetailConverter queryOrderDetailConverter;

    @Override
    public OrderDetailResponse getOrderDetail(OrderDetailRequest request) {
        request.requestCheck();
        OrderDetailResponse response = new OrderDetailResponse();
        try {
            log.info("Begin: OrderQueryServiceImp.getOrderDetail:" + request);
            // 物流信息
            OrderShipping orderShipping = orderShippingMapper.selectByPrimaryKey(request.getOrderId());

            List<OrderItem> orderItems = orderItemMapper.queryByOrderId(request.getOrderId());

            // 订单的所有物品信息
            Order order = orderMapper.selectByPrimaryKey(request.getOrderId());
            if (null != order) {
                response = queryOrderDetailConverter.order2Res(order);
                response.setOrderItemDto(queryOrderDetailConverter.item2dto(orderItems));
                response.setOrderShippingDto(queryOrderDetailConverter.shipping2dto(orderShipping));
                response.setCode(OrderRetCode.SUCCESS.getCode());
                response.setMsg(OrderRetCode.SUCCESS.getMessage());
            }
        }catch (Exception e) {
            log.info("Error: OrderQueryServiceImp.getOrderDetail:" + response);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        log.info("End: OrderQueryServiceImp.getOrderDetail:" + response);
        return response;
    }
}
