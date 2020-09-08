package com.itcrazy.alanmall.mscard.vo.card;

/**
 * 门店入库页面展示类
 * @author yinxiang
 * 2018-09-05
 */

public class StoreWarehouseInVo {
	// 总部出库单号
	private String headOutReceiptNo;

	// 门店入库单号
	private String storeInReceiptNo;

	// 卡号
	private String cardNo;


	// 卡类别名称
	private String categoryName;

	// 卡状态
	private String status;

	// 总部出库时间
	private String headOutTime;

	// 总部出库操作人
	private String headOutPerson;

	// 门店入库时间
	private String storeInTime;

	// 门店入库操作人
	private String storeInPerson;

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

	public String getHeadOutTime() {
		return headOutTime;
	}

	public void setHeadOutTime(String headOutTime) {
		this.headOutTime = headOutTime;
	}

	public String getHeadOutPerson() {
		return headOutPerson;
	}

	public void setHeadOutPerson(String headOutPerson) {
		this.headOutPerson = headOutPerson;
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
}
