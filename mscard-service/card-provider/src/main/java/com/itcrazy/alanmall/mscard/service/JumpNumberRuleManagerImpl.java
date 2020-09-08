package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.JumpNumberRuleDao;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import com.itcrazy.alanmall.mscard.manager.JumpNumberRuleManager;
import com.itcrazy.alanmall.mscard.model.JumpNumberRule;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 跳号设置接口实现
 * @author zhangzhongtian
 * 2018-09-18
 */
@Slf4j
@Service
public class JumpNumberRuleManagerImpl implements JumpNumberRuleManager{

	@Autowired
	private JumpNumberRuleDao jumpNumberRuleDao;

	@Override
	public List<JumpNumberRule> getJumpNumberRuleList(CardBaseDto cardBaseDto) {
		// TODO Auto-generated method stub
		return jumpNumberRuleDao.getJumpNumberRuleList(cardBaseDto);
	}

	@Override
	public int updateJumpNumberRule(JumpNumberRule jumpNumberRule) {
		// TODO Auto-generated method stub
		return jumpNumberRuleDao.update(jumpNumberRule);
	}

	@Override
	public JumpNumberRule addJumpNumberRule(JumpNumberRule jumpNumberRule) {
		// TODO Auto-generated method stub
		jumpNumberRuleDao.save(jumpNumberRule);
		return jumpNumberRule;
	}

}
