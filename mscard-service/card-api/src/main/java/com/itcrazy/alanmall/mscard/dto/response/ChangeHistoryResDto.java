package com.itcrazy.alanmall.mscard.dto.response;

import com.itcrazy.alanmall.common.framework.dto.CardBaseResponseDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import lombok.Data;

@Data
public class ChangeHistoryResDto extends CardBaseResponseDto {
	// 旧卡号
	private String oldCardNo;

	// 换卡补卡区分
	private Integer type;

	// 所属门店
	private Long store;

}
