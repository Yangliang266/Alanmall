package com.itcrazy.alanmall.order.pipelineFactory;

import com.itcrazy.alanmall.common.result.AbstractRequest;
import com.itcrazy.alanmall.order.handler.HandlerType.TransBoundInvoke;
import com.itcrazy.alanmall.order.handler.HandlerType.TransPipeline;
import com.itcrazy.alanmall.order.context.TransHandlerContext;
import com.itcrazy.alanmall.order.conveter.TransConverter;
import com.itcrazy.alanmall.order.handler.HandlerType.DefaultTransPipeline;

public abstract class AbstranctTransPipelineFactory<T extends AbstractRequest> implements TransPipelineFactory<T> {
    @Override
    public TransBoundInvoke build(T obj) {
        // 创建上下文
        TransHandlerContext context = createContext();

        // 创建转换器
        TransConverter converter = createConverter();

        TransHandlerContext transHandlerContext = converter.convertRequest2Ctx(obj,context);

        TransPipeline pipeline = createPipeline(transHandlerContext);

        doBuild(pipeline);

        return pipeline;
    }

    protected abstract TransHandlerContext createContext();

    protected abstract TransConverter createConverter();

    protected abstract void doBuild(TransPipeline pipeline);

    protected TransPipeline createPipeline(TransHandlerContext context) {
        return new DefaultTransPipeline(context);
    }
}
