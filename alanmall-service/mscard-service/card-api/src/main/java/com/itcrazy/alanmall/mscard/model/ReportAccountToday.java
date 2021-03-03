package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;

/**
 * 营收账款余额表（当日）实体类
 * @author yangliang
 * 2018-10-09
 */
public class ReportAccountToday extends CardBaseModel{
	// 卡号
	private String cardNo;

	// 客户名称
	private String userName;

	// 卡状态
	private int status;

	// 卡类别
	private String name;

	// 上日余额（本金）
	private BigDecimal yesterdayBalance;

	// 上日余额（奖励）
	private BigDecimal yesterdayReward;

	// 借方合计（本金）
	private BigDecimal storageBill;

	// 借方合计（奖励）
	private BigDecimal storageReward;

	// 贷方合计（本金）
	private BigDecimal loanRecharge;

	// 贷方合计（奖励）
	private BigDecimal loanReward;

	// 本日余额（本金）
	private BigDecimal surplusBalance;

	// 本日余额（奖励）
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

	public BigDecimal getYesterdayBalance() {
		return yesterdayBalance;
	}

	public void setYesterdayBalance(BigDecimal yesterdayBalance) {
		this.yesterdayBalance = yesterdayBalance;
	}

	public BigDecimal getYesterdayReward() {
		return yesterdayReward;
	}

	public void setYesterdayReward(BigDecimal yesterdayReward) {
		this.yesterdayReward = yesterdayReward;
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

	public BigDecimal getLoanRecharge() {
		return loanRecharge;
	}

	public void setLoanRecharge(BigDecimal loanRecharge) {
		this.loanRecharge = loanRecharge;
	}

	public BigDecimal getLoanReward() {
		return loanReward;
	}

	public void setLoanReward(BigDecimal loanReward) {
		this.loanReward = loanReward;
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
