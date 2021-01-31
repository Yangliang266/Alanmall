package com.itcrazy.alanmall.order.utils;

import com.itcrazy.alanmall.order.context.CreateOrderContext;
import com.itcrazy.alanmall.order.context.TransHandlerContext;
import org.springframework.stereotype.Component;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: mathyoung
 * @description: mq 请求封装
 */
@Component
public class MqFactory {
    private static ConcurrentHashMap<String, MqTransCondition> pool = new ConcurrentHashMap<String, MqTransCondition>(100);

    public static MqTransCondition getFlyweight(TransHandlerContext context, String exchange, String queue) {
        MqTransCondition condition = null;
        CreateOrderContext createOrderContext = (CreateOrderContext) context;
        if (pool.containsKey(createOrderContext.getUserId().toString())) {
            condition = pool.get(createOrderContext.getUserId().toString());
            condition.setBuyerNickName(createOrderContext.getBuyerNickName());
            condition.setAddressId(createOrderContext.getAddressId());
            condition.setBuyProductIds(createOrderContext.getBuyProductIds());
            condition.setOrderTotal(createOrderContext.getOrderTotal());
            condition.setCartProductDtoList(createOrderContext.getCartProductDtoList());
            condition.setStreetName(createOrderContext.getStreetName());
            condition.setTel(createOrderContext.getTel());
            condition.setUserName(createOrderContext.getUserName());
            condition.setUniqueKey(createOrderContext.getUniqueKey());
        } else {
            condition = new MqTransCondition(createOrderContext, exchange, queue);
            pool.put(condition.getUserId().toString(), condition);
        }
        return condition;
    }
}
