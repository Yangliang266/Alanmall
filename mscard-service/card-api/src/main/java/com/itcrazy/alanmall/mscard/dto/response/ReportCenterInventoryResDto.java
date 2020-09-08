package com.itcrazy.alanmall.mscard.dto.response;

import com.itcrazy.alanmall.common.framework.dto.CardBaseResponseDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import lombok.Data;

import java.util.Date;

@Data
public class ReportCenterInventoryResDto extends CardBaseResponseDto {
	// 开始时间
	private Date timeBegin;

	// 结束时间
	private Date timeEnd;

	// 目标门店
	private Long storeTo;

	// 门店
	private String releaseStores;

}
