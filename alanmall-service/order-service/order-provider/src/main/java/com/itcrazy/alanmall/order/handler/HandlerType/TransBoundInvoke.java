package com.itcrazy.alanmall.order.handler.HandlerType;

import com.itcrazy.alanmall.order.context.TransHandlerContext;

public interface TransBoundInvoke {
    void start();

    void shutdown();

    <T extends TransHandlerContext> T getContext();
}
