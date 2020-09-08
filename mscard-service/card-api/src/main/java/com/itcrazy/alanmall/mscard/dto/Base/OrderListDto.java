package com.itcrazy.alanmall.mscard.dto.Base;

import com.itcrazy.alanmall.common.framework.dto.BaseDto;
import lombok.Data;

/**
 * 订单一览表Dto类
 * @author zhangzt
 * 2018-10-23
 */
@Data
public class OrderListDto extends BaseDto {
	// 订单号
	private String orderNo;

	// 商家id
	private Long companyId;

}
