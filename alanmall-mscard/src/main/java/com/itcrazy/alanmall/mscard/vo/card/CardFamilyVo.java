package com.itcrazy.alanmall.mscard.vo.card;

import java.math.BigDecimal;

/**
 * 情亲卡管理展示类
 * @author huangchunbo
 * 2018-11-13
 */
public class CardFamilyVo {
	// 卡号
	private String cardNo;

	// 卡类别
	private String name;

	// 母子卡类别
	private String motherCardNo;

	// 姓名
	private String userName;

	// 性别
	private String sex;

	// 手机号码
	private String telephone;

	// 身份证号码
	private String idNumber;

	// 充值余额总和
	private String rechargeBalance;

	// 卡充值奖励总和
	private String reward;

	// 卡状态
	private String status;

	// 卡类型(母/子卡)
	private String cardType;

	// 卡类别id
	private Long categoryId;

	// 母卡类别 null为挂账母卡，1为情亲母卡
	private String motherType;

	// 是否可充值
	private String isRecharge;

	// 表credit_setting条数
	private Integer creditNumber;

	// 消费总额
	private BigDecimal allBill;

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

	public String getMotherCardNo() {
		return motherCardNo;
	}

	public void setMotherCardNo(String motherCardNo) {
		this.motherCardNo = motherCardNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getRechargeBalance() {
		return rechargeBalance;
	}

	public void setRechargeBalance(String rechargeBalance) {
		this.rechargeBalance = rechargeBalance;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getMotherType() {
		return motherType;
	}

	public void setMotherType(String motherType) {
		this.motherType = motherType;
	}

	public String getIsRecharge() {
		return isRecharge;
	}

	public void setIsRecharge(String isRecharge) {
		this.isRecharge = isRecharge;
	}

	public Integer getCreditNumber() {
		return creditNumber;
	}

	public void setCreditNumber(Integer creditNumber) {
		this.creditNumber = creditNumber;
	}

	public BigDecimal getAllBill() {
		return allBill;
	}

	public void setAllBill(BigDecimal allBill) {
		this.allBill = allBill;
	}


}
