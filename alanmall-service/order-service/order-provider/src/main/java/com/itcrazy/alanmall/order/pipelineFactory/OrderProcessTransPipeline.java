package com.itcrazy.alanmall.order.pipelineFactory;

import com.itcrazy.alanmall.order.context.CreateOrderContext;
import com.itcrazy.alanmall.order.conveter.CreateOrderConvert;
import com.itcrazy.alanmall.order.dto.CreateOrderRequest;
import com.itcrazy.alanmall.order.handler.HandlerType.*;
import com.itcrazy.alanmall.order.context.TransHandlerContext;
import com.itcrazy.alanmall.order.conveter.TransConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessTransPipeline extends AbstranctTransPipelineFactory<CreateOrderRequest>{
    @Autowired
    private InitOrderHandler initOrderHandler;
    @Autowired
    private ValidateHandler validateHandler;
    @Autowired
    private LogisticalHandler logisticalHandler;
    @Autowired
    private ClearCartItemHandler clearCartItemHandler;
    @Autowired
    private SubStockHandler subStockHandler;
    @Autowired
    private SendMessageHandler sendMessageHandler;

    @Override
    protected TransHandlerContext createContext() {
        return new CreateOrderContext();
    }

    @Override
    protected TransConverter createConverter() {
        return new CreateOrderConvert();
    }

    @Override
    protected void doBuild(TransPipeline pipeline) {
        pipeline.addLastNode(sendMessageHandler);
        pipeline.addLastNode(clearCartItemHandler);
        pipeline.addLastNode(logisticalHandler);
        pipeline.addLastNode(initOrderHandler);
        pipeline.addLastNode(subStockHandler);
        pipeline.addLastNode(validateHandler);
    }
}
