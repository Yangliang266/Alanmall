package com.itcrazy.alanmall.mscard.model;

/**
 * 充值／奖励设置实体类
 * @author zhangli
 * 2018-09-05
 */
public class RechargeReward extends CardBaseModel{
	// 编号
	private Long id;

	// 充值方式
	private Integer rechargeMode;

	// 充值金额（固定/段）
	private String recharge;

	// 奖励规则
	private Integer rewardMode;

	// 奖励金额（值/百分比)
	private Integer reward;

	// 可用卡类别
	private String cardCategories;

	// 可用卡类别名称
	private String cardCategoriesName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRechargeMode() {
		return rechargeMode;
	}

	public void setRechargeMode(Integer rechargeMode) {
		this.rechargeMode = rechargeMode;
	}

	public String getRecharge() {
		return recharge;
	}

	public void setRecharge(String recharge) {
		this.recharge = recharge;
	}

	public Integer getRewardMode() {
		return rewardMode;
	}

	public void setRewardMode(Integer rewardMode) {
		this.rewardMode = rewardMode;
	}

	public Integer getReward() {
		return reward;
	}

	public void setReward(Integer reward) {
		this.reward = reward;
	}

	public String getCardCategories() {
		return cardCategories;
	}

	public void setCardCategories(String cardCategories) {
		this.cardCategories = cardCategories;
	}

	public String getCardCategoriesName() {
		return cardCategoriesName;
	}

	public void setCardCategoriesName(String cardCategoriesName) {
		this.cardCategoriesName = cardCategoriesName;
	}

}
