package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.OrderListDto;
import com.itcrazy.alanmall.mscard.model.OrderList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 订单一览
 * @author chenfei
 * 2018-10-11
 */
@Component
public interface OrderListDao extends BaseDao<OrderList, Long> {

	public int addOrderList(OrderList orderList);

	public OrderList getOrderListByOrderNo(
            @Param("orderNo") String orderNo,
            @Param("companyId") Long companyId);

	/**
	 * 撤销订单
	 * @param orderNo
	 * @param companyId
	 * @param userId
	 * @return
	 */
	public int revoke(
            @Param("orderNo") String orderNo,
            @Param("companyId") Long companyId,
            @Param("userId") Long userId);

	//查询订单消费详情
	public OrderList getOrderList(OrderListDto orderListDto);

	//查询订单号是否已存在
	public Integer getCountByOrderNo(@Param("orderNo") String orderNo);
}
