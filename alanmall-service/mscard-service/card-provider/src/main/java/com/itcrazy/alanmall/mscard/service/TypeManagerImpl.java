package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.CardTypeDao;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import com.itcrazy.alanmall.mscard.manager.TypeManager;
import com.itcrazy.alanmall.mscard.model.CardType;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 读卡器型号接口实现
 * @author zhangli
 * 2018-09-04
 */

@Slf4j
@Service
public class TypeManagerImpl implements TypeManager{

	@Autowired
	private CardTypeDao cardTypeDao;

	@Override
	public List<CardType> getPageList(CardBaseDto cardBaseDto) {
		return cardTypeDao.getPageList(cardBaseDto);
	}

}
