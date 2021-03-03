package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import com.itcrazy.alanmall.mscard.model.CardType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 读卡器型号DAO层接口
 * @author zhangli
 * 2018-09-04
 */
@Component
public interface CardTypeDao extends BaseDao<CardType, Long> {

	public List<CardType> getPageList(CardBaseDto cardBaseDto);

}
