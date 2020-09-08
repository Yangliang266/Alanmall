package com.itcrazy.alanmall.mscard.model;

/**
 * 发卡中心-会员卡库存统计表
 *
 * @author yinxiang 2018-10-08
 */
public class ReportCenterInventory extends CardBaseModel {

	// 期初库存量合计
	private int openingInventoryTotal;

	// 门店
	private Long store;

	// 期初库存量
	private int openingInventory;

	// 售卡
	private int saleCard;

	// 调出
	private int cardOut;

	// 调入
	private int cardIn;

	// 当前结余
	private int currentBalance;

	// 卡类别
	private int category;

	// 卡类别名称
	private String categoryName;

	public Long getStore() {
		return store;
	}

	public void setStore(Long store) {
		this.store = store;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getOpeningInventory() {
		return openingInventory;
	}

	public void setOpeningInventory(int openingInventory) {
		this.openingInventory = openingInventory;
	}

	public int getSaleCard() {
		return saleCard;
	}

	public void setSaleCard(int saleCard) {
		this.saleCard = saleCard;
	}

	public int getCardOut() {
		return cardOut;
	}

	public void setCardOut(int cardOut) {
		this.cardOut = cardOut;
	}

	public int getCardIn() {
		return cardIn;
	}

	public void setCardIn(int cardIn) {
		this.cardIn = cardIn;
	}

	public int getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}

	public int getOpeningInventoryTotal() {
		return openingInventoryTotal;
	}

	public void setOpeningInventoryTotal(int openingInventoryTotal) {
		this.openingInventoryTotal = openingInventoryTotal;
	}
}
