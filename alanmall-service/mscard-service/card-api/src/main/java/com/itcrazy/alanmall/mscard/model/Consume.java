package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;

/**
 * 消费类
 * @author chenfei
 * 2018-10-10
 */
public class Consume extends CardBaseModel{
	private static final BigDecimal DEFAULT_MONEY = new BigDecimal(0);

	/** 订单号(String)*/
	private String orderNo;

	/** 卡号 (String)*/
	private String cardNo;

	/** 手机号 (String)*/
	private String telephone;

	/** 消费品牌(Long)*/
	private Long brandId;

	/** 消费门店 (Long)*/
	private Long storeId;

	/** 消费金额 (BigDecimal)*/
	private BigDecimal amount = DEFAULT_MONEY;

	/** 本金消费 (BigDecimal)*/
	private BigDecimal storage = DEFAULT_MONEY;

	/** 奖励金额（消费时抵扣的奖励金额）*/
	private BigDecimal reward = DEFAULT_MONEY;

	/** 挂账消费金额 (BigDecimal)*/
	private BigDecimal credit = DEFAULT_MONEY;

	/** 其他消费金额 (BigDecimal)*/
	private BigDecimal other = DEFAULT_MONEY;

	/** 奖励金额（消费时产生的奖励）*/
	private BigDecimal addReward;

	/** 支付方式*/
	private Integer payMode;

	/** 支付密码*/
	private String payPwd;

	/** 用户ID (Long)*/
	private Long userId;
	/** 商家ID (Long) 继承在父类中*/

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getStorage() {
		return storage;
	}

	public void setStorage(BigDecimal storage) {
		this.storage = storage;
	}

	public BigDecimal getReward() {
		return reward;
	}

	public void setReward(BigDecimal reward) {
		this.reward = reward;
	}

	public BigDecimal getCredit() {
		return credit;
	}

	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}

	public BigDecimal getAddReward() {
		return addReward;
	}

	public void setAddReward(BigDecimal addReward) {
		this.addReward = addReward;
	}

	public String getPayPwd() {
		return payPwd;
	}

	public void setPayPwd(String payPwd) {
		this.payPwd = payPwd;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public BigDecimal getOther() {
		return other;
	}

	public void setOther(BigDecimal other) {
		this.other = other;
	}

	public Integer getPayMode() {
		return payMode;
	}

	public void setPayMode(Integer payMode) {
		this.payMode = payMode;
	}
}
