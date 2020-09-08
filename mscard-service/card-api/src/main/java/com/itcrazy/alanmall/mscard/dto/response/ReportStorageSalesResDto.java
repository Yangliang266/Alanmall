package com.itcrazy.alanmall.mscard.dto.response;

import com.itcrazy.alanmall.common.framework.dto.CardBaseResponseDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import lombok.Data;

import java.util.Date;

@Data
public class ReportStorageSalesResDto extends CardBaseResponseDto {
	// 消费门店
	private String store;

	// 发卡门店
	private String releaseStore;

	// 开始时间
	private Date timeBegin;

	// 结束时间
	private Date timeEnd;

	// 发卡门店
	private String releaseStores;

	// 消费门店
	private String Stores;

	// 卡号
	private String cardNo;

	private Integer limitToday; // (1:从原始数据库查询当天记录，其余值从报表库查询)


}



