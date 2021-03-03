package com.itcrazy.alanmall.mscard.dto.Base;

import com.itcrazy.alanmall.common.framework.dto.BaseDto;
import lombok.Data;

@Data
public class ChangeCardDto extends BaseDto {
	// 新卡卡号
	private String newCardNo;

	// 老卡卡号
	private String oldCardNo;

	// 商家id
	private Long companyId;

	// 门店id
	private Long store;

	// 删除标志
	private int isDeleted;

	// 创建人
	private Long createId;

	// 更新人
	private Long updateId;

	// 卡状态
	private int status;

}
