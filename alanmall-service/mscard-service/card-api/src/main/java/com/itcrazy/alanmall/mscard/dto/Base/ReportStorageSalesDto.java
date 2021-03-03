package com.itcrazy.alanmall.mscard.dto.Base;

import lombok.Data;

import java.util.Date;

@Data
public class ReportStorageSalesDto extends CardBaseDto {
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



