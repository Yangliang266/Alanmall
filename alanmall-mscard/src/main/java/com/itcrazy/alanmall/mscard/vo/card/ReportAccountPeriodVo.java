package com.itcrazy.alanmall.mscard.vo.card;

public class ReportAccountPeriodVo {
	// 卡号
	private String cardNo;

	// 客户名称
	private String userName;

	// 卡状态
	private String status;

	// 卡类别
	private String name;

	// 日出余额（本金）
	private String beforeBalanceSum;

	// 日出余额（奖励）
	private String beforeRewardSum;

	// 充值金额
	private String rechargeBalance;

	// 奖励
	private String rewardBalance;

	// 本金消费金额
	private String storageBill;

	// 奖励消费金额
	private String storageReward;

	// 卡内结余金额（本金）
	private String surplusBalance;

	// 卡内结余金额（奖励）
	private String surplusReward;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeforeBalanceSum() {
		return beforeBalanceSum;
	}

	public void setBeforeBalanceSum(String beforeBalanceSum) {
		this.beforeBalanceSum = beforeBalanceSum;
	}

	public String getBeforeRewardSum() {
		return beforeRewardSum;
	}

	public void setBeforeRewardSum(String beforeRewardSum) {
		this.beforeRewardSum = beforeRewardSum;
	}

	public String getRechargeBalance() {
		return rechargeBalance;
	}

	public void setRechargeBalance(String rechargeBalance) {
		this.rechargeBalance = rechargeBalance;
	}

	public String getRewardBalance() {
		return rewardBalance;
	}

	public void setRewardBalance(String rewardBalance) {
		this.rewardBalance = rewardBalance;
	}

	public String getStorageBill() {
		return storageBill;
	}

	public void setStorageBill(String storageBill) {
		this.storageBill = storageBill;
	}

	public String getStorageReward() {
		return storageReward;
	}

	public void setStorageReward(String storageReward) {
		this.storageReward = storageReward;
	}

	public String getSurplusBalance() {
		return surplusBalance;
	}

	public void setSurplusBalance(String surplusBalance) {
		this.surplusBalance = surplusBalance;
	}

	public String getSurplusReward() {
		return surplusReward;
	}

	public void setSurplusReward(String surplusReward) {
		this.surplusReward = surplusReward;
	}


}
