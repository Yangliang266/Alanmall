package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.CardInformationDto;
import com.itcrazy.alanmall.mscard.model.CardInformation;

import java.util.List;

/**
 * 新建卡号（获取卡状态，跳号数字接口）
 * @author huangchunbo
 * 2018-09-30
 */
public interface TypeCategoryManager {

	List<CardInformation> getPageList(CardInformationDto cardInformationDto);

	List<CardInformation> getJumpNumberList(CardInformationDto cardInformationDto);



}
