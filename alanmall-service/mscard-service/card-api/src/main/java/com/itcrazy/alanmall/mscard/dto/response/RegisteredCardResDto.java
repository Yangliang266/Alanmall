package com.itcrazy.alanmall.mscard.dto.response;

import com.itcrazy.alanmall.common.framework.dto.BaseDto;
import com.itcrazy.alanmall.common.framework.dto.CardBaseResponseDto;
import lombok.Data;

/**
 * 卡激活(单张发卡，编辑)DTO实体类
 * @author huangchunbo
 * 2018-10-09
 */
@Data
public class RegisteredCardResDto extends CardBaseResponseDto {
	// 卡号
	private String cardNo;

	// 商家id
	private Long companyId;

}
