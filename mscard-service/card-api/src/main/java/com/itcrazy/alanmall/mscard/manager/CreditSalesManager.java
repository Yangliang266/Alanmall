package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.CreditSalesDto;
import com.itcrazy.alanmall.mscard.model.CreditSalesHistory;

import java.util.List;

/**
 * 挂账卡信息接口
 * @author chenfei
 * 2018-10-09
 */
public interface CreditSalesManager {
	// 挂账卡信息查询
	public List<CreditSalesHistory> getCreditSalesList(CreditSalesDto creditSalesDto);

	// 挂账卡合计信息查询
	public CreditSalesHistory getTotalInfo(CreditSalesDto creditSalesDto);

	// 分页
	Integer getPageTotal(CreditSalesDto creditSalesDto);

	// 清账
	public int updateCreditSales(String[] salesIds, CreditSalesHistory creditSalesHistory, String clearFlag);

}
