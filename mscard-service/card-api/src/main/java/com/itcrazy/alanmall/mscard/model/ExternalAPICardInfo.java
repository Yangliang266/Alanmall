package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;

/**
 * 对外接口 卡查询的卡信息类
 * @author chenfei
 * 2018-10-12
 */
public class ExternalAPICardInfo extends CardBaseModel{
	// 卡号
	private String cardNo;

	// 发卡门店id
	private Long relaseStoreId;

	// 卡当前状态 int
	private Integer status;

	// 卡状态
	private String strCardStatus;

	// 卡类别id
	private Long categoryId;

	// 卡类别
	private String strCategory;

	// 当前门店是否可消费
	private boolean currentStoreCanConsume;

	// 当前门店消费折扣率
	private BigDecimal currentStoreDiscount;

	// 是否可挂账
	private boolean canCredit;

	// 姓名
	private String userName;

	// 手机号
	private String telephone;

	// 储值余额
	private BigDecimal rechargeBalance;

	// 充值奖励余额
	private BigDecimal reward;

	// 挂账状态 int
	private Integer creditStatus;

	// 本卡最高挂账额度
	private BigDecimal creditMaxQuota;

	// 本卡挂账总额
	private BigDecimal totalCredit;

	/**
	 * <h2>剩余挂账额度</h2>
	 * <ul>
	 * 		<li>a_0:本卡在所有门店的剩余可挂账金额 = a_1 和 a_2 取小值</li>
	 * 		<li>a_1:本卡在所有门店的剩余可挂账金额 = 本卡在所有门店的可挂账总额度 - 本卡在所有门店的已挂账金额</li>
	 * 		<li>a_2:本卡所在家族在所有门店的剩余可挂账金额  = 本卡所在家族在所有门店的可挂账总额度（母卡总额度） - 本卡所在家族在所有门店的已挂账金额</li>
	 * 		<li>b_0:本卡在本门店的剩余可挂账金额 = b_1 和 b_2 取小值</li>
	 * 		<li>b_1:本卡在本门店的剩余可挂账金额 = 本卡在本门店的可挂账总额度 - 本卡在本门店的已挂账金额</li>
	 * 		<li>b_2:本卡所在家族在本门店的剩余可挂账金额  = 本卡所在家族在本门店的可挂账总额度（母卡总额度） - 本卡所在家族在本门店的已挂账金额</li>
	 * </ul>
	 *
	 * @return 结论：本卡在本门店的剩余可挂账金额 = a_0 和 b_0  取小值
	 */
	private BigDecimal allowableCredit;

	// 是否需要支付密码
	private boolean needPayPwd;

	// 结算操作人
	private String operatorName;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Long getRelaseStoreId() {
		return relaseStoreId;
	}

	public void setRelaseStoreId(Long relaseStoreId) {
		this.relaseStoreId = relaseStoreId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getStrCategory() {
		return strCategory;
	}

	public void setStrCategory(String strCategory) {
		this.strCategory = strCategory;
	}

	public boolean isCurrentStoreCanConsume() {
		return currentStoreCanConsume;
	}

	public void setCurrentStoreCanConsume(boolean currentStoreCanConsume) {
		this.currentStoreCanConsume = currentStoreCanConsume;
	}

	public BigDecimal getCurrentStoreDiscount() {
		return currentStoreDiscount;
	}

	public void setCurrentStoreDiscount(BigDecimal currentStoreDiscount) {
		this.currentStoreDiscount = currentStoreDiscount;
	}

	public boolean isCanCredit() {
		return canCredit;
	}

	public void setCanCredit(boolean canCredit) {
		this.canCredit = canCredit;
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

	public Integer getCreditStatus() {
		return creditStatus;
	}

	public void setCreditStatus(Integer creditStatus) {
		this.creditStatus = creditStatus;
	}

	public BigDecimal getCreditMaxQuota() {
		return creditMaxQuota;
	}

	public void setCreditMaxQuota(BigDecimal creditMaxQuota) {
		this.creditMaxQuota = creditMaxQuota;
	}

	public BigDecimal getTotalCredit() {
		return totalCredit;
	}

	public void setTotalCredit(BigDecimal totalCredit) {
		this.totalCredit = totalCredit;
	}

	public BigDecimal getAllowableCredit() {
		return allowableCredit;
	}

	public void setAllowableCredit(BigDecimal allowableCredit) {
		this.allowableCredit = allowableCredit;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public boolean isNeedPayPwd() {
		return needPayPwd;
	}

	public void setNeedPayPwd(boolean needPayPwd) {
		this.needPayPwd = needPayPwd;
	}

	public String getStrCardStatus() {
		return strCardStatus;
	}

	public void setStrCardStatus(String strCardStatus) {
		this.strCardStatus = strCardStatus;
	}

}
