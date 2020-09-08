package com.itcrazy.alanmall.mscard.vo.card;

public class StoreWarehouseOutVo {

	// 业务单类型
	private String business;

	// 业务单状态
	private Integer businessType;

	// 业务单状态
	private String businessTypeStr;

	// 出库单号
	private String receiptNo;

	// 调拨理由
	private String reason;

	// 门店入库单号
	private String storeInReceiptNo;

	// 卡号
	private String cardNo;

	// 原始门店
	private Long storeFrom;

	// 原始门店
	private String storeFromStr;

	// 目的门店
	private String storeTo;

	// 卡类别
	private String category;

	// 卡类别名称
	private String categoryName;

	// 卡状态
	private String status;

	// 总部出库操作人
	private String storeOutPerson;

	// 门店出库时间
	private String storeOutTime;

	// 门店入库时间
	private String storeInTime;

	// 门店入库操作人
	private String storeInPerson;

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

	public String getStoreFromStr() {
		return storeFromStr;
	}

	public void setStoreFromStr(String storeFromStr) {
		this.storeFromStr = storeFromStr;
	}

	public void setStoreFrom(Long storeFrom) {
		this.storeFrom = storeFrom;
	}

	public Long getStoreFrom() {
		return storeFrom;
	}

	public String getStoreTo() {
		return storeTo;
	}

	public void setStoreTo(String storeTo) {
		this.storeTo = storeTo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStoreOutPerson() {
		return storeOutPerson;
	}

	public void setStoreOutPerson(String storeOutPerson) {
		this.storeOutPerson = storeOutPerson;
	}

	public String getStoreOutTime() {
		return storeOutTime;
	}

	public void setStoreOutTime(String storeOutTime) {
		this.storeOutTime = storeOutTime;
	}

	public String getStoreInTime() {
		return storeInTime;
	}

	public void setStoreInTime(String storeInTime) {
		this.storeInTime = storeInTime;
	}

	public String getStoreInPerson() {
		return storeInPerson;
	}

	public void setStoreInPerson(String storeInPerson) {
		this.storeInPerson = storeInPerson;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public Integer getBusinessType() {
		return businessType;
	}

	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
	}

	public String getBusinessTypeStr() {
		return businessTypeStr;
	}

	public void setBusinessTypeStr(String businessTypeStr) {
		this.businessTypeStr = businessTypeStr;
	}

}
