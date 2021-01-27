package com.itcrazy.alanmall.order.handler.HandlerType;

import com.itcrazy.alanmall.order.context.TransHandlerContext;

public interface TransHandler {
    boolean isAysc();

    boolean doHandler(TransHandlerContext context);
}
