package com.itcrazy.alanmall.mscard.model;

import com.itcrazy.alanmall.common.client.constains.CardConstants;

import java.math.BigDecimal;
import java.util.List;

/**
 * 卡类别实体类
 * @author chenfei
 * 2018-09-03
 */
public class Category extends CardBaseModel{
	public final static Integer OPERATE_TYPE_ADD = 1;
	public final static Integer OPERATE_TYPE_EDIT = 2;
	public final static Integer OPERATE_TYPE_UPDATE_STATUS = 3;
	public final static Integer OPERATE_TYPE_DELETE = 4;

	// 操作类型  1：新增、2：编辑、3：启用/停用、4：删除
	private Integer operateType;

	// 卡类别编号
	private Long id;

	// 本金限额
	private BigDecimal rechargeQuota;

	// 卡类别名称
	private String name;

	// 是否记名卡
	private int isNamed;

	// 卡支付密码是否必填
	private int isPwdMust;

	// 是否可充值
	private int isRecharge;

	// 可充值次数
	private Integer rechargeCount;

	// 是否可挂账
	private int isCredit;

	// 消费折扣率
	private BigDecimal discount;

	// 可消费城市列表
	private String cities;

	// 可消费品牌列表
	private String brands;

	// 可消费门店列表
	private String stores;

	// 门店全参与品牌列表
	private String allJoinBrands;

	// 卡类别状态
	private Integer status;

	// 卡BIN(最长16位)
	private String bin;


	// 备注
	private String remarks;

	// 品牌门店折扣率列表
	private List<Discount> discountList;

	public Integer getOperateType() {
		return operateType;
	}

	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}

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

	public int getIsNamed() {
		return isNamed;
	}

	public void setIsNamed(int isNamed) {
		this.isNamed = isNamed;
	}

	public int getIsPwdMust() {
		return isPwdMust;
	}

	public void setIsPwdMust(int isPwdMust) {
		this.isPwdMust = isPwdMust;
	}

	public int getIsRecharge() {
		return isRecharge;
	}

	public void setIsRecharge(int isRecharge) {
		this.isRecharge = isRecharge;
	}

	public Integer getRechargeCount() {
		return rechargeCount;
	}

	public void setRechargeCount(Integer rechargeCount) {
		this.rechargeCount = rechargeCount;
	}

	public int getIsCredit() {
		return isCredit;
	}

	public void setIsCredit(int isCredit) {
		this.isCredit = isCredit;
	}

	public BigDecimal getDiscount() {
		return discount == null ? discount : discount.setScale(CardConstants.DEFAULT_DISCOUNT_NUM,
				CardConstants.DEFAULT_DISCOUNT_ROUNDING_MODE);
	}

	public void setDiscount(BigDecimal discount) {
		this.discount =  discount == null ? discount : discount.setScale(CardConstants.DEFAULT_DISCOUNT_NUM,
				CardConstants.DEFAULT_DISCOUNT_ROUNDING_MODE);
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<Discount> getDiscountList() {
		return discountList;
	}

	public void setDiscountList(List<Discount> discountList) {
		this.discountList = discountList;
	}

	public String getAllJoinBrands() {
		return allJoinBrands;
	}

	public void setAllJoinBrands(String allJoinBrands) {
		this.allJoinBrands = allJoinBrands;
	}

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	public BigDecimal getRechargeQuota() {
		return rechargeQuota;
	}

	public void setRechargeQuota(BigDecimal rechargeQuota) {
		this.rechargeQuota = rechargeQuota;
	}

}
