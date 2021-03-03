package com.itcrazy.alanmall.mscard.dto.request;

import com.itcrazy.alanmall.common.framework.dto.CardBaseRequestDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import lombok.Data;

@Data
public class ChangeHistoryReqDto extends CardBaseRequestDto {
	// 旧卡号
	private String oldCardNo;

	// 换卡补卡区分
	private Integer type;

	// 所属门店
	private Long store;

	@Override
	public void requestCheck() {

	}
}
