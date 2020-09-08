package com.itcrazy.alanmall.mscard.vo.card;

/**
 * 充值／奖励设置页面展示类
 * @author zhangli
 * 2018-09-05
 */
public class RechargeRewardVo {

	// 编号
	private Long id;

	// 充值金额
	private String recharge;

	// 奖励金额
	private String reward;

	// 可用卡类别
	private String cardCategories;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRecharge() {
		return recharge;
	}

	public void setRecharge(String recharge) {
		this.recharge = recharge;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public String getCardCategories() {
		return cardCategories;
	}

	public void setCardCategories(String cardCategories) {
		this.cardCategories = cardCategories;
	}

}
