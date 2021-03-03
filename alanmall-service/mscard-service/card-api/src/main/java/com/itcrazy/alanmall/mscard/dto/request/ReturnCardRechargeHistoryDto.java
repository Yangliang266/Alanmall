package com.itcrazy.alanmall.mscard.dto.request;

import com.itcrazy.alanmall.common.framework.dto.CardBaseRequestDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import lombok.Data;

@Data
public class ReturnCardRechargeHistoryDto extends CardBaseRequestDto{
	// 门店id
	private Long StoreId;

	// 卡号
	private String cardNo;

	// 卡状态
	private int Status;

	// 门店入库单号
	private String storeInReceiptNo;

	@Override
	public void requestCheck() {

	}
}
