package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 发卡/充值明细表实体类
 * @author huangchunbo
 * 2018-10-10
 */
public class ReportRechangeDetil extends CardBaseModel{
	// 卡号
	private String cardNo;

	// 卡类别名称
	private String categoryName;

	// 姓名
	private String userName;

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

	// 发卡时间
	private Date publishTime;

	// 发卡人
	private Long publishId;

	// 发卡门店
	private long publishStore;

	// 操作类型，null为充值，1为撤销
	private Integer actionType;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public Long getPublishId() {
		return publishId;
	}

	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}

	public long getPublishStore() {
		return publishStore;
	}

	public void setPublishStore(long publishStore) {
		this.publishStore = publishStore;
	}

	public Integer getActionType() {
		return actionType;
	}

	public void setActionType(Integer actionType) {
		this.actionType = actionType;
	}

}
