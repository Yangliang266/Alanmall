package com.itcrazy.alanmall.mscard.dto.response;

import com.itcrazy.alanmall.common.framework.dto.CardBaseResponseDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import lombok.Data;

import java.util.Date;

@Data
public class ReportMemberActivePercentageResDto extends CardBaseResponseDto {

	private String cardNo;

	private String name;

	private Long store;

	private Long category;

	private Date beginTime;

	private Date endTime;

}
