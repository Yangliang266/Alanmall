package com.itcrazy.alanmall.mscard.dto.response;

import com.itcrazy.alanmall.common.framework.dto.BaseDto;
import com.itcrazy.alanmall.common.framework.dto.CardBaseResponseDto;
import lombok.Data;

/**
 * 挂帐管理实体类
 * @author luxf
 * 2018-09-04
 */
@Data
public class CreditResDto extends CardBaseResponseDto {
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
}
