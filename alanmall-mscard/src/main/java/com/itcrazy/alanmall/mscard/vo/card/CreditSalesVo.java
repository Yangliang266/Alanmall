package com.itcrazy.alanmall.mscard.vo.card;

import java.math.BigDecimal;

/**
 * 挂账页面展示类
 * @author zhangzhongtian
 * 2018-10-09
 */
public class CreditSalesVo {

		//挂账订单号
		private String creditSalesId;

		//卡号
		private String cardNo;

		//挂账时间
		private String consumeTime;

		//挂账门店
		private String store;

		//挂账金额
		private BigDecimal creditBill;

		//已清账金额
		private BigDecimal clearBill;

		//未清账金额
		private BigDecimal credit;

		//挂账状态
		private String status;

		public String getCreditSalesId() {
			return creditSalesId;
		}

		public void setCreditSalesId(String creditSalesId) {
			this.creditSalesId = creditSalesId;
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

		public String getStore() {
			return store;
		}

		public void setStore(String store) {
			this.store = store;
		}

		public BigDecimal getCreditBill() {
			return creditBill;
		}

		public void setCreditBill(BigDecimal creditBill) {
			this.creditBill = creditBill;
		}

		public BigDecimal getClearBill() {
			return clearBill;
		}

		public void setClearBill(BigDecimal clearBill) {
			this.clearBill = clearBill;
		}

		public BigDecimal getCredit() {
			return credit;
		}

		public void setCredit(BigDecimal credit) {
			this.credit = credit;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

}
