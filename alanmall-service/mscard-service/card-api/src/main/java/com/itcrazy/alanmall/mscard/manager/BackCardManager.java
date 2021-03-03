package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.BackCardDto;
import com.itcrazy.alanmall.mscard.model.BackCard;

import java.util.List;

/**
 * 换卡接口
 * @author yangliang
 * 2018-09-15
 */
public interface BackCardManager {
	//
	public List<BackCard> getPayModeList(BackCardDto backCardDto);

	// 记录查询
	public BackCard getPageList(BackCardDto backCardDto);

	// 已退卡记录查询
	public BackCard getPageHistory(BackCardDto backCardDto);

	// 余额退款历史查询
	public BackCard getDialogHistory(BackCardDto backCardDto);

	// 退卡
	public void returnCard(BackCardDto backCardDto) throws Exception;

	// 余额退款
	public void returnbalance(BackCardDto backCardDto) throws Exception;

	public int getCustomReturnHistoryCount(BackCardDto backCardDto);

	public int getActivedInformationCount(BackCardDto backCardDto);

}
