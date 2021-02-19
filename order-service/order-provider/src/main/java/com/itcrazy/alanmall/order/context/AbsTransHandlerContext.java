package com.itcrazy.alanmall.order.context;


import com.itcrazy.alanmall.order.conveter.CreateOrderConvert;
import com.itcrazy.alanmall.order.conveter.TransConverter;

public abstract class AbsTransHandlerContext implements TransHandlerContext{
    private String orderId;

    private TransConverter convert = new CreateOrderConvert();

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public TransConverter getConvert() {
        return convert;
    }

    public void setConvert(TransConverter convert) {
        this.convert = convert;
    }
}
