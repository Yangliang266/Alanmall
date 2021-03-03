package com.itcrazy.alanmall.mscard.dto.response;

import com.itcrazy.alanmall.common.framework.dto.CardBaseResponseDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import lombok.Data;

/**
 * 卡充值Dto类
 * @author chenfei
 * 2018-09-13
 */
@Data
public class RechargeResDto extends CardBaseResponseDto {
	// 门店id
	private Long storeId;

	// 品牌id
	private Long brandId;

	// 卡号
	private String cardNo;

	// 结束卡号
	private String cardNoEnd;

	// 卡状态
	private int Status;

	// 门店入库单号
	private String storeInReceiptNo;

	// 充值卡号数量
	private String rechargeNum;

}
