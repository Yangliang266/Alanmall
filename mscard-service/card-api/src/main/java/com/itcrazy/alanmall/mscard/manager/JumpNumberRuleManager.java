package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import com.itcrazy.alanmall.mscard.model.JumpNumberRule;

import java.util.List;

/**
 * 跳号规则设置接口
 * @author zhangzhongtian
 * 2018-09-04
 */
public interface JumpNumberRuleManager {

	public List<JumpNumberRule> getJumpNumberRuleList(CardBaseDto cardBaseDto);

	public int updateJumpNumberRule(JumpNumberRule jumpNumberRule);

	public JumpNumberRule addJumpNumberRule(JumpNumberRule jumpNumberRule);

}
