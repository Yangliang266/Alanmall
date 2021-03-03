package com.itcrazy.alanmall.mscard.dto.response;

import com.itcrazy.alanmall.common.framework.dto.CardBaseResponseDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import lombok.Data;

import java.util.Date;

/**
 * 营收账款余额表（时段）Dto
 * @author yangliang
 * 2018-10-09
 */
@Data
public class ReportAccountPeriodResDto extends CardBaseResponseDto {
	// 开始时间
	private Date timeBegin;

	// 结束时间
	private Date timeEnd;

	// 门店id
	private long releaseStores;

}
