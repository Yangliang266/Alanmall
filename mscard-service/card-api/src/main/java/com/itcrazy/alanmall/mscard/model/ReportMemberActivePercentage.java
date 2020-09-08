package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;

public class ReportMemberActivePercentage extends CardBaseModel{
	private int categoryId;

	private String categoryName;

	private String cardNo;

	private String motherCardNo;

	private String name;

	private Long store;

	private BigDecimal recharge;

	private BigDecimal reward;

	private BigDecimal bill;

	private BigDecimal billReward;

	private BigDecimal rechargeBalance;

	private BigDecimal rechargeReward;

	private BigDecimal rechargeToday;

	private BigDecimal rewardToday;

	private BigDecimal rewardBillTotal;

	private BigDecimal rewardTotal;

	private BigDecimal rechargeTotal;

	private BigDecimal billTotal;


	public BigDecimal getRewardBillTotal() {
		return rewardBillTotal;
	}

	public void setRewardBillTotal(BigDecimal rewardBillTotal) {
		this.rewardBillTotal = rewardBillTotal;
	}

	public BigDecimal getRewardTotal() {
		return rewardTotal;
	}

	public void setRewardTotal(BigDecimal rewardTotal) {
		this.rewardTotal = rewardTotal;
	}

	public BigDecimal getRechargeTotal() {
		return rechargeTotal;
	}

	public void setRechargeTotal(BigDecimal rechargeTotal) {
		this.rechargeTotal = rechargeTotal;
	}

	public BigDecimal getBillTotal() {
		return billTotal;
	}

	public void setBillTotal(BigDecimal billTotal) {
		this.billTotal = billTotal;
	}

	public BigDecimal getRechargeReward() {
		return rechargeReward;
	}

	public void setRechargeReward(BigDecimal rechargeReward) {
		this.rechargeReward = rechargeReward;
	}

	public String getMotherCardNo() {
		return motherCardNo;
	}

	public void setMotherCardNo(String motherCardNo) {
		this.motherCardNo = motherCardNo;
	}

	public BigDecimal getReward() {
		return reward;
	}

	public void setReward(BigDecimal reward) {
		this.reward = reward;
	}

	public BigDecimal getBillReward() {
		return billReward;
	}

	public void setBillReward(BigDecimal billReward) {
		this.billReward = billReward;
	}

	public BigDecimal getRechargeToday() {
		return rechargeToday;
	}

	public void setRechargeToday(BigDecimal rechargeToday) {
		this.rechargeToday = rechargeToday;
	}

	public BigDecimal getRewardToday() {
		return rewardToday;
	}

	public void setRewardToday(BigDecimal rewardToday) {
		this.rewardToday = rewardToday;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getStore() {
		return store;
	}

	public void setStore(Long store) {
		this.store = store;
	}

	public BigDecimal getRecharge() {
		return recharge;
	}

	public void setRecharge(BigDecimal recharge) {
		this.recharge = recharge;
	}

	public BigDecimal getBill() {
		return bill;
	}

	public void setBill(BigDecimal bill) {
		this.bill = bill;
	}

	public BigDecimal getRechargeBalance() {
		return rechargeBalance;
	}

	public void setRechargeBalance(BigDecimal rechargeBalance) {
		this.rechargeBalance = rechargeBalance;
	}
}
