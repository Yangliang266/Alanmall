package com.itcrazy.alanmall.mscard.dto.Base;

import com.itcrazy.alanmall.common.framework.dto.BaseDto;

import java.math.BigDecimal;

public class BackCardDto extends BaseDto {
	// 卡号
	private String cardNo;

	// 商家id
	private Long companyId;

	// 创建id
	private Long createId;

	// 更新id
	private Long updateId;

	// 删除标志
	private int isDeleted;

	// 充值余额
	private BigDecimal rechargeBalance;

	// 退款支付方式
	private int backPay;

	// 退款原因
	private String backPaySeason;

	// 退款余额
	private BigDecimal returnPrice;

	// 充值奖励余额总和
	private BigDecimal reward;

	// 挂账总额
	private BigDecimal credit;

	// 文件名
	private String fileName;

	private int status;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public BigDecimal getReturnPrice() {
		return returnPrice;
	}

	public void setReturnPrice(BigDecimal returnPrice) {
		this.returnPrice = returnPrice;
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

	public Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	public Long getCreateId() {
		return createId;
	}

	public void setCreateId(Long createId) {
		this.createId = createId;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getBackPaySeason() {
		return backPaySeason;
	}

	public void setBackPaySeason(String backPaySeason) {
		this.backPaySeason = backPaySeason;
	}

	public int getBackPay() {
		return backPay;
	}

	public void setBackPay(int backPay) {
		this.backPay = backPay;
	}

	public BigDecimal getRechargeBalance() {
		return rechargeBalance;
	}

	public void setRechargeBalance(BigDecimal rechargeBalance) {
		this.rechargeBalance = rechargeBalance;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}


}
