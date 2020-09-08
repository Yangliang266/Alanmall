package com.itcrazy.alanmall.mscard.action.co;

import java.math.BigDecimal;

public class DishPriceCo {

	private Long dishSpecId;
	private Long dishOrderSourceId;
	private Integer specNum;
	private BigDecimal price;
	private Integer score; //积分
	private Integer showType;  //1:在线商城显示，2：积分商城显示
	private Integer discountRate;
	public Long getDishSpecId() {
		return dishSpecId;
	}
	public void setDishSpecId(Long dishSpecId) {
		this.dishSpecId = dishSpecId;
	}
	public Long getDishOrderSourceId() {
		return dishOrderSourceId;
	}
	public void setDishOrderSourceId(Long dishOrderSourceId) {
		this.dishOrderSourceId = dishOrderSourceId;
	}
	public Integer getSpecNum() {
		return specNum;
	}
	public void setSpecNum(Integer specNum) {
		this.specNum = specNum;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(Integer discountRate) {
		this.discountRate = discountRate;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getShowType() {
		return showType;
	}
	public void setShowType(Integer showType) {
		this.showType = showType;
	}
	
	
	
}
