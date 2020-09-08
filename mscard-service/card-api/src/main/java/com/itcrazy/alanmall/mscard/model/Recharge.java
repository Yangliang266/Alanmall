package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;
import java.util.Date;

public class Recharge extends CardBaseModel{
	// 门店入库单号
	private String storeInReceiptNo;

	// 卡号
	private String cardNo;

	// 卡类别
	private Integer category;

	// 卡类别名称
	private String categoryName;

	// 卡状态
	private int status;

	// 门店入库时间
	private Date storeInTime;

	// 门店入库操作人
	private Long storeInPerson;

	// 充值总额
	private BigDecimal rechargeBalance;

	// 是否可充值
	private int isRecharge;

	// 可充值次数(为null，代表可无限充值)
	private Integer maxRechargeCount;

	// 已充值次数
	private int rechargeCount;

	// 是否是记名卡
	private int isNamed;

	public String getStoreInReceiptNo() {
		return storeInReceiptNo;
	}

	public void setStoreInReceiptNo(String storeInReceiptNo) {
		this.storeInReceiptNo = storeInReceiptNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
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

	public Date getStoreInTime() {
		return storeInTime;
	}

	public void setStoreInTime(Date storeInTime) {
		this.storeInTime = storeInTime;
	}

	public Long getStoreInPerson() {
		return storeInPerson;
	}

	public void setStoreInPerson(Long storeInPerson) {
		this.storeInPerson = storeInPerson;
	}

	public BigDecimal getRechargeBalance() {
		return rechargeBalance;
	}

	public void setRechargeBalance(BigDecimal rechargeBalance) {
		this.rechargeBalance = rechargeBalance;
	}

	public int getIsRecharge() {
		return isRecharge;
	}

	public void setIsRecharge(int isRecharge) {
		this.isRecharge = isRecharge;
	}

	public Integer getMaxRechargeCount() {
		return maxRechargeCount;
	}

	public void setMaxRechargeCount(Integer maxRechargeCount) {
		this.maxRechargeCount = maxRechargeCount;
	}

	public int getRechargeCount() {
		return rechargeCount;
	}

	public void setRechargeCount(int rechargeCount) {
		this.rechargeCount = rechargeCount;
	}

	public int getIsNamed() {
		return isNamed;
	}

	public void setIsNamed(int isNamed) {
		this.isNamed = isNamed;
	}

}
