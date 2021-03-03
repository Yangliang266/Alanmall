package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.ChangeCardDto;
import com.itcrazy.alanmall.mscard.model.CardDiscarded;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import com.itcrazy.alanmall.mscard.model.ChangeCard;
import com.itcrazy.alanmall.mscard.model.ChangeHistory;

/**
 * 换卡接口
 * @author yangliang
 * 2018-09-15
 */
public interface ChangeCardManager {
	// 老卡记录查询
	public ChangeCard getActiveInfo(ChangeCardDto changeCardDto);

	// 新卡记录查询
	public ChangeCard getPageNewlist(ChangeCardDto changeCardDto);

	// 总历史记录数
	public Integer getPageTotal(ChangeCardDto changeCardDto);

	// 换卡
	public void changeCard(ChangeHistory changeHistory, CardInformation cardInformation, ChangeCardDto changeCardDto, CardDiscarded cardDiscarded) throws Exception;

}
