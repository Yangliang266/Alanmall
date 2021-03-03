package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 储值消费一览表（报表用）实体类
 * @author zhangli
 * 2018-10-08
 */
public class RptStorageSalesHistory extends CardBaseModel{
	// 卡号
	private String cardNo;

	// 卡类别
	private Integer category;

	// 消费时间
	private Date consumeTime;

	// 发卡门店
	private String releaseStore;

	// 消费门店
	private String store;

	// 消费金额
	private BigDecimal bill;

	// 卡类别名称
	private String categoryName;

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

	public String getReleaseStore() {
		return releaseStore;
	}

	public void setReleaseStore(String releaseStore) {
		this.releaseStore = releaseStore;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
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

}
