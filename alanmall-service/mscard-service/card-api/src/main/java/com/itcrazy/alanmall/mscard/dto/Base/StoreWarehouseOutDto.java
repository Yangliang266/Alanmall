package com.itcrazy.alanmall.mscard.dto.Base;

import lombok.Data;

@Data
public class StoreWarehouseOutDto extends CardBaseDto {
	// 出库单号
	private String receiptNo;

	// 原始门店
	private Long storeFrom;
	// 门店id
	private Long storeId;

	// 目的门店
	private Long storeTo;

	// 门店入库单号
	private String storeInReceiptNo;

	// 卡号
	private String cardNo;

	// 结束卡号
	private String cardNoEnd;

	// 理由
	private String reason;

	// 卡状态
	private int status;

}
