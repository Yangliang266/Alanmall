package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import com.itcrazy.alanmall.mscard.model.Parameter;

/**
 * 卡系统参数接口
 * @author zhangli
 * 2018-09-05
 */
public interface ParameterManager {

	public Parameter getParamDetail(CardBaseDto cardBaseDto);

	public Parameter addParam(Parameter parameter);

	public int updateParam(Parameter parameter);

}
