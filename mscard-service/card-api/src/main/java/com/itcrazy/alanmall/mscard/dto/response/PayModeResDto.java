package com.itcrazy.alanmall.mscard.dto.response;

import com.itcrazy.alanmall.common.framework.dto.CardBaseResponseDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import lombok.Data;

/**
 * 充值方式Dto类
 * @author chenfei
 * 2018-10-18
 */
@Data
public class PayModeResDto extends CardBaseResponseDto {
	// 状态
	private Integer status;

}
