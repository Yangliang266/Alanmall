package com.itcrazy.alanmall.mscard.dto.Base;

import lombok.Data;

import java.util.Date;

@Data
public class ReportCenterInventoryDto extends CardBaseDto {
	// 开始时间
	private Date timeBegin;

	// 结束时间
	private Date timeEnd;

	// 目标门店
	private Long storeTo;

	// 门店
	private String releaseStores;

}
