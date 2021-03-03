package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 亲情卡管理实体类
 * @author huangchunbo
 * 2018-11-13
 */
public class CardFamily extends CardBaseModel{
	private static final long serialVersionUID = -7476060073667415759L;

	// 卡号
	private String cardNo;

	// 卡类别
	private String name;

	// 母子卡类别
	private String motherCardNo;

	// 姓名
	private String userName;

	// 性别
	private Integer sex;

	// 手机号码
	private String telephone;

	// 身份证号码
	private String idNumber;
	// 支付密码
	private String payPsw;

	// 电子邮件
	private String mail;

	// 送货地址
	private String address;

	// 生日
	private Date birthday;

	// 充值余额总和
	private BigDecimal rechargeBalance;

	// 卡充值奖励总和
	private BigDecimal reward;

	// 卡状态
	private int status;

	// 卡类型(母/子卡)
	private String cardType;

	// 卡类别id
	private Long categoryId;

	// 母卡类别 null为挂账母卡，1为情亲母卡
	private Integer motherType;

	// 是否可充值
	private Integer isRecharge;

	// 消费总额
	private BigDecimal allBill;

	// 消费本金
	private BigDecimal bill;

	// 消费奖励本金
	private BigDecimal childReward;

	// 挂账总额
	private BigDecimal credit;

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

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
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

	public BigDecimal getRechargeBalance() {
		return rechargeBalance;
	}

	public void setRechargeBalance(BigDecimal rechargeBalance) {
		this.rechargeBalance = rechargeBalance;
	}

	public BigDecimal getReward() {
		return reward;
	}

	public void setReward(BigDecimal reward) {
		this.reward = reward;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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

	public Integer getMotherType() {
		return motherType;
	}

	public void setMotherType(Integer motherType) {
		this.motherType = motherType;
	}

	public Integer getIsRecharge() {
		return isRecharge;
	}

	public void setIsRecharge(Integer isRecharge) {
		this.isRecharge = isRecharge;
	}

	public String getPayPsw() {
		return payPsw;
	}

	public void setPayPsw(String payPsw) {
		this.payPsw = payPsw;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public BigDecimal getAllBill() {
		return allBill;
	}

	public void setAllBill(BigDecimal allBill) {
		this.allBill = allBill;
	}

	public BigDecimal getBill() {
		return bill;
	}

	public void setBill(BigDecimal bill) {
		this.bill = bill;
	}

	public BigDecimal getChildReward() {
		return childReward;
	}

	public void setChildReward(BigDecimal childReward) {
		this.childReward = childReward;
	}

	public BigDecimal getCredit() {
		return credit;
	}

	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}

}
