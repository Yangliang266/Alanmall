package com.itcrazy.alanmall.order.handler.HandlerType;

public interface TransPipeline extends TransBoundInvoke {
    void addFirstNode(TransHandler... handlers);

    void addLastNode(TransHandler... handlers);
}
