package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;

/**
 * 消费接口的返回对象
 * @author chenfei
 * 2018-10-25
 */
public class ExternalAPIConsumeResult extends CardBaseModel{
	// 返回码
	private Integer returnCode;

	// 卡号
	private String cardNo;

	// 储值余额
	private BigDecimal rechargeBalance;

	// 充值奖励余额
	private BigDecimal reward;

	// 可挂账金额
	//	  a,本卡挂账最高额度 - 本卡挂账总额
	//    b,母卡挂账最高额度 - 母卡的所有子卡的挂账总额之和
	//    结论：不是母卡，也不是子卡，则a；
	//        是母卡或子卡，则a和b的较小值）
	private BigDecimal allowableCredit;

	// 本次扣款总额
	private BigDecimal deductedAmount;

	// 本次消费扣除的本金
	private BigDecimal deductedRecharge;

	// 本次消费扣除的奖励金额
	private BigDecimal deductedReward;

	// 本次消费扣除的挂账金额
	private BigDecimal deductedCredit;

	// 本次消费扣除的其他金额
	private BigDecimal deductedOther;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
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

	public BigDecimal getAllowableCredit() {
		return allowableCredit;
	}

	public void setAllowableCredit(BigDecimal allowableCredit) {
		this.allowableCredit = allowableCredit;
	}

	public BigDecimal getDeductedRecharge() {
		return deductedRecharge;
	}

	public void setDeductedRecharge(BigDecimal deductedRecharge) {
		this.deductedRecharge = deductedRecharge;
	}

	public BigDecimal getDeductedReward() {
		return deductedReward;
	}

	public void setDeductedReward(BigDecimal deductedReward) {
		this.deductedReward = deductedReward;
	}

	public BigDecimal getDeductedCredit() {
		return deductedCredit;
	}

	public void setDeductedCredit(BigDecimal deductedCredit) {
		this.deductedCredit = deductedCredit;
	}

	public BigDecimal getDeductedOther() {
		return deductedOther;
	}

	public void setDeductedOther(BigDecimal deductedOther) {
		this.deductedOther = deductedOther;
	}

	public Integer getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(Integer returnCode) {
		this.returnCode = returnCode;
	}

	public BigDecimal getDeductedAmount() {
		return deductedAmount;
	}

	public void setDeductedAmount(BigDecimal deductedAmount) {
		this.deductedAmount = deductedAmount;
	}

}
