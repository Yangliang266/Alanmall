package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;

/**
 * 卡折扣实体类
 * @author chenfei
 * 2018-10-08
 */
public class Discount extends CardBaseModel{
	// id
	private Long id;

	// 卡类别id
	private Long cardCategotyId;

	// 折扣类型 0: 品牌、 1: 门店
	private Integer type;

	// 品牌门店代号
	private String code;

	// 消费折扣率
	private BigDecimal discount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCardCategotyId() {
		return cardCategotyId;
	}

	public void setCardCategotyId(Long cardCategotyId) {
		this.cardCategotyId = cardCategotyId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
}
