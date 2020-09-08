package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;

/**
 * 激活卡信息实体类
 * @author zhangli
 * 2018-09-18
 */
public class ActiveInformation extends CardBaseModel{
	// 卡号
	private String cardNo;

	// 母卡卡号
	private String motherCardNo;

	// 母子卡类别，1为亲情卡子卡，2为亲情卡母卡，null为挂账母子卡卡或者非任何母子卡
	private Integer motherType;

	// 制卡批次号
	private String serialNo;

	// 卡类别
	private Long category;

	// 状态
	private Integer status;

	// 所属门店
	private Long store;

	// 挂账状态
	private Integer creditStatus;

	// 挂账最高额度
	private Integer creditMaxQuota;

	// 充值余额总和
	private BigDecimal rechargeBalance;

	// 充值奖励余额总和
	private BigDecimal reward;

	// 挂账总额
	private BigDecimal credit;

	// 卡类别名称
	private String categoryName;

	// 持卡人姓名
	private String userName;

	// 持卡人性别
	private Integer sex;

	// 持卡人电话
	private String telephone;

	// 持卡人身份证
	private String idNumber;

	// 状态名称
	private String statusName;

	// 性别名称
	private String sexName;

	// 新卡卡号
	private String newCardNo;

	// 上传文件名
	private String fileName;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getMotherCardNo() {
		return motherCardNo;
	}

	public void setMotherCardNo(String motherCardNo) {
		this.motherCardNo = motherCardNo;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getStore() {
		return store;
	}

	public void setStore(Long store) {
		this.store = store;
	}

	public Integer getCreditStatus() {
		return creditStatus;
	}

	public void setCreditStatus(Integer creditStatus) {
		this.creditStatus = creditStatus;
	}

	public Integer getCreditMaxQuota() {
		return creditMaxQuota;
	}

	public void setCreditMaxQuota(Integer creditMaxQuota) {
		this.creditMaxQuota = creditMaxQuota;
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

	public BigDecimal getCredit() {
		return credit;
	}

	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	public String getNewCardNo() {
		return newCardNo;
	}

	public void setNewCardNo(String newCardNo) {
		this.newCardNo = newCardNo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getMotherType() {
		return motherType;
	}

	public void setMotherType(Integer motherType) {
		this.motherType = motherType;
	}

}
