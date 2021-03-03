package com.itcrazy.alanmall.order.handler.HandlerType;

import com.itcrazy.alanmall.common.exception.BizException;
import com.itcrazy.alanmall.order.constant.OrderConstants;
import com.itcrazy.alanmall.order.constant.OrderRetCode;
import com.itcrazy.alanmall.order.context.CreateOrderContext;
import com.itcrazy.alanmall.order.context.TransHandlerContext;
import com.itcrazy.alanmall.order.dal.entity.Order;
import com.itcrazy.alanmall.order.dal.entity.OrderItem;
import com.itcrazy.alanmall.order.dal.mapper.OrderItemMapper;
import com.itcrazy.alanmall.order.dal.mapper.OrderMapper;
import com.itcrazy.alanmall.order.utils.GlobalIdGeneratorUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Component
@Data
public class InitOrderHandler extends AbstracTransHandler{
    private final String ORDER_GLOBAL_ID_CACHE_KEY="ORDER_ID";
    private final String ORDER_ITEM_GLOBAL_ID_CACHE_KEY="ORDER_ITEM_ID";

    @Autowired
    private GlobalIdGeneratorUtil globalIdGeneratorUtil;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;


    @Override
    public boolean isAysc() {
        return false;
    }

    @Override
    public boolean doHandler(TransHandlerContext context) {
        Order order=new Order();
        try {
            CreateOrderContext createOrderContext=(CreateOrderContext)context;
            String orderId = globalIdGeneratorUtil.getNextSeq(ORDER_GLOBAL_ID_CACHE_KEY, 1);
            order.setOrderId(orderId);
            order.setUserId(createOrderContext.getUserId());
            order.setBuyerNick(createOrderContext.getBuyerNickName());
            order.setPayment(createOrderContext.getOrderTotal());
            order.setCreateTime(new Date());
            order.setUpdateTime(new Date());
            order.setStatus(OrderConstants.ORDER_STATUS_INIT);
            orderMapper.insert(order); //保存订单
            List<Long> buyProductIds=new ArrayList<>();
            createOrderContext.getCartProductDtoList().parallelStream().forEach(cartProductDto -> {
                OrderItem orderItem = new OrderItem();
                orderItem.setId(globalIdGeneratorUtil.getNextSeq(ORDER_ITEM_GLOBAL_ID_CACHE_KEY, 1));
                orderItem.setItemId(cartProductDto.getProductId());
                orderItem.setOrderId(String.valueOf(orderId));
                orderItem.setNum(Math.toIntExact(cartProductDto.getProductNum()));
                orderItem.setPrice(NumberUtils.toDouble(cartProductDto.getSalePrice()));
                orderItem.setTitle(cartProductDto.getProductName());
                orderItem.setPicPath(cartProductDto.getProductImg());
                orderItem.setTotalFee(cartProductDto.getSalePrice().multiply(BigDecimal.valueOf(cartProductDto.getProductNum())).doubleValue());
                buyProductIds.add(cartProductDto.getProductId());
                //已锁定库存
                orderItem.setStatus(1);
                orderItemMapper.insert(orderItem);
            });
            createOrderContext.setOrderId(orderId);
            createOrderContext.setBuyProductIds(buyProductIds);
        } catch(Exception e){
            throw new BizException(OrderRetCode.DB_SAVE_EXCEPTION.getCode(),OrderRetCode.DB_SAVE_EXCEPTION.getMessage());
        }

        return true;
    }
}
