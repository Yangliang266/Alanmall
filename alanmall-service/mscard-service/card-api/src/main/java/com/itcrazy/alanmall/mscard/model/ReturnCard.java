package com.itcrazy.alanmall.mscard.model;

import java.util.Date;

/**
 * 总部退货实体类
 * @author yangliang
 * 2018-09-04
 */
public class ReturnCard extends CardBaseModel{
	// 卡号
	private String cardNo;

	// 理由
	private String reason;

	// 卡类别 (card_category)
	private String name;

	// 卡状态(card_information)
	private int status;

	// 退货单号
	private String receiptNO;

	// 创建时间
	private Date returnCardTime;

	// 创建人
	private String returnCardPerson;

	// 更新时间
	private Date returnCardUpdateTime;

	// 更新人
	private String returnCardUpdatePerson;

	// 删除标记
	private int returnCardIsDeleted;

	// 商家id
	private String returnCardCompanyId;


	public int getReturnCardIsDeleted() {
		return returnCardIsDeleted;
	}

	public void setReturnCardIsDeleted(int returnCardIsDeleted) {
		this.returnCardIsDeleted = returnCardIsDeleted;
	}

	public String getReturnCardCompanyId() {
		return returnCardCompanyId;
	}

	public void setReturnCardCompanyId(String returnCardCompanyId) {
		this.returnCardCompanyId = returnCardCompanyId;
	}

	public Date getReturnCardTime() {
		return returnCardTime;
	}

	public void setReturnCardTime(Date returnCardTime) {
		this.returnCardTime = returnCardTime;
	}

	public String getReturnCardPerson() {
		return returnCardPerson;
	}

	public void setReturnCardPerson(String returnCardPerson) {
		this.returnCardPerson = returnCardPerson;
	}

	public Date getReturnCardUpdateTime() {
		return returnCardUpdateTime;
	}

	public void setReturnCardUpdateTime(Date returnCardUpdateTime) {
		this.returnCardUpdateTime = returnCardUpdateTime;
	}

	public String getReturnCardUpdatePerson() {
		return returnCardUpdatePerson;
	}

	public void setReturnCardUpdatePerson(String returnCardUpdatePerson) {
		this.returnCardUpdatePerson = returnCardUpdatePerson;
	}

	public String getReceiptNO() {
		return receiptNO;
	}

	public void setReceiptNO(String receiptNO) {
		this.receiptNO = receiptNO;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


}
