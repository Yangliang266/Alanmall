package com.itcrazy.alanmall.mscard.model;

import java.math.BigDecimal;

/**
 * 用户退卡实体类
 * @author yangliang
 * 2018-09-26
 */
public class CustomReturnHistory extends CardBaseModel{
		// 卡号
		private String cardNo;

		// 充值余额总和
		private BigDecimal rechargeBalance;

		// 充值奖励总和
		private BigDecimal reward;

		// 挂账总额
		private BigDecimal credit;

		// 支付方式
		private int payMode;

		// 文件名
		private String fileName;

		// 退还金额
		private BigDecimal returnPrice;

		// 退还原因
		private String reason;

		// 商家id
		private Long companyId;

		// 创建id
		private Long createId;

		// 更新id
		private Long updateId;

		// 删除标志
		private int isDeleted;

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

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

		public BigDecimal getCredit() {
			return credit;
		}

		public void setCredit(BigDecimal credit) {
			this.credit = credit;
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

		public Long getCompanyId() {
			return companyId;
		}

		public void setCompanyId(Long companyId) {
			this.companyId = companyId;
		}

		public Long getCreateId() {
			return createId;
		}

		public void setCreateId(Long createId) {
			this.createId = createId;
		}

		public Long getUpdateId() {
			return updateId;
		}

		public void setUpdateId(Long updateId) {
			this.updateId = updateId;
		}

		public int getIsDeleted() {
			return isDeleted;
		}

		public void setIsDeleted(int isDeleted) {
			this.isDeleted = isDeleted;
		}



}
