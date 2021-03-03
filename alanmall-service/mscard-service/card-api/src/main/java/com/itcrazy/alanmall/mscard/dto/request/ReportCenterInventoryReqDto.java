package com.itcrazy.alanmall.mscard.dto.request;

import com.itcrazy.alanmall.common.framework.dto.CardBaseRequestDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import lombok.Data;

import java.util.Date;

@Data
public class ReportCenterInventoryReqDto extends CardBaseRequestDto {
	// 开始时间
	private Date timeBegin;

	// 结束时间
	private Date timeEnd;

	// 目标门店
	private Long storeTo;

	// 门店
	private String releaseStores;

	@Override
	public void requestCheck() {

	}
}
