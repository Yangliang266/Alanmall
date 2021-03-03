package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import com.itcrazy.alanmall.mscard.model.CardType;

import java.util.List;

/**
 * 读卡器型号接口
 * @author zhangli
 * 2018-09-04
 */
public interface TypeManager {

	public List<CardType> getPageList(CardBaseDto cardBaseDto);

}
