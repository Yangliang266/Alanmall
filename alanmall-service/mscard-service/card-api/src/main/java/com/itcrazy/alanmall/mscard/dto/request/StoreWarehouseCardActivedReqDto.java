package com.itcrazy.alanmall.mscard.dto.request;

import com.itcrazy.alanmall.common.framework.dto.CardBaseRequestDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import lombok.Data;

import java.util.List;

/**
 * 门店卡激活Dto类
 * @author huangchunbo
 * 2018-09-17
 */
@Data
public class StoreWarehouseCardActivedReqDto extends CardBaseRequestDto{
	// 复选框数组
	private List<CardInformation> chkList;

	// 门店入库单号
	private String receiptNo;

	// 卡号
	private String cardNo;

	// 结束卡号
	private String cardNoEnd;

	// 卡状态
	private int status;

	// 目标门店
	private Long storeTo;

	// 门店id
	private Long storeId;

	@Override
	public void requestCheck() {

	}
}
