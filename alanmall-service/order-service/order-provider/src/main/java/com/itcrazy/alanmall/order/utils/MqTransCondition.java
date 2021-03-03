package com.itcrazy.alanmall.order.utils;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.itcrazy.alanmall.order.context.AbsTransHandlerContext;
import com.itcrazy.alanmall.order.context.CreateOrderContext;
import com.itcrazy.alanmall.order.context.TransHandlerContext;
import com.itcrazy.alanmall.order.dto.AddAndUpdateMqRequest;
import com.itcrazy.alanmall.order.dto.CartProductDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.time.FastDateFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Auther: mathyoung
 * @description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = MqTransCondition.class)
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

    private static final FastDateFormat FAST_DATE_FORMAT = FastDateFormat.getInstance("yyyyMMddHHmmss");

    public MqTransCondition() {
    }

    public MqTransCondition(TransHandlerContext context, String exchange, String queue) {
        CreateOrderContext createOrderContext = (CreateOrderContext) context;
        this.userId = createOrderContext.getUserId();
        this.msgId = Long.parseLong(FAST_DATE_FORMAT.format(System.currentTimeMillis()));
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

//    public MqTransCondition mqReqbuild(String queue, String exchange, TransHandlerContext context) {
//        CreateOrderContext createOrderContext = (CreateOrderContext) context;
//        mqTransCondition1.setBuyerNickName(createOrderContext.getBuyerNickName());
//        mqTransCondition1.setAddressId(createOrderContext.getAddressId());
//        mqTransCondition1.setBuyProductIds(createOrderContext.getBuyProductIds());
//        mqTransCondition1.setOrderTotal(createOrderContext.getOrderTotal());
//        mqTransCondition1.setCartProductDtoList(createOrderContext.getCartProductDtoList());
//        mqTransCondition1.setStreetName(createOrderContext.getStreetName());
//        mqTransCondition1.setTel(createOrderContext.getTel());
//        mqTransCondition1.setUserName(createOrderContext.getUserName());
//        mqTransCondition1.setUniqueKey(createOrderContext.getUniqueKey());
//    }
}
