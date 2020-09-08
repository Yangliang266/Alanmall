package com.itcrazy.alanmall.mscard.dto.request;

import com.itcrazy.alanmall.common.framework.dto.CardBaseRequestDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import lombok.Data;

import java.util.Date;

@Data
public class ReportMemberActivePercentageReqDto extends CardBaseRequestDto{

	private static final long serialVersionUID = -484438904784258758L;

	private String cardNo;

	private String name;

	private Long store;

	private Long category;

	private Date beginTime;

	private Date endTime;

	@Override
	public void requestCheck() {

	}
}
