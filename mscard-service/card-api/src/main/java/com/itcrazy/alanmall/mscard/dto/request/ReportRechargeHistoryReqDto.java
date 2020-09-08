package com.itcrazy.alanmall.mscard.dto.request;

import com.itcrazy.alanmall.common.framework.dto.BaseDto;
import com.itcrazy.alanmall.common.framework.dto.CardBaseRequestDto;

import java.util.Date;

/**
 * 发卡中心-发卡充值统计表DTO实体类
 * @author huangchunbo
 * 2018-10-09
 */
public class ReportRechargeHistoryReqDto extends CardBaseRequestDto {
	// 商家ID
	private Long companyId;

	// 充值起始时间
	private Date rechargeTimeBegin;

	// 充值结束时间
	private Date rechargeTimeEnd;

	// 充值门店
	private String stores;

	// 卡号
	private String cardNo;

	@Override
	public void requestCheck() {

	}
}
