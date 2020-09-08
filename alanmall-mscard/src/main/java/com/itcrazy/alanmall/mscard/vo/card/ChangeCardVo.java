package com.itcrazy.alanmall.mscard.vo.card;

public class ChangeCardVo {
		// 卡号
		private String cardNo;

		// 卡类别
		private String name;

		// 卡状态
		private String status;

		// 姓名
		private String userName;

		// 性别
		private String sex;

		// 手机号码
		private String telephone;

		// 身份证号码
		private String idNumber;

		// 充值余额总和
		private String rechargeBalance;

		// 卡充值奖励总和
		private String reward;

		// 挂账
		private String credit;

		// 查询门店id
		private String store;

		// 当前门店id
		private String currentStore;

		// 挂账最高额度
		private String creditMaxQuota;

		// 卡类别
		private String category;


		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getCreditMaxQuota() {
			return creditMaxQuota;
		}

		public void setCreditMaxQuota(String creditMaxQuota) {
			this.creditMaxQuota = creditMaxQuota;
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

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
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

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
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

		public String getRechargeBalance() {
			return rechargeBalance;
		}

		public void setRechargeBalance(String rechargeBalance) {
			this.rechargeBalance = rechargeBalance;
		}

		public String getReward() {
			return reward;
		}

		public void setReward(String reward) {
			this.reward = reward;
		}

		public String getCredit() {
			return credit;
		}

		public void setCredit(String credit) {
			this.credit = credit;
		}


}
