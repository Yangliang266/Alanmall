package com.itcrazy.alanmall.mscard.dto.request;

import com.itcrazy.alanmall.common.framework.dto.BaseDto;
import com.itcrazy.alanmall.common.framework.dto.CardBaseRequestDto;
import lombok.Data;

/**
 * 挂帐管理实体类
 * @author luxf
 * 2018-09-04
 */
@Data
public class CreditReqDto extends CardBaseRequestDto {
	private static final long serialVersionUID = -484438904784258758L;

	// 卡号
	private String cardNo;

	// 卡号
	private String motherCardNo;

	// 商家id
	private Long companyId;

	// categoryId
	private Long id;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public void requestCheck() {

	}
}
