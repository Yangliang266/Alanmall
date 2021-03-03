package com.itcrazy.alanmall.mscard.dto.response;

import com.itcrazy.alanmall.common.framework.dto.BaseDto;
import com.itcrazy.alanmall.common.framework.dto.CardBaseResponseDto;
import lombok.Data;

/**
 * 订单一览表Dto类
 * @author zhangzt
 * 2018-10-23
 */
@Data
public class OrderListResDto extends CardBaseResponseDto {
	// 订单号
	private String orderNo;

	// 商家id
	private Long companyId;

}
