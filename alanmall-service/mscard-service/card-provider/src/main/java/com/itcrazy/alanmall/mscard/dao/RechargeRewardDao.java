package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.RechargeRewardDto;
import com.itcrazy.alanmall.mscard.model.RechargeReward;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 充值／奖励设置DAO层接口
 * @author zhangli
 * 2018-09-05
 */
@Component
public interface RechargeRewardDao extends BaseDao<RechargeReward, Long> {

	public List<RechargeReward> getPageList(RechargeRewardDto rechargeRewardDto);

	/**
	 * 获取奖励规则
	 * @param rechargeRewardDto
	 * @return
	 */
	public List<RechargeReward> getRewardRules(RechargeRewardDto rechargeRewardDto);

}
