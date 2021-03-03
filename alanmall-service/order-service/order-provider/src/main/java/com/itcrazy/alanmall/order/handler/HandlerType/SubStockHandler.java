package com.itcrazy.alanmall.order.handler.HandlerType;

import com.itcrazy.alanmall.common.exception.BaseBusinessException;
import com.itcrazy.alanmall.order.context.CreateOrderContext;
import com.itcrazy.alanmall.order.context.TransHandlerContext;
import com.itcrazy.alanmall.order.dal.entity.Stock;
import com.itcrazy.alanmall.order.dal.mapper.StockMapper;
import com.itcrazy.alanmall.order.dto.CartProductDto;
import com.itcrazy.alanmall.order.dto.MqResponse;
import com.itcrazy.alanmall.order.manager.IMqService;
import com.itcrazy.alanmall.order.utils.MqFactory;
import com.itcrazy.alanmall.order.utils.MqTransCondition;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Component
@PropertySource("classpath:base_mq.properties")
@Data
public class SubStockHandler extends AbstracTransHandler{
    @Autowired
    private StockMapper stockMapper;

    @Override
    public boolean isAysc() {
        return false;
    }

    @Override
    public boolean doHandler(TransHandlerContext context) {
        CreateOrderContext createOrderContext = (CreateOrderContext) context;
        List<CartProductDto> cartProductDtoList = createOrderContext.getCartProductDtoList();
        List<Long> itemIds = new ArrayList<>();
        cartProductDtoList.forEach(obj -> {
            itemIds.add(obj.getProductId());
        });
        //排序
        itemIds.sort(Long::compareTo);
        //一次性锁 ids
        List<Stock> list = stockMapper.checkStockUpdate(itemIds);
        if(list==null||list.isEmpty()){
            throw new BaseBusinessException("库存未初始化");
        }
        if(list.size()!=itemIds.size()){
            throw new BaseBusinessException("有商品未初始化库存,请在如下商品id中检查库存状态："+itemIds.toString());
        }
        list.forEach(stock -> {
            cartProductDtoList.forEach(one -> {
                if (Objects.equals(one.getProductId(), stock.getItemId())) {
                    if (stock.getStockCount() < one.getProductNum()) {
                        throw new BaseBusinessException(stock.getItemId()+"库存不足");
                    }
                    stock.setLockCount(one.getProductNum().intValue());
                    stock.setStockCount(-one.getProductNum());
                    //更改库存状态
                    stockMapper.updateStock(stock);
                }
            });
        });
        return true;
    }
}
