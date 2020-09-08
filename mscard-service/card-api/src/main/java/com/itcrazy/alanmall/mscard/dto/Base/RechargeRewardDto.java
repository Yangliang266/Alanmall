package com.itcrazy.alanmall.mscard.dto.Base;

import lombok.Data;

/**
 * 充值／奖励设置Dto类
 * @author zhangli
 * 2018-10-17
 */
@Data
public class RechargeRewardDto extends CardBaseDto{
	// 充值方式
	private Integer rechargeMode;

	// 充值金额（固定/段）
	private String recharge;

	// 可用卡类别
	private String cardCategorie;

	// 编号
	private Long id;

	// 奖励规则
	private Integer rewardMode;

	// 奖励金额（值/百分比)
	private Integer reward;

}
