package com.itcrazy.alanmall.order.handler.HandlerType;

import com.itcrazy.alanmall.order.context.CreateOrderContext;
import com.itcrazy.alanmall.order.context.TransHandlerContext;
import com.itcrazy.alanmall.order.dal.entity.OrderShipping;
import com.itcrazy.alanmall.order.dal.mapper.OrderShippingMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
@Slf4j
public class LogisticalHandler extends AbstracTransHandler{
    @Resource
    OrderShippingMapper orderShippingMapper;

    @Override
    public boolean isAysc() {
        return false;
    }

    @Override
    public boolean doHandler(TransHandlerContext context) {
        try {
            CreateOrderContext createOrderContext=(CreateOrderContext)context;
            OrderShipping orderShipping = new OrderShipping();
            orderShipping.setOrderId(String.valueOf(createOrderContext.getOrderId()));
            orderShipping.setReceiverName(createOrderContext.getUserName());
            orderShipping.setReceiverAddress(createOrderContext.getStreetName());
            orderShipping.setReceiverPhone(createOrderContext.getTel());
            orderShipping.setCreated(new Date());
            orderShipping.setUpdated(new Date());
            orderShippingMapper.insert(orderShipping);
        }catch (Exception e){
            e.printStackTrace();
//            throw new BizException(OrderRetCode.SHIPPING_DB_SAVED_FAILED.getCode(),OrderRetCode.SHIPPING_DB_SAVED_FAILED.getMessage());
        }
        return true;
    }
}
