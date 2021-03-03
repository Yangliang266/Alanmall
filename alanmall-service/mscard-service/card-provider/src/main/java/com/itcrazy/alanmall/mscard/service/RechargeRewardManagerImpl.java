package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.RechargeRewardDao;
import com.itcrazy.alanmall.mscard.dto.Base.RechargeRewardDto;
import com.itcrazy.alanmall.mscard.manager.RechargeRewardManager;
import com.itcrazy.alanmall.mscard.model.RechargeReward;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 充值／奖励设置接口实现
 * @author zhangli
 * 2018-09-05
 */
@Slf4j
@Service
public class RechargeRewardManagerImpl implements RechargeRewardManager{

	@Autowired
	private RechargeRewardDao rechargeRewardDao;

	@Override
	public List<RechargeReward> getPageList(RechargeRewardDto rechargeRewardDto) {
		return rechargeRewardDao.getPageList(rechargeRewardDto);
	}

	@Override
	public int updateRechargeReward(RechargeReward rechargeReward) {
		return rechargeRewardDao.update(rechargeReward);
	}

	@Override
	public RechargeReward addRechargeReward(RechargeReward rechargeReward) {
		rechargeRewardDao.save(rechargeReward);
		return rechargeReward;
	}

	@Override
	public List<RechargeReward> getRewardRules(RechargeRewardDto rechargeRewardDto) {
		return rechargeRewardDao.getRewardRules(rechargeRewardDto);
	}
}
