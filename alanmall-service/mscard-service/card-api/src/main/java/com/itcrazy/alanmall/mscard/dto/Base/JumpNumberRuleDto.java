package com.itcrazy.alanmall.mscard.dto.Base;

import com.itcrazy.alanmall.common.framework.dto.BaseDto;
import lombok.Data;

/**
 * 跳号规则设置dto实体类
 * @author zhangzhongtian
 * 2018-09-17
 */
@Data
public class JumpNumberRuleDto extends BaseDto {
	// 删除标记
	private int isDeleted;

	// 商家ID
	private Long companyId;

}
