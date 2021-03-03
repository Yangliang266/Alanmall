package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.OrderListDto;
import com.itcrazy.alanmall.mscard.model.OrderList;

public interface OrderListManager {
	//获取订单消费详情
	public OrderList getOrderList(OrderListDto orderListDto);

	//查询订单号是否已存在
	public Integer getCountByOrderNo(String orderNo);

}
