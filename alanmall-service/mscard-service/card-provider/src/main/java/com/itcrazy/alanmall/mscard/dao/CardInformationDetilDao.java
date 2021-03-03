package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.CardInformationDto;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import java.util.List;

/**
 * 制卡管理详情Dao接口
 * @author huangchunbo
 * 2018-09-29
 */
public interface CardInformationDetilDao extends BaseDao<CardInformation, Long> {

	List<CardInformation> getPageDetilList(CardInformationDto cardInformationDto);

	Integer getPageDetilTotal(CardInformationDto cardInformationDto);

}
