package com.itcrazy.alanmall.mscard.vo.card;

public class ReportAccountTodayVo {
	// 卡号
	private String cardNo;

	// 客户名称
	private String userName;

	// 卡状态
	private String status;

	// 卡类别
	private String name;

	// 上日余额（本金）
	private String yesterdayBalance;

	// 上日余额（奖励）
	private String yesterdayReward;

	// 借方合计（本金）
	private String storageBill;

	// 借方合计（奖励）
	private String storageReward;

	// 贷方合计（本金）
	private String loanRecharge;

	// 贷方合计（奖励）
	private String loanReward;

	// 本日余额（本金）
	private String surplusBalance;

	// 本日余额（奖励）
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

	public String getYesterdayBalance() {
		return yesterdayBalance;
	}

	public void setYesterdayBalance(String yesterdayBalance) {
		this.yesterdayBalance = yesterdayBalance;
	}

	public String getYesterdayReward() {
		return yesterdayReward;
	}

	public void setYesterdayReward(String yesterdayReward) {
		this.yesterdayReward = yesterdayReward;
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

	public String getLoanRecharge() {
		return loanRecharge;
	}

	public void setLoanRecharge(String loanRecharge) {
		this.loanRecharge = loanRecharge;
	}

	public String getLoanReward() {
		return loanReward;
	}

	public void setLoanReward(String loanReward) {
		this.loanReward = loanReward;
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
