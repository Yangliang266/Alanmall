package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;
import java.util.Date;

public class RechargeHistory extends CardBaseModel{
	// id
	private Long id;

	// 卡号
	private String cardNo;

	// 卡类别名称
	private String categoryName;

	// 卡状态
	private int status;

	// 充值门店
	private Long rechargeStore;

	// 充值支付方式
	private Long payMode;

	// 充值支付方式
	private String payModeStr;

	// 充值金额
	private BigDecimal rechargeAmount;

	// 奖励
	private BigDecimal reward;

	// 充值时间
	private Date rechargeTime;

	// 充值操作人
	private Long rechargePerson;

	// 操作类型，null:充值，1:撤销
	private Integer actionType;

	// 备注
	private String remarks;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getRechargeStore() {
		return rechargeStore;
	}

	public void setRechargeStore(Long rechargeStore) {
		this.rechargeStore = rechargeStore;
	}

	public Long getPayMode() {
		return payMode;
	}

	public void setPayMode(Long payMode) {
		this.payMode = payMode;
	}

	public String getPayModeStr() {
		return payModeStr;
	}

	public void setPayModeStr(String payModeStr) {
		this.payModeStr = payModeStr;
	}

	public BigDecimal getRechargeAmount() {
		return rechargeAmount;
	}

	public void setRechargeAmount(BigDecimal rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}

	public BigDecimal getReward() {
		return reward;
	}

	public void setReward(BigDecimal reward) {
		this.reward = reward;
	}

	public Date getRechargeTime() {
		return rechargeTime;
	}

	public void setRechargeTime(Date rechargeTime) {
		this.rechargeTime = rechargeTime;
	}

	public Long getRechargePerson() {
		return rechargePerson;
	}

	public void setRechargePerson(Long rechargePerson) {
		this.rechargePerson = rechargePerson;
	}

	public Integer getActionType() {
		return actionType;
	}

	public void setActionType(Integer actionType) {
		this.actionType = actionType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
