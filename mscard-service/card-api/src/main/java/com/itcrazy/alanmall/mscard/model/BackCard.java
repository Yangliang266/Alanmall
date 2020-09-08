package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;

/**
 * 退卡实体类
 * @author yangliang
 * 2018-09-25
 */
public class BackCard extends CardBaseModel{
		// 卡号
		private String cardNo;

		// 卡类别
		private String name;

		// 卡状态
		private int status;

		// 姓名
		private String userName;

		// 性别
		private int sex;

		// 手机号码
		private String telephone;

		// 身份证号码
		private String idNumber;

		// 充值余额总和
		private BigDecimal rechargeBalance;

		// 卡充值奖励总和
		private BigDecimal reward;

		// 挂账总额
		private BigDecimal credit;

		// 门店id
		private String store;

		// 当前门店id
		private String currentStore;

		// 卡类别id
		private int category;

		// 挂账状态
		private int creditStatus;

		// 母卡卡号
		private String motherCardNo;

		// 挂账最高额度
		private String creditMaxQuota;

		// 是否记名
		private int isNamed;

		// 支付方式
		private int payMode;

		// 退还金额
		private BigDecimal returnPrice;

		// 退还原因
		private String reason;

		// 文件名
		private String fileName;

		// 支付方式编号
		private int payModeId;

		// 支付方式
		private String payModeName;

		public int getPayModeId() {
			return payModeId;
		}

		public void setPayModeId(int payModeId) {
			this.payModeId = payModeId;
		}

		public String getPayModeName() {
			return payModeName;
		}

		public void setPayModeName(String payModeName) {
			this.payModeName = payModeName;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public int getPayMode() {
			return payMode;
		}

		public void setPayMode(int payMode) {
			this.payMode = payMode;
		}

		public BigDecimal getReturnPrice() {
			return returnPrice;
		}

		public void setReturnPrice(BigDecimal returnPrice) {
			this.returnPrice = returnPrice;
		}

		public String getReason() {
			return reason;
		}

		public void setReason(String reason) {
			this.reason = reason;
		}

		public int getIsNamed() {
			return isNamed;
		}

		public void setIsNamed(int isNamed) {
			this.isNamed = isNamed;
		}

		public String getStore() {
			return store;
		}

		public void setStore(String store) {
			this.store = store;
		}

		public String getCurrentStore() {
			return currentStore;
		}

		public void setCurrentStore(String currentStore) {
			this.currentStore = currentStore;
		}

		public int getCreditStatus() {
			return creditStatus;
		}

		public void setCreditStatus(int creditStatus) {
			this.creditStatus = creditStatus;
		}

		public String getMotherCardNo() {
			return motherCardNo;
		}

		public void setMotherCardNo(String motherCardNo) {
			this.motherCardNo = motherCardNo;
		}

		public String getCreditMaxQuota() {
			return creditMaxQuota;
		}

		public void setCreditMaxQuota(String creditMaxQuota) {
			this.creditMaxQuota = creditMaxQuota;
		}

		public int getCategory() {
			return category;
		}

		public void setCategory(int category) {
			this.category = category;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
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

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public int getSex() {
			return sex;
		}

		public void setSex(int sex) {
			this.sex = sex;
		}

		public String getTelephone() {
			return telephone;
		}

		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}

		public String getIdNumber() {
			return idNumber;
		}

		public void setIdNumber(String idNumber) {
			this.idNumber = idNumber;
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

}
