package com.itcrazy.alanmall.mscard.dto.Base;

import lombok.Data;

@Data
public class ChangeHistoryDto extends CardBaseDto{
	// 旧卡号
	private String oldCardNo;

	// 换卡补卡区分
	private Integer type;

	// 所属门店
	private Long store;

}
