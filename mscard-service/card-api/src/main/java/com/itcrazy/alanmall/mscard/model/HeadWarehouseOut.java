package com.itcrazy.alanmall.mscard.model;

import java.util.Date;

/**
 * 总部出库实体类
 *
 * @author luxf 2018-09-10
 */
public class HeadWarehouseOut extends CardBaseModel {
	// 卡号
	private String cardNo;

	// 出库单号
	private String receiptNo;

	// 出库门店
	private Long storeTo;

	// 总部入库时间
	private Date createTime;

	// 卡类别名称
	private String name;

	// 卡状态
	private int status;

	// 总部出库人
	private Long headOutPerson;

	// 总部出库时间
	private Date headOutTime;

	// 总部入库单号
	private String headInReceiptNo;

	//总部入库人
	private Long createId;

	public Long getCreateId() {
		return createId;
	}

	public void setCreateId(Long createId) {
		this.createId = createId;
	}

	public String getHeadInReceiptNo() {
		return headInReceiptNo;
	}

	public void setHeadInReceiptNo(String headInReceiptNo) {
		this.headInReceiptNo = headInReceiptNo;
	}

	public Date getHeadOutTime() {
		return headOutTime;
	}

	public void setHeadOutTime(Date headOutTime) {
		this.headOutTime = headOutTime;
	}

	public Long getHeadOutPerson() {
		return headOutPerson;
	}

	public void setHeadOutPerson(Long headOutPerson) {
		this.headOutPerson = headOutPerson;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public Long getStoreTo() {
		return storeTo;
	}

	public void setStoreTo(Long storeTo) {
		this.storeTo = storeTo;
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
