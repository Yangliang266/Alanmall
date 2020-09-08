package com.itcrazy.alanmall.mscard.vo.card;

/**
 *  挂账／清账报表展示类
 * @author luxf
 * 2018-10-11
 */
public class ReportCreditAccountVo {

    // 卡号
	private String cardNo;

	// 客户名称
	private String userName;

	// 状态
	private String status;

	// 卡类型
	private String name;

	// 总挂账笔数
	private String creditNum;

	// 总挂账金额
	private String creditBill;

	// 全清账笔数
	private String allClearNum;

	// 全清账金额
	private String allClearBill;

	// 部分清账笔数
	private String partClearNum;

	// 部分清账金额
	private String partClearBill;

	// 未清账笔数（包括全清、部分清账）
	private String notClearNum;

	// 未清账金额（包括全清、部分清账）
	private String notClearBill;

	// 账单编号
	private String idCard;

	// 消费时间
	private String consumeTime;

	// 账单总金额
	private String bill;

	// 挂帐金额
	private String creditCardBill;

	// 已清账金额
	private String clearBill;

	// 未清账金额
	private String credit;

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getConsumeTime() {
		return consumeTime;
	}

	public void setConsumeTime(String consumeTime) {
		this.consumeTime = consumeTime;
	}

	public String getBill() {
		return bill;
	}

	public void setBill(String bill) {
		this.bill = bill;
	}

	public String getCreditCardBill() {
		return creditCardBill;
	}

	public void setCreditCardBill(String creditCardBill) {
		this.creditCardBill = creditCardBill;
	}

	public String getClearBill() {
		return clearBill;
	}

	public void setClearBill(String clearBill) {
		this.clearBill = clearBill;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreditNum() {
		return creditNum;
	}

	public void setCreditNum(String creditNum) {
		this.creditNum = creditNum;
	}

	public String getCreditBill() {
		return creditBill;
	}

	public void setCreditBill(String creditBill) {
		this.creditBill = creditBill;
	}

	public String getAllClearNum() {
		return allClearNum;
	}

	public void setAllClearNum(String allClearNum) {
		this.allClearNum = allClearNum;
	}

	public String getAllClearBill() {
		return allClearBill;
	}

	public void setAllClearBill(String allClearBill) {
		this.allClearBill = allClearBill;
	}

	public String getPartClearNum() {
		return partClearNum;
	}

	public void setPartClearNum(String partClearNum) {
		this.partClearNum = partClearNum;
	}

	public String getPartClearBill() {
		return partClearBill;
	}

	public void setPartClearBill(String partClearBill) {
		this.partClearBill = partClearBill;
	}

	public String getNotClearNum() {
		return notClearNum;
	}

	public void setNotClearNum(String notClearNum) {
		this.notClearNum = notClearNum;
	}

	public String getNotClearBill() {
		return notClearBill;
	}

	public void setNotClearBill(String notClearBill) {
		this.notClearBill = notClearBill;
	}

}