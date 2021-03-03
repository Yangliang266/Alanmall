package com.itcrazy.alanmall.mscard.vo.card;

/**
 * 总部入库页面展示类
 *
 * @author luxf 2018-09-05
 */
public class HeadWarehouseInVo {

	// 制卡批次号
	private String serialNo;

	// 卡号
	private String cardNo;

	// 卡类别
	private String name;

	// 状态
	private String status;

	// 制卡时间
	private String createTime;

	// 制卡人ID
	private Long createId;

	// 制卡人名称
	private String createName;

	// 入库单号
	private String receiptNo;

	// 总部入库时间
	private String headInTime;

	// 总部入库操作人ID
	private Long headInPerson;

	// 总部入库操作人
	private String headInPersonName;

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
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

	public Long getCreateId() {
		return createId;
	}

	public void setCreateId(Long string) {
		this.createId = string;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getHeadInTime() {
		return headInTime;
	}

	public void setHeadInTime(String headInTime) {
		this.headInTime = headInTime;
	}

	public Long getHeadInPerson() {
		return headInPerson;
	}

	public void setHeadInPerson(Long headInPerson) {
		this.headInPerson = headInPerson;
	}

	public String getHeadInPersonName() {
		return headInPersonName;
	}

	public void setHeadInPersonName(String headInPersonName) {
		this.headInPersonName = headInPersonName;
	}
}
