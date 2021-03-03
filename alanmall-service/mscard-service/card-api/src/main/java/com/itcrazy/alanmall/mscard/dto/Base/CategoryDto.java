package com.itcrazy.alanmall.mscard.dto.Base;

import lombok.Data;

@Data
public class CategoryDto extends CardBaseDto{
	// 卡类别编号
	private Long id;

	// 卡类别名称
	private String name;

	// 是否记名卡
	private int isNamed;

	// 卡支付密码是否必填
	private int isPwdMust;

	// 是否可充值
	private Integer isRecharge;

	// 是否可挂账
	private int isCredit;

	// 消费折扣率
	private float discount;

	// 可消费城市列表
	private String cities;

	// 可消费品牌列表
	private String brands;

	// 可消费门店列表
	private String stores;

	// 卡类别状态
	private Integer status;

	// 备注
	private String remarks;

}
