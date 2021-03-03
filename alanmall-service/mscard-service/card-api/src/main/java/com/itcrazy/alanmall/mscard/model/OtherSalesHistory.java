package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 其他消费一览表对象
 * @author chenfei
 * 2018-10-24
 */
public class OtherSalesHistory extends CardBaseModel{
	/** 订单号*/
	private String orderNo;

	/** 卡号*/
	private String cardNo;

	/** 卡类别*/
	private Long category;

	/** 消费时间*/
	private Date consumeTime;

	/** 消费门店*/
	private Long store;

	/** 消费金额*/
	private BigDecimal bill;

	/** 支付方式*/
	private Integer payMode;

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

	public BigDecimal getBill() {
		return bill;
	}

	public void setBill(BigDecimal bill) {
		this.bill = bill;
	}

	public Integer getPayMode() {
		return payMode;
	}

	public void setPayMode(Integer payMode) {
		this.payMode = payMode;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

}
