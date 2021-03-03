package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.ParameterDao;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import com.itcrazy.alanmall.mscard.manager.ParameterManager;
import com.itcrazy.alanmall.mscard.model.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 卡系统参数接口实现
 * @author zhangli
 * 2018-09-05
 */
@Slf4j
@Service
public class ParameterManagerImpl implements ParameterManager{

	@Autowired
	private ParameterDao parameterDao;

	@Override
	public Parameter getParamDetail(CardBaseDto cardBaseDto) {
		return parameterDao.getParamDetail(cardBaseDto);
	}

	@Override
	public Parameter addParam(Parameter parameter) {
		parameterDao.save(parameter);
		return parameter;
	}

	@Override
	public int updateParam(Parameter parameter) {
		return parameterDao.update(parameter);
	}

}
