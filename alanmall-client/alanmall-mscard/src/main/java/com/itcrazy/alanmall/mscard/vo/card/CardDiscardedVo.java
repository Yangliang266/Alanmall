package com.itcrazy.alanmall.mscard.vo.card;

public class CardDiscardedVo {
		// 查询卡号
		private String cardNo;

		// 理由
		private String reason;

		// 卡类别
		private String name;

		// 卡状态
		private String status;

		// 作废人
		private String createId;

		// 作废时间
		private String createTime;

		// 作废单号
		private String receiptNo;

		public String getReceiptNo() {
			return receiptNo;
		}

		public void setReceiptNo(String receiptNo) {
			this.receiptNo = receiptNo;
		}

		public String getCardNo() {
			return cardNo;
		}

		public void setCardNo(String cardNo) {
			this.cardNo = cardNo;
		}

		public String getReason() {
			return reason;
		}

		public void setReason(String reason) {
			this.reason = reason;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getCreateId() {
			return createId;
		}

		public void setCreateId(String createId) {
			this.createId = createId;
		}

		public String getCreateTime() {
			return createTime;
		}

		public void setCreateTime(String createTime) {
			this.createTime = createTime;
		}

}
