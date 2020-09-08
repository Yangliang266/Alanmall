package com.itcrazy.alanmall.mscard.dto.Base;

import com.itcrazy.alanmall.common.framework.dto.BaseDto;
import lombok.Data;

/**
 * 总部退货DTO实体类
 * @author yangliang
 * 2018-09-04
 */
@Data
public class ReturnCardDto extends BaseDto {
	private static final long serialVersionUID = -484438904784258758L;

	// 总部退货原因
	private String reason;

	// 卡号模糊查询字段
	private String cardNo;

	// 退货单号
	private String receiptNO;

	// 商家id
	private Long companyId;

}
