package com.itcrazy.alanmall.mscard.dto.response;

import com.itcrazy.alanmall.common.framework.dto.CardBaseResponseDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import lombok.Data;

import java.util.Date;

/**
 * 营收账款余额表（当日）Dto
 * @author yangliang
 * 2018-10-09
 */
@Data
public class ReportAccountTodayResDto extends CardBaseResponseDto {
	// 当前时间
	private Date timeToday;

	// 门店id
	private long releaseStores;

}
