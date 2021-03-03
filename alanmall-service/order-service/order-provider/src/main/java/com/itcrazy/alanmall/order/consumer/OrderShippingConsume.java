package com.itcrazy.alanmall.order.consumer;

import com.itcrazy.alanmall.order.constant.OrderConstants;
import com.itcrazy.alanmall.order.dal.entity.Order;
import com.itcrazy.alanmall.order.dal.entity.OrderItem;
import com.itcrazy.alanmall.order.dal.entity.Stock;
import com.itcrazy.alanmall.order.dal.mapper.OrderItemMapper;
import com.itcrazy.alanmall.order.dal.mapper.OrderMapper;
import com.itcrazy.alanmall.order.dal.mapper.StockMapper;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Auther: mathyoung
 * @description: OrderShipping
 */
@Component
@RabbitListener(queues = "CANCEL_ORDER_QUEUE", containerFactory = "simpleRabbitListenerContainerFactory")
public class OrderShippingConsume {
    @Resource
    OrderMapper orderMapper;

    @Resource
    OrderItemMapper orderItemMapper;

    @Resource
    StockMapper stockMapper;

    @RabbitHandler
    public void process(String context, Channel channel, Message message) throws IOException {
        try {
            Order order=new Order();
            order.setOrderId(context);
            //先查询订单是否是待支付状态
            Order order1=orderMapper.selectByPrimaryKey(order);
            //未付款才去走逻辑
            if(order1.getStatus()==OrderConstants.ORDER_STATUS_INIT){
                Example example = new Example(Order.class);
                example.createCriteria().andEqualTo("status",OrderConstants.ORDER_STATUS_TRANSACTION_CANCEL);
                //将订单状态改为取消
                orderMapper.updateByExampleSelective(order,example);
                //将订单商品的库存状态改为释放
                orderItemMapper.updateStockStatus(OrderConstants.ORDERITEM_STATUS_RELEASE,context);
                //将库存还回去
                List<OrderItem> list=orderItemMapper.queryByOrderId(context);
                List<Long> itemIds=list.stream().map(OrderItem::getItemId).sorted().collect(Collectors.toList());
                //锁 itemIds
                List<Stock> stocks=stockMapper.checkStockUpdate(itemIds);
                stocks.forEach(stock -> {
                    list.forEach(one->{
                        if(Objects.equals(one.getItemId(),stock.getItemId())){
                            stock.setLockCount(-one.getNum());
                            stock.setStockCount(one.getNum().longValue());
                            //释放库存
                            stockMapper.updateStock(stock);
                        }
                    });
                });
            }
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }catch (Exception e){
            e.printStackTrace();
            //这里会不断消费吗？
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
        }
    }
}
