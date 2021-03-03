package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 挂账／清账报表（汇总）
 * @author luxf
 * 2018-10-11
 */
public class ReportCreditAccount extends CardBaseModel{
	// 卡号
	private String cardNo;

	// 客户名称
	private String userName;

	// 状态
	private int status;

	// 卡类型
	private String name;

	// 总挂账笔数
	private String creditNum;

	// 总挂账金额
	private BigDecimal creditBill;

	// 全清账笔数
	private String allClearNum;

	// 全清账金额
	private BigDecimal allClearBill;

	// 部分清账笔数
	private String partClearNum;

	// 部分清账金额
	private BigDecimal partClearBill;

	// 未清账笔数（包括全清、部分清账）
	private String notClearNum;

	// 未清账金额（包括全清、部分清账）
	private BigDecimal notClearBill;

	// 账单编号
	private String idCard;

	// 消费时间
	private Date consumeTime;

	// 账单总金额
	private BigDecimal bill;

	// 挂帐金额
	private BigDecimal creditCardBill;

	// 已清账金额
	private BigDecimal clearBill;

	// 未清账金额
	private BigDecimal credit;

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Date getConsumeTime() {
		return consumeTime;
	}

	public void setConsumeTime(Date consumeTime) {
		this.consumeTime = consumeTime;
	}

	public BigDecimal getBill() {
		return bill;
	}

	public void setBill(BigDecimal bill) {
		this.bill = bill;
	}

	public BigDecimal getCreditCardBill() {
		return creditCardBill;
	}

	public void setCreditCardBill(BigDecimal creditCardBill) {
		this.creditCardBill = creditCardBill;
	}

	public BigDecimal getClearBill() {
		return clearBill;
	}

	public void setClearBill(BigDecimal clearBill) {
		this.clearBill = clearBill;
	}

	public BigDecimal getCredit() {
		return credit;
	}

	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreditNum() {
		return creditNum;
	}

	public void setCreditNum(String creditNum) {
		this.creditNum = creditNum;
	}

	public BigDecimal getCreditBill() {
		return creditBill;
	}

	public void setCreditBill(BigDecimal creditBill) {
		this.creditBill = creditBill;
	}

	public String getAllClearNum() {
		return allClearNum;
	}

	public void setAllClearNum(String allClearNum) {
		this.allClearNum = allClearNum;
	}

	public BigDecimal getAllClearBill() {
		return allClearBill;
	}

	public void setAllClearBill(BigDecimal allClearBill) {
		this.allClearBill = allClearBill;
	}

	public String getPartClearNum() {
		return partClearNum;
	}

	public void setPartClearNum(String partClearNum) {
		this.partClearNum = partClearNum;
	}

	public BigDecimal getPartClearBill() {
		return partClearBill;
	}

	public void setPartClearBill(BigDecimal partClearBill) {
		this.partClearBill = partClearBill;
	}

	public String getNotClearNum() {
		return notClearNum;
	}

	public void setNotClearNum(String notClearNum) {
		this.notClearNum = notClearNum;
	}

	public BigDecimal getNotClearBill() {
		return notClearBill;
	}

	public void setNotClearBill(BigDecimal notClearBill) {
		this.notClearBill = notClearBill;
	}

}
