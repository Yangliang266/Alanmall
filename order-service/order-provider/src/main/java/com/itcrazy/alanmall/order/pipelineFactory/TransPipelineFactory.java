package com.itcrazy.alanmall.order.pipelineFactory;

import com.itcrazy.alanmall.order.handler.HandlerType.TransBoundInvoke;

public interface TransPipelineFactory<T> {
    TransBoundInvoke build(T obj);
}
