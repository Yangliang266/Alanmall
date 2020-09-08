package com.itcrazy.alanmall.mscard.dto.response;

import com.itcrazy.alanmall.common.framework.dto.BaseDto;
import com.itcrazy.alanmall.common.framework.dto.CardBaseResponseDto;
import lombok.Data;

import java.util.Date;

/**
 * 总部出库DTO实体类
 *
 * @author luxf 2018-09-10
 */
@Data
public class HeadWarehouseOutResDto extends CardBaseResponseDto {
	// 总部入库单号
	private String iptHeadinReceiptNo;

	// 卡号
	private String cardNo;

	// 结束卡号
	private String cardNoEnd;

	// 总部入库状态
	private String btnStatus;

	// 总部入库时间开始时间
	private Date createTimeBegin;

	// 总部入库时间结束时间
	private Date createTimeEnd;

	//总部 出库单号
	private String receiptNo;

	// 商家ID
	private Long companyId;

	// 出库卡数量
	private String cardNoNum;

}
