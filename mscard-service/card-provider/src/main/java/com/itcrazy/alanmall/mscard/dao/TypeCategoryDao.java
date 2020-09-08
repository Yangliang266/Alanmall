package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.CardInformationDto;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 新建卡号（获取卡状态，跳号数字）Dao接口
 * @author huangchunbo
 * 2018-09-29
 */
@Component
public interface TypeCategoryDao extends BaseDao<CardInformation, Long> {

	public List<CardInformation> getPageList(CardInformationDto cardInformationDto);

	public List<CardInformation> getJumpNumberList(CardInformationDto cardInformationDto);

}
