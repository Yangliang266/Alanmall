package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.CardInformationDto;
import com.itcrazy.alanmall.mscard.model.CardInformation;

import java.util.List;

/**
 * 制卡管理详情接口
 * @author huangchunbo
 * 2018-09-30
 */
public interface CardInforDetilManager {

	public List<CardInformation> getPageDetilList(CardInformationDto cardInformationDto);

	public Integer getPageDetilTotal(CardInformationDto cardInformationDto);

}
