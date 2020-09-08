package com.itcrazy.alanmall.common.client.alipay.model;


import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;

import java.util.Date;

public class CardExtInfo extends BaseModelAdapter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6274473693570324553L;

	private String bizCardNo;
	private String externalCardNo;
	private Date openDate;
	private Date validDate;
	private String level;
	private String point;
	private String balance;
	private String templateId;
	private String frontImageId;

	public String getBizCardNo() {
		return bizCardNo;
	}

	public void setBizCardNo(String bizCardNo) {
		this.bizCardNo = bizCardNo;
	}

	public String getExternalCardNo() {
		return externalCardNo;
	}

	public void setExternalCardNo(String externalCardNo) {
		this.externalCardNo = externalCardNo;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getFrontImageId() {
		return frontImageId;
	}

	public void setFrontImageId(String frontImageId) {
		this.frontImageId = frontImageId;
	}

}
