package com.itcrazy.alanmall.mscard.dto.Base;

import lombok.Data;

/**
 * 激活卡信息Dto类
 * @author zhangli
 * 2018-09-18
 */
@Data
public class ActiveInformationDto extends CardBaseDto{
	// 卡号
	private String cardNo;

	// 手机号码
	private String telephone;

	// 身份证件号
	private String idNumber;

	// 所属门店
	private Long store;

}
