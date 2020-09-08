package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 挂账一览表对象
 * @author chenfei
 * 2018-10-10
 */
public class CreditSalesHistory extends CardBaseModel{
	/** 订单号*/
	private String orderNo;

	/** 卡号*/
	private String cardNo;

	/** 母卡卡号*/
	private String motherCardNo;

	/** 母子卡类别 1：亲情子卡，2：亲情母卡，3：挂账子卡，4：挂账母卡*/
	private Integer motherType;

	/** 挂账时间*/
	private Date consumeTime;

	/** 挂账门店*/
	private Long store;

	/** 发卡门店*/
	private Long releaseStore;

	/** 挂账总金额*/
	private BigDecimal bill;

	/** 挂账金额*/
	private BigDecimal creditBill;

	/** 已清账金额*/
	private BigDecimal clearBill;

	/** 未清账金额*/
	private BigDecimal credit;

	/** 挂账状态*/
	private int status;

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

	public String getMotherCardNo() {
		return motherCardNo;
	}

	public void setMotherCardNo(String motherCardNo) {
		this.motherCardNo = motherCardNo;
	}

	public Integer getMotherType() {
		return motherType;
	}

	public void setMotherType(Integer motherType) {
		this.motherType = motherType;
	}

	public Date getConsumeTime() {
		return consumeTime;
	}

	public void setConsumeTime(Date consumeTime) {
		this.consumeTime = consumeTime;
	}

	public Long getStore() {
		return store;
	}

	public void setStore(Long store) {
		this.store = store;
	}

	public Long getReleaseStore() {
		return releaseStore;
	}

	public void setReleaseStore(Long releaseStore) {
		this.releaseStore = releaseStore;
	}

	public BigDecimal getBill() {
		return bill;
	}

	public void setBill(BigDecimal bill) {
		this.bill = bill;
	}

	public BigDecimal getCreditBill() {
		return creditBill;
	}

	public void setCreditBill(BigDecimal creditBill) {
		this.creditBill = creditBill;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


}
