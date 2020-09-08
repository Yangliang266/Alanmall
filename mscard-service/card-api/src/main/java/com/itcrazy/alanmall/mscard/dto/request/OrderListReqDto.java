package com.itcrazy.alanmall.mscard.dto.request;

import com.itcrazy.alanmall.common.framework.dto.BaseDto;
import com.itcrazy.alanmall.common.framework.dto.CardBaseRequestDto;
import lombok.Data;

/**
 * 订单一览表Dto类
 * @author zhangzt
 * 2018-10-23
 */
@Data
public class OrderListReqDto extends CardBaseRequestDto {
	// 订单号
	private String orderNo;

	// 商家id
	private Long companyId;

	@Override
	public void requestCheck() {

	}
}
