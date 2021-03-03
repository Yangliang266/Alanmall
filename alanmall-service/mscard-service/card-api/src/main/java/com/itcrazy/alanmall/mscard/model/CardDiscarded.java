package com.itcrazy.alanmall.mscard.model;

import java.util.Date;

/**
 * 作废实体类
 * @author yangliang
 * 2018-09-10
 */
public class CardDiscarded extends CardBaseModel{
	private static final long serialVersionUID = 3359862881744525787L;

	// 查询卡号
	private String cardNo;

	// 理由
	private String reason;

	// 卡类别
	private String name;

	// 卡状态
	private int status;

	// 作废单号
	private String receiptNo;


	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	// 添加人
	private String cardDiscardedPerson;

	// 添加时间
	private Date cardDiscardedTime;

	// 更新人
	private String cardDiscardedUpdatePerson;

	// 更新时间
	private String cardDiscardedUpdateTime;

	// 删除标记
	private int cardDiscardedIsDeleted;

	// 商家id
	private String cardDiscardedCompanyId;


	public String getCardDiscardedPerson() {
		return cardDiscardedPerson;
	}

	public void setCardDiscardedPerson(String cardDiscardedPerson) {
		this.cardDiscardedPerson = cardDiscardedPerson;
	}

	public Date getCardDiscardedTime() {
		return cardDiscardedTime;
	}

	public void setCardDiscardedTime(Date cardDiscardedTime) {
		this.cardDiscardedTime = cardDiscardedTime;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCardDiscardedUpdatePerson() {
		return cardDiscardedUpdatePerson;
	}

	public void setCardDiscardedUpdatePerson(String cardDiscardedUpdatePerson) {
		this.cardDiscardedUpdatePerson = cardDiscardedUpdatePerson;
	}

	public String getCardDiscardedUpdateTime() {
		return cardDiscardedUpdateTime;
	}

	public void setCardDiscardedUpdateTime(String cardDiscardedUpdateTime) {
		this.cardDiscardedUpdateTime = cardDiscardedUpdateTime;
	}

	public int getCardDiscardedIsDeleted() {
		return cardDiscardedIsDeleted;
	}

	public void setCardDiscardedIsDeleted(int cardDiscardedIsDeleted) {
		this.cardDiscardedIsDeleted = cardDiscardedIsDeleted;
	}

	public String getCardDiscardedCompanyId() {
		return cardDiscardedCompanyId;
	}

	public void setCardDiscardedCompanyId(String cardDiscardedCompanyId) {
		this.cardDiscardedCompanyId = cardDiscardedCompanyId;
	}



}
