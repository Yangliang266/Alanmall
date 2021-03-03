package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;

/**
 * 营收账款余额表（时段）实体类
 * @author yangliang
 * 2018-10-09
 */
public class ReportAccountPeriod extends CardBaseModel{
	// 卡号
	private String cardNo;

	// 客户名称
	private String userName;

	// 卡状态
	private int status;

	// 卡类别
	private String name;

	// 日出余额（本金）
	private BigDecimal beforeBalanceSum;

	// 日出余额（奖励）
	private BigDecimal beforeRewardSum;

	// 充值金额
	private BigDecimal rechargeBalance;

	// 奖励
	private BigDecimal rewardBalance;

	// 本金消费金额
	private BigDecimal storageBill;

	// 奖励消费金额
	private BigDecimal storageReward;

	// 卡内结余金额（本金）
	private BigDecimal surplusBalance;

	// 卡内结余金额（奖励）
	private BigDecimal surplusReward;

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getBeforeBalanceSum() {
		return beforeBalanceSum;
	}

	public void setBeforeBalanceSum(BigDecimal beforeBalanceSum) {
		this.beforeBalanceSum = beforeBalanceSum;
	}

	public BigDecimal getBeforeRewardSum() {
		return beforeRewardSum;
	}

	public void setBeforeRewardSum(BigDecimal beforeRewardSum) {
		this.beforeRewardSum = beforeRewardSum;
	}

	public BigDecimal getRechargeBalance() {
		return rechargeBalance;
	}

	public void setRechargeBalance(BigDecimal rechargeBalance) {
		this.rechargeBalance = rechargeBalance;
	}

	public BigDecimal getRewardBalance() {
		return rewardBalance;
	}

	public void setRewardBalance(BigDecimal rewardBalance) {
		this.rewardBalance = rewardBalance;
	}

	public BigDecimal getStorageBill() {
		return storageBill;
	}

	public void setStorageBill(BigDecimal storageBill) {
		this.storageBill = storageBill;
	}

	public BigDecimal getStorageReward() {
		return storageReward;
	}

	public void setStorageReward(BigDecimal storageReward) {
		this.storageReward = storageReward;
	}

	public BigDecimal getSurplusBalance() {
		return surplusBalance;
	}

	public void setSurplusBalance(BigDecimal surplusBalance) {
		this.surplusBalance = surplusBalance;
	}

	public BigDecimal getSurplusReward() {
		return surplusReward;
	}

	public void setSurplusReward(BigDecimal surplusReward) {
		this.surplusReward = surplusReward;
	}

}
