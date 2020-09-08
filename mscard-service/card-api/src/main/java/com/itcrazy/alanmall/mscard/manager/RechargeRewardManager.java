package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.RechargeRewardDto;
import com.itcrazy.alanmall.mscard.model.RechargeReward;

import java.util.List;

/**
 * 充值／奖励设置接口
 * @author zhangli
 * 2018-09-05
 */
public interface RechargeRewardManager {

	public List<RechargeReward> getPageList(RechargeRewardDto rechargeRewardDto);

	public int updateRechargeReward(RechargeReward rechargeReward);

	public RechargeReward addRechargeReward(RechargeReward rechargeReward);

	public List<RechargeReward> getRewardRules(RechargeRewardDto rechargeRewardDto);

}
