package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.CreditDto;
import com.itcrazy.alanmall.mscard.model.Credit;

import java.util.List;

/**
 * 换卡接口
 * @author luxf
 * 2018-09-15
 */
public interface CreditManager {
	// 记录查询
	public Credit getPageList(CreditDto creditDto);

	// 子卡记录查询
	public List<Credit> getCreditHistory(CreditDto creditDto);

	// 制卡状态数据条数
	public int getHistoryPageTotal(CreditDto creditDto);

	public List<Credit> getCreditById(CreditDto creditDto);

}
