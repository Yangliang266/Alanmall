package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.CardDiscardedDto;
import com.itcrazy.alanmall.mscard.model.CardDiscarded;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 总部作废Dao层接口
 * @author yangliang
 * 2018-09-04
 */
@Component
public interface CardDiscardedDao extends BaseDao<CardDiscarded, Long> {
	// 获取页面初始化数据
	public List<CardDiscarded> getPageList(CardDiscardedDto cardDiscardedDto);

	// 总历史记录数
	public Integer getPageTotal(CardDiscardedDto cardDiscardedDto);

	// 获取待作废的卡号总条数
	public Integer getCardDiscardedTotal(CardDiscardedDto cardDiscardedDto);

	// 更新cardInformation
	public int updateCardInformation(CardDiscarded cardDiscarded);

	// 获取最大货单号
	public String getMaxReciptNo(CardDiscardedDto cardDiscarded);

	// 提取待作废的卡号
	public List<CardDiscarded> getCardDiscardedNo(CardDiscardedDto cardDiscardedDto);


}
