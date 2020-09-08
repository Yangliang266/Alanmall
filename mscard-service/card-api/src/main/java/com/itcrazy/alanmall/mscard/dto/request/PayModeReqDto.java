package com.itcrazy.alanmall.mscard.dto.request;

import com.itcrazy.alanmall.common.framework.dto.CardBaseRequestDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import lombok.Data;

/**
 * 充值方式Dto类
 * @author chenfei
 * 2018-10-18
 */
@Data
public class PayModeReqDto extends CardBaseRequestDto {
	// 状态
	private Integer status;

	@Override
	public void requestCheck() {

	}
}
