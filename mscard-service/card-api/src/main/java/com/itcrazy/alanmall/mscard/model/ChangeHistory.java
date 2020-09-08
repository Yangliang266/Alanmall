package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;

/**
 * 换卡/挂失/补卡记录实体类
 * @author zhangli
 * 2018-09-17
 */
public class ChangeHistory extends CardBaseModel{
	// 编号
	private Long id;

	// 旧卡号
	private String oldCardNo;

	// 新卡号
	private String newCardNo;

	// 换卡补卡区分
	private Integer type;

	// 充值余额总和
	private BigDecimal rechargeBalance;

	// 充值奖励余额总和
	private BigDecimal reward;

	// 挂账总额
	private BigDecimal credit;

	// 上传文件名
	private String fileName;

	// 卡类别名称
	private String categoryName;

	// 卡状态
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOldCardNo() {
		return oldCardNo;
	}

	public void setOldCardNo(String oldCardNo) {
		this.oldCardNo = oldCardNo;
	}

	public String getNewCardNo() {
		return newCardNo;
	}

	public void setNewCardNo(String newCardNo) {
		this.newCardNo = newCardNo;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public BigDecimal getRechargeBalance() {
		return rechargeBalance;
	}

	public void setRechargeBalance(BigDecimal rechargeBalance) {
		this.rechargeBalance = rechargeBalance;
	}

	public BigDecimal getReward() {
		return reward;
	}

	public void setReward(BigDecimal reward) {
		this.reward = reward;
	}

	public BigDecimal getCredit() {
		return credit;
	}

	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
