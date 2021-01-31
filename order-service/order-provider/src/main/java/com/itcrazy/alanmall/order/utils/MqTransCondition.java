package com.itcrazy.alanmall.order.utils;

import com.itcrazy.alanmall.order.context.AbsTransHandlerContext;
import com.itcrazy.alanmall.order.context.CreateOrderContext;
import com.itcrazy.alanmall.order.context.TransHandlerContext;
import com.itcrazy.alanmall.order.dto.AddAndUpdateMqRequest;
import com.itcrazy.alanmall.order.dto.CartProductDto;
import lombok.Data;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Auther: mathyoung
 * @description:
 */
@Data
public class MqTransCondition extends AbsTransHandlerContext {
    private Long userId;

    private Long msgId;

    private Long addressId;

    private String tel;

    private String userName;

    private String streetName;

    private BigDecimal orderTotal;

    List<CartProductDto> cartProductDtoList;

    private List<Long> buyProductIds;

    private String buyerNickName;

    private String uniqueKey; //业务唯一id

    private String mqstatus;

    private String exchange;

    private String queue;

    public MqTransCondition(CreateOrderContext createOrderContext, String exchange, String queue) {
        this.userId = createOrderContext.getUserId();

        Date date = new Date();//获取当前的日期
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String str = df.format(date);//获取String类型的时间

        this.msgId = Long.parseLong(str);
        this.addressId = createOrderContext.getAddressId();
        this.tel = createOrderContext.getTel();
        this.userName = createOrderContext.getUserName();
        this.streetName = createOrderContext.getStreetName();
        this.orderTotal = createOrderContext.getOrderTotal();
        this.cartProductDtoList = createOrderContext.getCartProductDtoList();
        this.buyProductIds = createOrderContext.getBuyProductIds();
        this.buyerNickName = createOrderContext.getBuyerNickName();
        this.uniqueKey = createOrderContext.getUniqueKey();
        this.exchange = exchange;
        this.queue = queue;
    }

//    public AddAndUpdateMqRequest mqReqbuild(String queue, String exchange, TransHandlerContext context) {
//        CreateOrderContext createOrderContext = (CreateOrderContext) context;
//        AddAndUpdateMqRequest mqMessage = new AddAndUpdateMqRequest();
//        Date date = new Date();//获取当前的日期
//        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
//        String str = df.format(date);//获取String类型的时间
//        Long msgId = Long.parseLong(str);
//        mqMessage.setUserId(createOrderContext.getUserId());
//        mqMessage.setMsgId(msgId);
//        mqMessage.setStatus(1);
//        mqMessage.setQueue(queue);
//        mqMessage.setExchange(exchange);
//        return mqMessage;
//    }
}
