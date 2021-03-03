package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import com.itcrazy.alanmall.mscard.model.JumpNumberRule;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 跳号规则设置DAO层接口
 * @author zhangzhongtian
 * 2018-09-18
 */
@Component
public interface JumpNumberRuleDao extends BaseDao<JumpNumberRule, Long> {

	public List<JumpNumberRule> getJumpNumberRuleList(CardBaseDto cardBaseDto);

}
