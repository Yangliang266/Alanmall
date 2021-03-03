package com.itcrazy.alanmall.mscard.vo.card;

/**
 * 发卡/充值明细展示类
 * @author huangchunbo
 * 2018-10-10
 */
public class ReportRechargeDetilVo {

	// 卡号
	private String cardNo;

	// 卡类别名称
	private String categoryName;

	// 姓名
	private String userName;

	// 充值门店
	private String rechargeStore;

	// 充值支付方式
	private String payModeStr;

	// 充值金额
	private String rechargeAmount;

	// 奖励
	private String reward;

	// 发卡时间
	private String publishTime;

	// 发卡人
	private String publishId;

	// 发卡门店
	private String publishStore;

	// 操作类型，null为充值，1为撤销
	private String actionType;


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

	public String getRechargeStore() {
		return rechargeStore;
	}

	public void setRechargeStore(String rechargeStore) {
		this.rechargeStore = rechargeStore;
	}

	public String getPayModeStr() {
		return payModeStr;
	}

	public void setPayModeStr(String payModeStr) {
		this.payModeStr = payModeStr;
	}

	public String getRechargeAmount() {
		return rechargeAmount;
	}

	public void setRechargeAmount(String rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getPublishId() {
		return publishId;
	}

	public void setPublishId(String publishId) {
		this.publishId = publishId;
	}

	public String getPublishStore() {
		return publishStore;
	}

	public void setPublishStore(String publishStore) {
		this.publishStore = publishStore;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

}