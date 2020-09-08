package com.itcrazy.alanmall.mscard.dto.request;

import com.itcrazy.alanmall.common.framework.dto.BaseDto;
import com.itcrazy.alanmall.common.framework.dto.CardBaseRequestDto;
import lombok.Data;

import java.util.Date;

/**
 * 挂账／清账报表实体类
 * @author luxf
 * 2018-10-11
 */
@Data
public class ReportCreditAccountReqDto extends CardBaseRequestDto {
	// 商家ID
	private Long companyId;

	// 挂帐消费开始时间
	private Date creditTimeBegin;

	// 挂帐消费结束时间
	private Date creditTimeEnd;

	// 挂帐消费门店
	private String stores;

	// 卡挂帐消费门店
	private String cardStores;

	// 删除标记
	private int isDeleted;

	// 卡号（汇总）
	private String cardNo;

	// 卡号（明细）
	private String oneCardNo;

	// 一张卡挂帐消费开始时间
	private Date creditCardTimeBegin;

	// 一张卡挂帐消费结束时间
	private Date creditCardTimeEnd;

	@Override
	public void requestCheck() {

	}
}
