package com.itcrazy.alanmall.order.service;

import com.itcrazy.alanmall.order.constant.OrderRetCode;
import com.itcrazy.alanmall.order.context.AbsTransHandlerContext;
import com.itcrazy.alanmall.order.dal.entity.Order;
import com.itcrazy.alanmall.order.dal.mapper.OrderMapper;
import com.itcrazy.alanmall.order.dto.*;
import com.itcrazy.alanmall.order.handler.HandlerType.TransBoundInvoke;
import com.itcrazy.alanmall.order.manager.IOrderService;
import com.itcrazy.alanmall.order.pipelineFactory.OrderProcessTransPipeline;
import com.itcrazy.alanmall.order.product.CancelOrderProduct;
import com.itcrazy.alanmall.order.utils.ExceptionProcessorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @Auther: mathyoung
 * @description:
 */
@Slf4j
@Component
@DubboService
public class OrderCoreServiceImp implements IOrderService {
    @Autowired
    OrderProcessTransPipeline orderProcessTransPipeline;

    @Autowired
    CancelOrderProduct cancelOrderProduct;

    @Resource
    OrderMapper orderMapper;

    @Override
    // 模板方法/责任链/工厂方法
    public CreateOrderResponse createOrder(CreateOrderRequest request) {
        CreateOrderResponse response = new CreateOrderResponse();
        try {
            TransBoundInvoke invoker = orderProcessTransPipeline.build(request);
            invoker.start(); //启动流程（pipeline来处理）
            AbsTransHandlerContext context = invoker.getContext();
            response = (CreateOrderResponse) context.getConvert().convertCtx2Respond(context);
        } catch (Exception e) {
            log.error("OrderCoreServiceImpl.createOrder Occur Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public CancelOrderResponse cancelOrder(CancelOrderRequest request) {
        CancelOrderResponse response = new CancelOrderResponse();
        try {
            cancelOrderProduct.sendCancelOrderMessage(request.getOrderId());
            response.setCode(OrderRetCode.SUCCESS.getCode());
            response.setMsg(OrderRetCode.SUCCESS.getMessage());
        }catch (Exception e) {
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public DeleteOrderResponse deleteOrder(DeleteOrderRequest request) {
        return null;
    }

    @Override
    public void updateOrder(Integer status, String orderId) {

        Order order = new Order();
        order.setOrderId(orderId);
        order.setStatus(status);
        Example example = new Example(Order.class);
        example.createCriteria().andEqualTo("orderId", orderId);
        orderMapper.updateByExampleSelective(order, example);
    }
}
