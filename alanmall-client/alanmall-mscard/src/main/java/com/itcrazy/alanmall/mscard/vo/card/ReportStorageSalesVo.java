package com.itcrazy.alanmall.mscard.vo.card;

public class ReportStorageSalesVo  {

	    // 卡号
		private String cardNo;

		// 母卡卡号
		private String motherCardNo;

		// 母子卡类别
		private String motherType;

		// 消费时间
		private String consumeTime;

		// 发卡门店
		private String releaseStore;

		// 消费门店
		private String store;

		// 操作类别：充值/撤销
		private String actionType;

		// 消费金额
		private String bill;

		// 卡类别名称
		private String categoryName;

		// 消费奖励金额
		private String reward;

		// 挂账消费金额
		private String creditBill;

		// 备注
		private String remarks;

		private String saleOrderId;

		public String getCreditBill() {
			return creditBill;
		}

		public void setCreditBill(String creditBill) {
			this.creditBill = creditBill;
		}

		public String getReward() {
			return reward;
		}

		public void setReward(String reward) {
			this.reward = reward;
		}

		public String getCardNo() {
			return cardNo;
		}

		public void setCardNo(String cardNo) {
			this.cardNo = cardNo;
		}

		public String getConsumeTime() {
			return consumeTime;
		}

		public void setConsumeTime(String consumeTime) {
			this.consumeTime = consumeTime;
		}

		public String getReleaseStore() {
			return releaseStore;
		}

		public void setReleaseStore(String releaseStore) {
			this.releaseStore = releaseStore;
		}

		public String getStore() {
			return store;
		}

		public void setStore(String store) {
			this.store = store;
		}

		public String getBill() {
			return bill;
		}

		public void setBill(String bill) {
			this.bill = bill;
		}

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		public String getSaleOrderId() {
			return saleOrderId;
		}

		public void setSaleOrderId(String saleOrderId) {
			this.saleOrderId = saleOrderId;
		}

		public String getActionType() {
			return actionType;
		}

		public void setActionType(String actionType) {
			this.actionType = actionType;
		}

		public String getMotherCardNo() {
			return motherCardNo;
		}

		public void setMotherCardNo(String motherCardNo) {
			this.motherCardNo = motherCardNo;
		}

		public String getMotherType() {
			return motherType;
		}

		public void setMotherType(String motherType) {
			this.motherType = motherType;
		}

}
