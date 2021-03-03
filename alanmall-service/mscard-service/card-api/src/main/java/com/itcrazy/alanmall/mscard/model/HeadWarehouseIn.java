package com.itcrazy.alanmall.mscard.model;

import java.util.Date;

/**
 * 总部入库实体类
 *
 * @author luxf 2018-09-04
 */
public class HeadWarehouseIn extends CardBaseModel {
	// 卡号
	private String cardNo;

	// 入库单号
	private String receiptNo;

	// 总部入库人
	private Long headinPerson;

	// 总部入库时间
	private Date headinTime;

	// 制卡批次号
	private String serialNo;

	// 状态
	private int status;

	// 制卡人
	private Long createId;

	// 卡类别名称
	private String name;


	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public Long getHeadinPerson() {
		return headinPerson;
	}

	public void setHeadinPerson(Long headinPerson) {
		this.headinPerson = headinPerson;
	}

	public Date getHeadinTime() {
		return headinTime;
	}

	public void setHeadinTime(Date headinTime) {
		this.headinTime = headinTime;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCreateId() {
		return createId;
	}

	public void setCreateId(Long createId) {
		this.createId = createId;
	}



}
