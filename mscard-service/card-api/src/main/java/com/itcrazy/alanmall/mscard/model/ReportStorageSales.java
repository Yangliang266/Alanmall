package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 储值消费一览表（报表用）实体类
 * @author zhangli
 * 2018-10-08
 */
public class ReportStorageSales extends CardBaseModel{
	private String saleOrderId;

	// 卡号
	private String cardNo;

	// 母卡号
	private String motherCardNo;

	// 母子卡类别
	private Integer motherType;

	// 卡类别
	private Integer category;

	// 消费时间
	private Date consumeTime;

	// 订单状态
	private int status;

	// 发卡门店
	private long releaseStore;

	// 消费门店
	private long store;

	// 消费金额
	private BigDecimal bill;

	// 卡类别名称
	private String categoryName;

	// 消费奖励金额
	private BigDecimal reward;

	// 挂账消费余额
	private BigDecimal creditBill;

	// 备注
	private String remarks;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public BigDecimal getCreditBill() {
		return creditBill;
	}

	public void setCreditBill(BigDecimal creditBill) {
		this.creditBill = creditBill;
	}

	public BigDecimal getReward() {
		return reward;
	}

	public void setReward(BigDecimal reward) {
		this.reward = reward;
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

	public Date getConsumeTime() {
		return consumeTime;
	}

	public void setConsumeTime(Date consumeTime) {
		this.consumeTime = consumeTime;
	}

	public long getReleaseStore() {
		return releaseStore;
	}

	public void setReleaseStore(long releaseStore) {
		this.releaseStore = releaseStore;
	}

	public long getStore() {
		return store;
	}

	public void setStore(long store) {
		this.store = store;
	}

	public BigDecimal getBill() {
		return bill;
	}

	public void setBill(BigDecimal bill) {
		this.bill = bill;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSaleOrderId() {
		return saleOrderId;
	}

	public void setSaleOrderId(String saleOrderId) {
		this.saleOrderId = saleOrderId;
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
}
