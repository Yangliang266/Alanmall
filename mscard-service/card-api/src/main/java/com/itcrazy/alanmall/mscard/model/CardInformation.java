package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 卡信息实体类
 * @author huangchunbo
 * 2018-09-04
 */

public class CardInformation extends CardBaseModel{
	//卡号
	private String cardNo;

	//母卡卡号
	private String motherCardNo;

	// 母子卡类别，1为亲情卡子卡，2为亲情卡母卡，null为挂账母子卡卡或者非任何母子卡
	private Integer motherType;

	//制卡批次号
	private String serialNo;

	//卡类别
	private Integer category;

	//状态
	private int status;

	//所属门店
	private Long store;

	//挂账状态
	private int creditStatus;

	//挂账最高额度
	private BigDecimal creditMaxQuota;

	// 充值余额总和
	private BigDecimal rechargeBalance;

	// 充值奖励总和
	private BigDecimal reward;

	// 挂账总额
	private BigDecimal credit;

	// 卡类别名称
	private String name;

	//跳号数字
	private int jumpNumber;

	// 门店入库单号
	private String receiptNo;

	// 是否记名卡
	private int isNamed;

	// 门店入库时间
	private Date storeInTime;

	// 门店入库操作人
	private Long storeInPerson;

	// 卡支付密码是否必填
	private  int isPswMust;

	// 上传文件名
	private String fileName;

	public Integer getMotherType() {
		return motherType;
	}

	public void setMotherType(Integer motherType) {
		this.motherType = motherType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getStore() {
		return store;
	}

	public void setStore(Long store) {
		this.store = store;
	}

	public int getCreditStatus() {
		return creditStatus;
	}

	public void setCreditStatus(int creditStatus) {
		this.creditStatus = creditStatus;
	}

	public BigDecimal getCreditMaxQuota() {
		return creditMaxQuota;
	}

	public void setCreditMaxQuota(BigDecimal creditMaxQuota) {
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

	public int getJumpNumber() {
		return jumpNumber;
	}

	public void setJumpNumber(int jumpNumber) {
		this.jumpNumber = jumpNumber;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public int getIsNamed() {
		return isNamed;
	}

	public void setIsNamed(int isNamed) {
		this.isNamed = isNamed;
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

	public int getIsPswMust() {
		return isPswMust;
	}

	public void setIsPswMust(int isPswMust) {
		this.isPswMust = isPswMust;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
