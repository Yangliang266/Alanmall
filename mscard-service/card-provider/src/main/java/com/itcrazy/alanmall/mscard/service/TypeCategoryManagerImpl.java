package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.TypeCategoryDao;
import com.itcrazy.alanmall.mscard.dto.Base.CardInformationDto;
import com.itcrazy.alanmall.mscard.manager.TypeCategoryManager;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 新建卡号(获取卡号，跳号数字)接口实现
 * @author huangchunbo
 * 2018-09-12
 */

@Slf4j
@Service
public class TypeCategoryManagerImpl implements TypeCategoryManager{

	@Autowired
	private TypeCategoryDao typeCategoryDao;

	// 获取卡号
	@Override
	public List<CardInformation> getPageList(CardInformationDto cardInformationDto) {

		return typeCategoryDao.getPageList(cardInformationDto);
	}

	//获取跳号数字
	@Override
	public List<CardInformation> getJumpNumberList(CardInformationDto cardInformationDto) {

		return typeCategoryDao.getJumpNumberList(cardInformationDto);
	}



}
