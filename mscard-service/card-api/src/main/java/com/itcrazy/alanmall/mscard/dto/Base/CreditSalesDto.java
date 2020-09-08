package com.itcrazy.alanmall.mscard.dto.Base;


import com.itcrazy.alanmall.common.framework.dto.BaseDto;
import lombok.Data;

import java.util.Date;

/**
 * 挂账一览dto类
 * @author zhangzhongtian
 * 2018-10-09
 */
@Data
public class CreditSalesDto extends BaseDto {
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

}
