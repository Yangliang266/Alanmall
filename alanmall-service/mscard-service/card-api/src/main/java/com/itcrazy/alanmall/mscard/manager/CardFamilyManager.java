package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.CardFamilyDto;
import com.itcrazy.alanmall.mscard.model.ActiveInformation;
import com.itcrazy.alanmall.mscard.model.CardFamily;
import com.itcrazy.alanmall.common.vo.Result;

import java.util.List;

/**
 * 亲情卡管理接口
 * @author huangchunbo
 * 2018-11-13
 */
public interface CardFamilyManager {

	// 查询母卡信息
	CardFamily getCardFamily(CardFamilyDto cardFamilyDto);

	// 根据母卡查询子卡信息
	List<CardFamily> getCreditFamilyHistory(CardFamilyDto cardFamilyDto);

	int getHistoryPageTotal(CardFamilyDto cardFamilyDto);

	Integer getCountCreditSet(CardFamilyDto cardFamilyDto);

	// 查询未绑定子卡
	List<CardFamily> getCardBindFamilyList(CardFamilyDto cardFamilyDto);

	// 绑定子卡
	public Result bindSubCrads(List<ActiveInformation> activeInfoList);

	//解绑子卡
	public void OperaregisteredCard(CardFamily cardFamily) throws Exception;

	public void updateChildRegistered(CardFamily cardFamily) throws Exception;

	CardFamily getDetil(String childCard, Long companyId);

}
