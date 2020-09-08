package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardInformationDto;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import com.itcrazy.alanmall.mscard.model.Parameter;
import com.itcrazy.alanmall.common.vo.Result;

import java.util.List;

/**
 * 制卡管理接口
 * @author huangchunbo
 * 2018-09-30
 */
public interface CardInforManager {

	public List<CardInformation> getPageList(CardInformationDto cardInformationDto);

	public int getPageTotal(CardInformationDto cardInformationDto);

	public Result OperaCardInformation(Parameter parameter, CardInformation cardInformation,
                                       String[] jumpNumber, Integer amount, String bin)throws Exception;

	public String getMaxSerilNo(CardBaseDto cardBaseDto);

	public CardInformation getCardDetail(CardInformationDto cardInformationDto);
}
