package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;

/**
 * 挂账设定表实体类
 * @author zhangli
 * 2018-09-21
 */
public class CreditSetting extends CardBaseModel{
	// 编号
	private Long id;

	// 卡号
	private String cardNo;

	// 挂账额度类型
	private Integer type;

	// 品牌门店代号
	private String code;

	// 挂账额度
	private BigDecimal creditQuota;

	// 母卡卡号
	private String motherCardNo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
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

	public BigDecimal getCreditQuota() {
		return creditQuota;
	}

	public void setCreditQuota(BigDecimal creditQuota) {
		this.creditQuota = creditQuota;
	}

	public String getMotherCardNo() {
		return motherCardNo;
	}

	public void setMotherCardNo(String motherCardNo) {
		this.motherCardNo = motherCardNo;
	}

}
