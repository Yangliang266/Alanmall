package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.CreditDto;
import com.itcrazy.alanmall.mscard.model.Credit;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 子卡绑定DAO层接口
 * @author zhangzhongtian
 * 2018-09-29
 */
@Component
public interface CardBindingDao extends BaseDao<Credit, Long> {

	public List<Credit> getCardBindingList(CreditDto creditDto);

}
