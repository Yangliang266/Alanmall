package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;

/**
 * 订单一览对象
 * @author chenfei
 * 2018-10-11
 */
public class OrderList extends CardBaseModel{
	// 订单号
	private String orderNo;
	// 订单状态
	private int status;
	// 消费方式
	private String consumeMode;
	// 卡号
	private String cardNo;
	// 卡类别
	private Long category;
	// 手机号码
	private String telephone;
	// 消费门店
	private Long store;
	// 账单总金额
	private BigDecimal bill;
	// 消费产生的奖励金额
	private BigDecimal addReward;
	// 储值本金消费金额
	private BigDecimal storageBill;
	// 储值奖励消费金额
	private BigDecimal storageReward;
	// 挂账金额
	private BigDecimal creditBill;
	// 其他支付方式消费金额
	private BigDecimal payModeBill;
	//其他支付消费方式
	private int otherPayMode;

	// ERP/POS订单结算时间（打印用）
	private String balanceTime;

	// 结算操作人(打印用)
	private String operator;

	// 其他支付消费方式名称(打印用)
	private String payModeName;

	// 本金消费备注
	private String storageRemarks;

	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getConsumeMode() {
		return consumeMode;
	}
	public void setConsumeMode(String consumeMode) {
		this.consumeMode = consumeMode;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Long getCategory() {
		return category;
	}
	public void setCategory(Long category) {
		this.category = category;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Long getStore() {
		return store;
	}
	public void setStore(Long store) {
		this.store = store;
	}
	public BigDecimal getBill() {
		return bill;
	}
	public void setBill(BigDecimal bill) {
		this.bill = bill;
	}
	public BigDecimal getAddReward() {
		return addReward;
	}
	public void setAddReward(BigDecimal addReward) {
		this.addReward = addReward;
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
	public BigDecimal getCreditBill() {
		return creditBill;
	}
	public void setCreditBill(BigDecimal creditBill) {
		this.creditBill = creditBill;
	}
	public BigDecimal getPayModeBill() {
		return payModeBill;
	}
	public void setPayModeBill(BigDecimal payModeBill) {
		this.payModeBill = payModeBill;
	}
	public int getOtherPayMode() {
		return otherPayMode;
	}
	public void setOtherPayMode(int otherPayMode) {
		this.otherPayMode = otherPayMode;
	}
	public String getBalanceTime() {
		return balanceTime;
	}
	public void setBalanceTime(String balanceTime) {
		this.balanceTime = balanceTime;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getPayModeName() {
		return payModeName;
	}
	public void setPayModeName(String payModeName) {
		this.payModeName = payModeName;
	}
	public String getStorageRemarks() {
		return storageRemarks;
	}
	public void setStorageRemarks(String storageRemarks) {
		this.storageRemarks = storageRemarks;
	}

}