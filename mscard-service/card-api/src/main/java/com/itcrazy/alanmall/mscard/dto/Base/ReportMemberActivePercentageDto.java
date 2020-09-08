package com.itcrazy.alanmall.mscard.dto.Base;

import lombok.Data;

import java.util.Date;

@Data
public class ReportMemberActivePercentageDto extends CardBaseDto{

	private static final long serialVersionUID = -484438904784258758L;

	private String cardNo;

	private String name;

	private Long store;

	private Long category;

	private Date beginTime;

	private Date endTime;

}
