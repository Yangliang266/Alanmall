package com.itcrazy.alanmall.mscard.vo.card;

/**
 * 卡充值记录展示类
 * @author chenfei
 * 2018-09-13
 */
public class RechargeHistoryVo {

	// id
	private Long id;

	// 卡号
	private String cardNo;

	// 卡类别名称
	private String categoryName;

	// 卡状态
	private String status;

	// 充值门店
	private String rechargeStore;

	// 充值支付方式
	private String payModeStr;

	// 充值金额
	private String rechargeAmount;

	// 奖励
	private String reward;

	// 充值时间
	private String rechargeTime;

	// 充值操作人
	private String rechargePerson;

	// 操作类型，null为充值，1为撤销
	private String actionType;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getRechargeTime() {
		return rechargeTime;
	}

	public void setRechargeTime(String rechargeTime) {
		this.rechargeTime = rechargeTime;
	}

	public String getRechargePerson() {
		return rechargePerson;
	}

	public void setRechargePerson(String rechargePerson) {
		this.rechargePerson = rechargePerson;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}