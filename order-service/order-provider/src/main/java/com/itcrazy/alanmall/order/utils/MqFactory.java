package com.itcrazy.alanmall.order.utils;

import com.itcrazy.alanmall.order.context.CreateOrderContext;
import com.itcrazy.alanmall.order.context.TransHandlerContext;
import lombok.Data;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: mathyoung
 * @description: mq 请求封装
 */
@Component
@Data
public class MqFactory {
    public volatile static MqTransCondition mqTransCondition = new MqTransCondition();

    public static Map<String, MqTransCondition> pool = new ConcurrentHashMap<String, MqTransCondition>();

    private static final FastDateFormat FAST_DATE_FORMAT = FastDateFormat.getInstance("yyyyMMddHHmmss");

    public static MqTransCondition getFlyweight(TransHandlerContext context, String exchange, String queue) {
        CreateOrderContext createOrderContext = (CreateOrderContext) context;
        if (pool.containsKey(createOrderContext.getUserId().toString())) {
            mqTransCondition.setMsgId(Long.valueOf(FAST_DATE_FORMAT.format(System.currentTimeMillis())));
        } else {
            MqTransCondition mqTransCondition1 = new MqTransCondition(createOrderContext, exchange, queue);
            pool.put(mqTransCondition1.getUserId().toString(), mqTransCondition1);
            mqTransCondition = mqTransCondition1;
        }
        return mqTransCondition;
    }

}
