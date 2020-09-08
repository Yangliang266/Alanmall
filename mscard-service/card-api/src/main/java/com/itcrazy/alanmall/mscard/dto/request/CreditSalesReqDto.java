package com.itcrazy.alanmall.mscard.dto.request;


import com.itcrazy.alanmall.common.framework.dto.BaseDto;
import com.itcrazy.alanmall.common.framework.dto.CardBaseRequestDto;
import lombok.Data;

import java.util.Date;

/**
 * 挂账一览dto类
 * @author zhangzhongtian
 * 2018-10-09
 */
@Data
public class CreditSalesReqDto extends CardBaseRequestDto {
	// 挂账订单号
	private String id;

	//卡号
	private String cardNo;

	//开始时间
	private Date beginTime;

	//结束时间
	private Date endTime;

	//挂账状态
	private Integer status;

	//商家id
	private Long companyId;

	// 挂账状态Flag(是否去除已清账条件)
	private String statusFlag;

	@Override
	public void requestCheck() {

	}
}
