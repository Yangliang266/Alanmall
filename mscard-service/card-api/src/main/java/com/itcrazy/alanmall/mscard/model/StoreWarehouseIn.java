package com.itcrazy.alanmall.mscard.model;

import java.util.Date;

/**
 * 门店入库实体类
 *
 * @author yinxiang 2018-09-04
 */
public class StoreWarehouseIn extends CardBaseModel {
	// 总部出库单号
	private String headOutReceiptNo;

	// 门店入库单号
	private String storeInReceiptNo;

	// 门店出库单号
	private String storeOutReceiptNo;

	// 卡号
	private String cardNo;

	// 原始门店
	private Long storeFrom;

	// 目的门店
	private Long storeTo;

	// 对应的出库单号
	private String warehouseOutNo;

	// 卡类别
	private int category;

	// 卡类别名称
	private String categoryName;

	// 卡状态
	private int status;

	// 总部出库时间
	private Date headOutTime;

	// 总部出库操作人
	private Long headOutPerson;

	// 门店入库时间
	private Date storeInTime;

	// 门店入库操作人
	private Long storeInPerson;

	// 发卡时间
	private Date publishTime;

	// 发卡人
	private Long publishId;

	public String getHeadOutReceiptNo() {
		return headOutReceiptNo;
	}

	public void setHeadOutReceiptNo(String headOutReceiptNo) {
		this.headOutReceiptNo = headOutReceiptNo;
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

	public Long getStoreFrom() {
		return storeFrom;
	}

	public void setStoreFrom(Long storeFrom) {
		this.storeFrom = storeFrom;
	}

	public Long getStoreTo() {
		return storeTo;
	}

	public void setStoreTo(Long storeTo) {
		this.storeTo = storeTo;
	}

	public String getWarehouseOutNo() {
		return warehouseOutNo;
	}

	public void setWarehouseOutNo(String warehouseOutNo) {
		this.warehouseOutNo = warehouseOutNo;
	}

	public String getStoreOutReceiptNo() {
		return storeOutReceiptNo;
	}

	public void setStoreOutReceiptNo(String storeOutReceiptNo) {
		this.storeOutReceiptNo = storeOutReceiptNo;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public Long getPublishId() {
		return publishId;
	}

	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}

}
