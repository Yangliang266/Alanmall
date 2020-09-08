package com.itcrazy.alanmall.mscard.vo.card;

public class ReportCenterInventoryVo {

	// 门店
	private String store;

	// 卡类别
	private String category;

	// 卡类别名称
	private String categoryName;

	// 期初库存量（张）
	private int openingInventory;

	// 售卡（张）
	private int saleCard;

	// 调出（张）
	private int cardOut;

	// 调入（张）
	private int cardIn;

	// 当前结余
	private int currentBalance;

	public int getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
