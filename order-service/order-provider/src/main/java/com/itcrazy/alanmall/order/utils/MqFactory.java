package com.itcrazy.alanmall.order.utils;

import com.itcrazy.alanmall.order.context.CreateOrderContext;
import com.itcrazy.alanmall.order.context.TransHandlerContext;
import com.itcrazy.alanmall.order.dal.entity.MqMessage;
import com.itcrazy.alanmall.order.dto.AddAndUpdateMqRequest;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Auther: mathyoung
 * @description: mq 请求封装
 */
@Component
public class MqFactory {
    public AddAndUpdateMqRequest mqReqbuild(String queue, String exchange, TransHandlerContext context) {
        CreateOrderContext createOrderContext = (CreateOrderContext) context;
        AddAndUpdateMqRequest mqMessage = new AddAndUpdateMqRequest();
        Date date = new Date();//获取当前的日期
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String str = df.format(date);//获取String类型的时间
        Long msgId = Long.parseLong(str);
        mqMessage.setMsgId(msgId);
        mqMessage.setStatus(1);
        mqMessage.setQueue(queue);
        mqMessage.setExchange(exchange);
        return mqMessage;
    }
}
