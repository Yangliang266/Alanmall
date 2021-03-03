package com.itcrazy.alanmall.mscard.vo.card;

/**
 * 制卡管理页面展示类
 * @author huangchunbo
 * 2018-09-05
 */
public class CardInformationVo {

	    //卡号
		private String cardNo;

		//母卡卡号
		private String motherCardNo;

		//制卡批次号
		private String serialNo;

		//卡类别
		private String category;

		//状态
		private String status;

		//所属门店
		private String store;

		//挂账状态
		private String creditStatus;

		//挂账最高额度
		private String creditMaxQuota;

		//制卡人
		private Long  createId;

		// 制卡人名称
		private String createName;

		//制卡时间
		private String createTime;

		// 卡类别名称
		private String name;

		public String getCreateName() {
			return createName;
		}

		public void setCreateName(String createName) {
			this.createName = createName;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCardNo() {
			return cardNo;
		}

		public void setCardNo(String cardNo) {
			this.cardNo = cardNo;
		}

		public String getMotherCardNo() {
			return motherCardNo;
		}

		public void setMotherCardNo(String motherCardNo) {
			this.motherCardNo = motherCardNo;
		}

		public String getSerialNo() {
			return serialNo;
		}

		public void setSerialNo(String serialNo) {
			this.serialNo = serialNo;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category =category;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getStore() {
			return store;
		}

		public void setStore(String store) {
			this.store = store;
		}

		public String getCreditStatus() {
			return creditStatus;
		}

		public void setCreditStatus(String creditStatus) {
			this.creditStatus = creditStatus;
		}

		public String getCreditMaxQuota() {
			return creditMaxQuota;
		}

		public void setCreditMaxQuota(String creditMaxQuota) {
			this.creditMaxQuota = creditMaxQuota;
		}

		public Long getCreateId() {
			return createId;
		}

		public void setCreateId(Long createId) {
			this.createId = createId;
		}

		public String getCreateTime() {
			return createTime;
		}

		public void setCreateTime(String createTime) {
			this.createTime = createTime;
		}



}
