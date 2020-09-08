package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.OrderListDao;
import com.itcrazy.alanmall.mscard.dto.Base.OrderListDto;
import com.itcrazy.alanmall.mscard.manager.OrderListManager;
import com.itcrazy.alanmall.mscard.model.OrderList;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 查询订单消费详情
 * @author zhangzhongtian
 * 2018-10-23
 */
@Slf4j
@Service
public class OrderListManagerImpl implements OrderListManager{

	@Autowired
	private OrderListDao orderListDao;

	@Override
	public OrderList getOrderList(OrderListDto orderListDto) {
		return orderListDao.getOrderList(orderListDto);
	}

	@Override
	public Integer getCountByOrderNo(String orderNo) {
		return orderListDao.getCountByOrderNo(orderNo);
	}

}
