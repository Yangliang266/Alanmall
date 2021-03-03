package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.CardDiscardedDto;
import com.itcrazy.alanmall.mscard.model.CardDiscarded;

import java.util.List;

/**
 * 总部作废接口
 * @author yangliang
 * 2018-09-04
 */
public interface CardDiscardedManager {
	// 历史记录查询
	public List<CardDiscarded> getPageList(CardDiscardedDto cardDiscardedDto);

	// 总历史记录数
	public Integer getPageTotal(CardDiscardedDto cardDiscardedDto);

	// 获取待作废的卡号总条数
	public Integer getCardDiscardedTotal(CardDiscardedDto cardDiscardedDto);

	// 总部作废（卡状态更新，退货记录）
	public void OperaCardDiscarded(String[] cardNoList, CardDiscarded cardDiscarded) throws Exception;

	// 获取待作废卡号
	public List<CardDiscarded> getCardDiscardedNo(CardDiscardedDto cardDiscardedDto);

}
