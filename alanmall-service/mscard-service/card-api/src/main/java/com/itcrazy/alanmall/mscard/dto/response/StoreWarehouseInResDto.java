package com.itcrazy.alanmall.mscard.dto.response;

import com.itcrazy.alanmall.common.framework.dto.CardBaseResponseDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import com.itcrazy.alanmall.mscard.model.StoreWarehouseIn;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class StoreWarehouseInResDto extends CardBaseResponseDto {
	// 复选框数组
	private List<StoreWarehouseIn> chkList;

	// 对应的出库单号
	private String warehouseOutNo;

	// 总部所有出库状态
	private String btnSearchAll;

	// 总部出库单号
	private String headOutReceiptNo;

	// 门店入库单号
	private String storeInReceiptNo;

	// 卡号
	private String cardNo;

	// 结束卡号
	private String cardNoEnd;

	// 卡状态
	private int status;

	// 总部出库时间开始
	private Date headOutTimeBegin;

	// 总部出库时间开始
	private Date headOutTimeEnd;

	// 原始门店
	private Long storeFrom;

	// 目标门店
	private Long storeTo;

	// 门店出库单号
	private String storeOutReceiptNo;

	// 门店入库数量
	private String storeInNum;

}
