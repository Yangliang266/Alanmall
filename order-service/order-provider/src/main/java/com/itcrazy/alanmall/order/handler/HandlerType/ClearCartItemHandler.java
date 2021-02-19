package com.itcrazy.alanmall.order.handler.HandlerType;

import com.itcrazy.alanmall.common.exception.BizException;
import com.itcrazy.alanmall.order.constant.OrderRetCode;
import com.itcrazy.alanmall.order.context.CreateOrderContext;
import com.itcrazy.alanmall.order.context.TransHandlerContext;
import com.itcrazy.alanmall.shopping.dto.ClearCartItemRequest;
import com.itcrazy.alanmall.shopping.dto.ClearCartItemResponse;
import com.itcrazy.alanmall.shopping.manager.ICartService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

@Component
public class ClearCartItemHandler extends AbstracTransHandler{
    @DubboReference(timeout = 3000)
    ICartService iCartService;

    @Override
    public boolean isAysc() {
        return false;
    }

    @Override
    public boolean doHandler(TransHandlerContext context) {
        ClearCartItemRequest request=new ClearCartItemRequest();
        CreateOrderContext createOrderContext=(CreateOrderContext)context;
        request.setProductIds(createOrderContext.getBuyProductIds());
        request.setUserId(createOrderContext.getUserId());
        ClearCartItemResponse response=iCartService.clearCartItemByUserID(request);
        if(OrderRetCode.SUCCESS.getCode().equals(response.getCode())){
            return true;
        }else{
            throw new BizException(response.getCode(),response.getMsg());
        }
    }
}
