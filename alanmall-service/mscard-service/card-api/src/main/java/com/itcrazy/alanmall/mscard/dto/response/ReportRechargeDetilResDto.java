package com.itcrazy.alanmall.mscard.dto.response;

import com.itcrazy.alanmall.common.framework.dto.BaseDto;
import com.itcrazy.alanmall.common.framework.dto.CardBaseResponseDto;
import lombok.Data;

import java.util.Date;

/**
 * 发卡/充值明细表DTO实体类
 * @author huangchunbo
 * 2018-10-09
 */
@Data
public class ReportRechargeDetilResDto extends CardBaseResponseDto {
	// 商家ID
	private Long companyId;

	// 发卡开始时间
	private Date beginTime;

	//发卡结束时间
	private Date endTime;

	// 充值门店
	private String rechargeStores;

	// 发卡门店
	private String publishStores;

	// 卡号
	private String cardNo;

	private Integer limitToday; // (1:从原始数据库查询当天记录，其余值从报表库查询)

	// 充值开始时间
	private Date chargeBeginTime;

	// 充值结束时间
	private Date chargeEndTime;

}
