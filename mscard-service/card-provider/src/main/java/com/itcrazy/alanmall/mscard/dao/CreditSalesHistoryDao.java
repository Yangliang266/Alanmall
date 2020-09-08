package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.CreditSalesDto;
import com.itcrazy.alanmall.mscard.model.CreditSalesHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * 挂账一览DAO
 * @author chenfei
 * 2018-10-10
 */
@Component
public interface CreditSalesHistoryDao extends BaseDao<CreditSalesHistory, Long> {

	public int addCreditSalesHistory(CreditSalesHistory creditSalesHistory);

	public List<CreditSalesHistory> getCreditSalesList(CreditSalesDto creditSalesDto);

	public CreditSalesHistory getTotalInfo(CreditSalesDto creditSalesDto);

	public int getPageTotal(CreditSalesDto creditSalesDto);
	// 获取当前挂账信息 select
	public CreditSalesHistory select(CreditSalesDto creditSalesDto);

	/**
	 * 删除订单
	 * @param orderNo
	 * @param companyId
	 * @param userId
	 * @return
	 */
	public int delete(@Param("orderNo") String orderNo,
                      @Param("companyId") Long companyId, @Param("userId") Long userId);

	/**
	 * 获取此卡指定店铺中已挂账的金额
	 * @param cardNo
	 * @param storeId
	 * @param companyId
	 * @return
	 */
	public BigDecimal getCreditSalesByCardNoAndStoreId(@Param("cardNo") String cardNo,
                                                       @Param("storeId") Long storeId, @Param("companyId") Long companyId);
}
