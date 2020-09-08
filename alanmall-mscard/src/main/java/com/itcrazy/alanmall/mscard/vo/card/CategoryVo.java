package com.itcrazy.alanmall.mscard.vo.card;

import com.itcrazy.alanmall.mscard.model.Discount;

import java.util.List;

/**
 * 卡类别页面展示类
 * @author chenfei
 * 2018-09-04
 */
public class CategoryVo {

	// 卡类别编号
	private Long id;

	// 卡类别名称
	private String name;

	// 是否记名卡
	private String isNamed;

	// 本金限额
	private String rechargeQuota;

	// 卡支付密码是否必填
	private String isPwdMust;

	// 是否可充值
	private String isRecharge;

	// 可充值次数
	private Integer rechargeCount;

	// 是否可挂账
	private String isCredit;

	// 消费折扣率
	private String discount;

	// 可消费城市列表
	private String cities;

	// 可消费品牌列表
	private String brands;

	// 可消费门店列表
	private String stores;

	// 门店全参与品牌列表
	private String allJoinBrands;

	// 卡类别状态
	private String status;

	// 卡BIN
	private String bin;

	// 备注
	private String remarks;

	// 品牌门店折扣率列表
	private List<Discount> discountList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsNamed() {
		return isNamed;
	}

	public void setIsNamed(String isNamed) {
		this.isNamed = isNamed;
	}

	public String getIsPwdMust() {
		return isPwdMust;
	}

	public void setIsPwdMust(String isPwdMust) {
		this.isPwdMust = isPwdMust;
	}

	public String getIsRecharge() {
		return isRecharge;
	}

	public void setIsRecharge(String isRecharge) {
		this.isRecharge = isRecharge;
	}

	public String getIsCredit() {
		return isCredit;
	}

	public void setIsCredit(String isCredit) {
		this.isCredit = isCredit;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getCities() {
		return cities;
	}

	public void setCities(String cities) {
		this.cities = cities;
	}

	public String getBrands() {
		return brands;
	}

	public void setBrands(String brands) {
		this.brands = brands;
	}

	public String getStores() {
		return stores;
	}

	public void setStores(String stores) {
		this.stores = stores;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getRechargeCount() {
		return rechargeCount;
	}

	public void setRechargeCount(Integer rechargeCount) {
		this.rechargeCount = rechargeCount;
	}

	public String getAllJoinBrands() {
		return allJoinBrands;
	}

	public void setAllJoinBrands(String allJoinBrands) {
		this.allJoinBrands = allJoinBrands;
	}

	public List<Discount> getDiscountList() {
		return discountList;
	}

	public void setDiscountList(List<Discount> discountList) {
		this.discountList = discountList;
	}

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	public String getRechargeQuota() {
		return rechargeQuota;
	}

	public void setRechargeQuota(String rechargeQuota) {
		this.rechargeQuota = rechargeQuota;
	}

}
