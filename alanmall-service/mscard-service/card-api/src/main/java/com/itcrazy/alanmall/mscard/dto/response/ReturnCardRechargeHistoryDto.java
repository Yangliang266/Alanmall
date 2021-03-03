package com.itcrazy.alanmall.mscard.dto.response;

import com.itcrazy.alanmall.common.framework.dto.CardBaseResponseDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import lombok.Data;

@Data
public class ReturnCardRechargeHistoryDto extends CardBaseResponseDto {
	// 门店id
	private Long StoreId;

	// 卡号
	private String cardNo;

	// 卡状态
	private int Status;

	// 门店入库单号
	private String storeInReceiptNo;

}
