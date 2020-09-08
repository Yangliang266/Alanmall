package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.CardInformationDetilDao;
import com.itcrazy.alanmall.mscard.dto.Base.CardInformationDto;
import com.itcrazy.alanmall.mscard.manager.CardInforDetilManager;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 卡类别接口实现
 * @author chenfei
 * 2018-09-03
 */
@Slf4j
@Service
public class CardInforDetilManagerImpl implements CardInforDetilManager{

	@Autowired
	private CardInformationDetilDao cardInformationDetilDao;

	@Override
	public List<CardInformation> getPageDetilList(CardInformationDto cardInformationDto) {
		return cardInformationDetilDao.getPageDetilList(cardInformationDto);
	}

	@Override
	public Integer getPageDetilTotal(CardInformationDto cardInformationDto) {
		return cardInformationDetilDao.getPageDetilTotal(cardInformationDto);
	}

}
