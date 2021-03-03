package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.ReturnCardDto;
import com.itcrazy.alanmall.mscard.model.ReturnCard;

import java.util.List;

/**
 * 总部退货接口
 * @author yangliang
 * 2018-09-04
 */
public interface ReturnCardManager {
	// 历史记录查询
	public List<ReturnCard> getPageList(ReturnCardDto returncardDto);

	// 总历史记录数
	public Integer getPageTotal(ReturnCardDto returncardDto);

	// 获取待退货的卡号总条数
	public Integer getReturnCardTotal(ReturnCardDto returncardDto);

	// 总部退货（卡状态更新，退货记录）
	public void OperaReturnCard(String[] cardNoList, ReturnCard returnCard) throws Exception;

	// 获取待退货卡号
	public List<ReturnCard> getReturnCardNo(ReturnCardDto returnCardDto);

}
