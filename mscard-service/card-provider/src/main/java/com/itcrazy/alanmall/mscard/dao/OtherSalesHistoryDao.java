package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.model.OtherSalesHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 其他消费一览DAO
 * @author chenfei
 * 2018-10-24
 */
@Component
public interface OtherSalesHistoryDao extends BaseDao<OtherSalesHistory, Long> {

	public int addOtherSalesHistory(OtherSalesHistory otherSalesHistory);

	public OtherSalesHistory getOtherSalesHistoryByOrderNo(@Param("orderNo") String orderNo,
                                                           @Param("companyId") Long companyId);

	/**
	 * 删除订单
	 * @param orderNo
	 * @param companyId
	 * @param userId
	 * @return
	 */
	public int delete(@Param("orderNo") String orderNo,
                      @Param("companyId") Long companyId, @Param("userId") Long userId);
}
