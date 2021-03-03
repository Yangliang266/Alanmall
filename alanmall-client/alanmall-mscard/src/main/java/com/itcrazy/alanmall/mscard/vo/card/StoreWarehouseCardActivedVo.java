package com.itcrazy.alanmall.mscard.vo.card;

/**
 * 门店卡激活页面展示类
 * @author huangchunbo
 * 2018-09-17
 */
public class StoreWarehouseCardActivedVo {

	    // 卡号
		private String cardNo;

		// 卡类别
		private Integer category;

		// 状态
		private String status;

		// 门店入库时间
		private String storeInTime;

		// 门店入库操作人
		private String storeInPerson;

		// 卡类别名称
		private String name;

		// 门店入库单号
		private String receiptNo;

		// 是否记名卡
		private int isNamed;

		// 是否记名卡名称
		private String isNamedName;

		// 卡支付密码是否必填
		private  int isPswMust;

		// 卡支付密码是否必填名称
		private  String isPswMustName;

		public int getIsNamed() {
			return isNamed;
		}

		public void setIsNamed(int isNamed) {
			this.isNamed = isNamed;
		}

		public String getReceiptNo() {
			return receiptNo;
		}

		public void setReceiptNo(String receiptNo) {
			this.receiptNo = receiptNo;
		}

		public String getStoreInTime() {
			return storeInTime;
		}

		public void setStoreInTime(String storeInTime) {
			this.storeInTime = storeInTime;
		}

		public String getStoreInPerson() {
			return storeInPerson;
		}

		public void setStoreInPerson(String storeInPerson) {
			this.storeInPerson = storeInPerson;
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

		public Integer getCategory() {
			return category;
		}

		public void setCategory(Integer category) {
			this.category =category;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getIsNamedName() {
			return isNamedName;
		}

		public void setIsNamedName(String isNamedName) {
			this.isNamedName = isNamedName;
		}

		public String getIsPswMustName() {
			return isPswMustName;
		}

		public void setIsPswMustName(String isPswMustName) {
			this.isPswMustName = isPswMustName;
		}

		public int getIsPswMust() {
			return isPswMust;
		}

		public void setIsPswMust(int isPswMust) {
			this.isPswMust = isPswMust;
		}

}
