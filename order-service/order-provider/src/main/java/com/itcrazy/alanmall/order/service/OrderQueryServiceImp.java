package com.itcrazy.alanmall.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itcrazy.alanmall.order.constant.OrderConstants;
import com.itcrazy.alanmall.order.constant.OrderRetCode;
import com.itcrazy.alanmall.order.conveter.QueryOrderDetailConverter;
import com.itcrazy.alanmall.order.dal.entity.Order;
import com.itcrazy.alanmall.order.dal.entity.OrderItem;
import com.itcrazy.alanmall.order.dal.entity.OrderShipping;
import com.itcrazy.alanmall.order.dal.mapper.OrderItemMapper;
import com.itcrazy.alanmall.order.dal.mapper.OrderMapper;
import com.itcrazy.alanmall.order.dal.mapper.OrderShippingMapper;
import com.itcrazy.alanmall.order.dto.*;
import com.itcrazy.alanmall.order.manager.IOrderQueryService;
import com.itcrazy.alanmall.order.utils.ExceptionProcessorUtils;
import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
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

    @Resource
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
                response.setOrderItemDto(queryOrderDetailConverter.items2dtos(orderItems));
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

    @Override
    public OrderListResponse getOrderList(OrderListRequest request) {
        OrderListResponse response = new OrderListResponse();
        request.requestCheck();
        try {
            log.info("Begin: OrderQueryServiceImp.getOrderList");
            PageHelper.startPage(request.getPage(),request.getSize());
            Example example = new Example(Order.class);
            example.createCriteria()
                    .andEqualTo("userId", Integer.valueOf(request.getUserId().toString()));
            example.setOrderByClause("create_time desc");
            List<Order> orderList = orderMapper.selectByExample(example);

            // 不存返回空
            if (CollectionUtils.isEmpty(orderList)) {
                response.setTotal(0L);
                response.setDetailInfoList(new ArrayList<>());
                return response;
            }

            // 正常流程
            List<OrderDetailInfo> infos = new ArrayList<>();
            PageInfo pageInfo = new PageInfo(orderList);
            orderList.forEach(orderItem -> {
                OrderDetailInfo info = queryOrderDetailConverter.order2OrderDetail(orderItem);
                List<OrderItem> list =  orderItemMapper.queryByOrderId(orderItem.getOrderId());
                OrderShipping orderShipping=orderShippingMapper.selectByPrimaryKey(orderItem.getOrderId());
                info.setOrderItemDto(queryOrderDetailConverter.items2dtos(list));
                info.setOrderShippingDto(queryOrderDetailConverter.shipping2dto(orderShipping));
                infos.add(info);
            });
            response.setTotal(pageInfo.getTotal());
            response.setDetailInfoList(infos);
            response.setCode(OrderRetCode.SUCCESS.getCode());
            response.setMsg(OrderRetCode.SUCCESS.getMessage());
            log.info("Begin: OrderQueryServiceImp.getOrderList.result:{}", response);
        }catch (Exception e) {
            log.error("Error: OrderQueryServiceImp.getOrderList.result:{}", response);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public OrderDetailResponse checkOrderPayStatus(OrderDetailRequest request) {
        request.requestCheck();
        OrderDetailResponse response = new OrderDetailResponse();
        try {
            log.info("Begin: OrderQueryServiceImp.checkOrderPayStatus:" + request);
            Example example = new Example(Order.class);
            example.createCriteria()
                    .andEqualTo("orderId", request.getOrderId())
                    .andEqualTo("status", request.getStatus());
            // 订单的所有物品信息
            Order order = orderMapper.selectOneByExample(example);
            if (null != order) {
                response.setCode(OrderRetCode.SUCCESS.getCode());
                response.setMsg(OrderRetCode.SUCCESS.getMessage());
            }
        }catch (Exception e) {
            log.info("Error: OrderQueryServiceImp.checkOrderPayStatus.result:{}", response);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        log.info("End: OrderQueryServiceImp.checkOrderPayStatus:" + response);
        return response;
    }

    @Override
    public OrderStatusResponse getOrderAllStatus(OrderListRequest request) {
        OrderStatusResponse statusResponse = new OrderStatusResponse();
        request.requestCheck();
        try {
            log.info("Begin: OrderQueryServiceImp.getOrderAllStatus");
            Example example = new Example(Order.class);
            example.createCriteria()
                    .andEqualTo("userId", Integer.valueOf(request.getUserId().toString()));
            List<Order> orderList = orderMapper.selectByExample(example);

            orderList.forEach( detail -> {
                switch(detail.getStatus()) {
                    case OrderConstants.ORDER_STATUS_INIT:
                        statusResponse.setInitNum(statusResponse.getInitNum() + 1);
                        break;
                    case OrderConstants.ORDER_STATUS_PAYED:
                        statusResponse.setPayNum(statusResponse.getPayNum() + 1);
                        break;
                    case OrderConstants.ORDER_STATUS_UNPUSH:
                        statusResponse.setUnPushNum(statusResponse.getUnPushNum() + 1);
                        break;
                    case OrderConstants.ORDER_STATUS_PUSH:
                        statusResponse.setPushNum(statusResponse.getPushNum() + 1);
                        break;
                    case OrderConstants.ORDER_STATUS_TRANSACTION_SUCCESS:
                        statusResponse.setSuccessNum(statusResponse.getSuccessNum() + 1);
                        break;
                    default:
                        break;
                }
            });

            statusResponse.setCode(OrderRetCode.SUCCESS.getCode());
            statusResponse.setMsg(OrderRetCode.SUCCESS.getMessage());
            log.info("Begin: OrderQueryServiceImp.getOrderAllStatus.result:{}", statusResponse);
        }catch (Exception e) {
            log.error("Error: OrderQueryServiceImp.getOrderAllStatus.result:{}", statusResponse);
            ExceptionProcessorUtils.wrapperHandlerException(statusResponse, e);
        }
        return statusResponse;
    }
}
