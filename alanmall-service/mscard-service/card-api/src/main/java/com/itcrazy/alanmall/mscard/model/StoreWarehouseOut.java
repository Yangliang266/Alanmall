package com.itcrazy.alanmall.mscard.model;

import java.util.Date;

/**
 * 门店调拨实体类
 *
 * @author yinxiang 2018-09-04
 */
public class StoreWarehouseOut extends CardBaseModel {
	// 出库单号
	private String receiptNo;

	// 业务单类型
	private Integer business;

	// 业务单状态
	private Integer businessType;

	// 调拨理由
	private String reason;

	// 门店入库单号
	private String storeInReceiptNo;

	// 卡号
	private String cardNo;

	// 原始门店
	private long storeFrom;
    public Long getStoreFrom() {		return storeFrom;
	}

	public void setStoreFrom(Long storeFrom) {		this.storeFrom = storeFrom;
	}

	// 目的门店
	private Long storeTo;

	// 卡类别
	private int category;

	// 卡类别名称
	private String categoryName;

	// 卡状态
	private int status;

	// 总部出库操作人
	private long storeOutPerson;

	// 门店出库时间
	private Date storeOutTime;

	// 门店入库时间
	private Date storeInTime;

	// 门店入库操作人
	private Long storeInPerson;

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStoreInReceiptNo() {
		return storeInReceiptNo;
	}

	public void setStoreInReceiptNo(String storeInReceiptNo) {
		this.storeInReceiptNo = storeInReceiptNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Long getStoreTo() {
		return storeTo;
	}

	public void setStoreTo(Long storeTo) {
		this.storeTo = storeTo;
	}

	public long getStoreOutPerson() {
		return storeOutPerson;
	}

	public void setStoreOutPerson(long storeOutPerson) {
		this.storeOutPerson = storeOutPerson;
	}

	public Date getStoreOutTime() {
		return storeOutTime;
	}

	public void setStoreOutTime(Date storeOutTime) {
		this.storeOutTime = storeOutTime;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getStoreInTime() {
		return storeInTime;
	}

	public void setStoreInTime(Date storeInTime) {
		this.storeInTime = storeInTime;
	}

	public Long getStoreInPerson() {
		return storeInPerson;
	}

	public void setStoreInPerson(Long storeInPerson) {
		this.storeInPerson = storeInPerson;
	}

	public Integer getBusiness() {
		return business;
	}

	public void setBusiness(Integer business) {
		this.business = business;
	}

	public Integer getBusinessType() {
		return businessType;
	}

	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
	}

	public void setStoreFrom(long storeFrom) {
		this.storeFrom = storeFrom;
	}

}
