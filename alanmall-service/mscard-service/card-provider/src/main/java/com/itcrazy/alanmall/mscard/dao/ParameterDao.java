package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import com.itcrazy.alanmall.mscard.model.Parameter;
import org.springframework.stereotype.Component;

/**
 * 卡系统参数DAO层接口
 * @author zhangli
 * 2018-09-05
 */
@Component
public interface ParameterDao extends BaseDao<Parameter, Long> {

	public Parameter getParamDetail(CardBaseDto cardBaseDto);

}
