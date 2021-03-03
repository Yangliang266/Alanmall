package com.itcrazy.alanmall.mscard.vo.card;

/**
 * 总部出库页面展示类
 *
 * @author luxf 2018-09-10
 */
public class HeadWarehouseOutVo {

	// 总部入库单号
	private String headInReceiptNo;

	// 总部出库单号
	private String receiptNo;

	// 卡号
	private String cardNo;

	// 卡类别
	private String name;

	// 卡状态
	private String status;

	// 总部入库时间
	private String createTime;

	// 创建人
	private String createPerson;

	// 总部出库时间
	private String headOutTime;

	// 总部出库人
	private String headOutPerson;

	// 总部入库人名称
	private String createId;

	// 出库门店
	private String storeTo;

	public String getStoreTo() {
		return storeTo;
	}

	public void setStoreTo(String storeTo) {
		this.storeTo = storeTo;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public String getHeadInReceiptNo() {
		return headInReceiptNo;
	}

	public void setHeadInReceiptNo(String headInReceiptNo) {
		this.headInReceiptNo = headInReceiptNo;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
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

}
