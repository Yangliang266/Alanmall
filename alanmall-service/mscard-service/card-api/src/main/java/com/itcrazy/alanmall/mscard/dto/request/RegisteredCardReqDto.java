package com.itcrazy.alanmall.mscard.dto.request;

import com.itcrazy.alanmall.common.framework.dto.BaseDto;
import com.itcrazy.alanmall.common.framework.dto.CardBaseRequestDto;
import lombok.Data;

/**
 * 卡激活(单张发卡，编辑)DTO实体类
 * @author huangchunbo
 * 2018-10-09
 */
@Data
public class RegisteredCardReqDto extends CardBaseRequestDto {
	// 卡号
	private String cardNo;

	// 商家id
	private Long companyId;

	@Override
	public void requestCheck() {

	}
}
