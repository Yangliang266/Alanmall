package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 储值消费一览对象
 * @author chenfei
 * 2018-10-10
 */
public class StorageSalesHistory extends CardBaseModel{
	// 订单号
	private String orderNo;
	// 卡号
	private String cardNo;
	// 母卡卡号
	private String motherCardNo;
	// 母子卡类别 1：亲情子卡，2：亲情母卡，3：挂账子卡，4：挂账母卡
	private Integer motherType;
	// 卡类别
	private Long category;
	// 消费时间
	private Date consumeTime;
	// 发卡门店
	private Long releaseStore;
	// 消费门店
	private Long store;
	// 本金消费金额
	private BigDecimal bill;
	// 奖励消费金额
	private BigDecimal reward;
	// 备注
	private String remarks;

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
	public Long getCategory() {
		return category;
	}
	public void setCategory(Long category) {
		this.category = category;
	}
	public Date getConsumeTime() {
		return consumeTime;
	}
	public void setConsumeTime(Date consumeTime) {
		this.consumeTime = consumeTime;
	}
	public Long getReleaseStore() {
		return releaseStore;
	}
	public void setReleaseStore(Long releaseStore) {
		this.releaseStore = releaseStore;
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
	public BigDecimal getReward() {
		return reward;
	}
	public void setReward(BigDecimal reward) {
		this.reward = reward;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
