package com.itcrazy.alanmall.common.framework.dto;

import lombok.Data;

import java.util.Date;

/**
 * 根据要求，添加公共字段，
 * 为了不改变com.itcrazy.alanmall.common.framework.dto.BaseDto共通，新建此类
 */
@Data
public class CardBaseDto extends BaseDto {

	// 创建时间
	private Date createTime;

	// 创建人
	private Long createId;

	// 更新时间
	private Date updateTime;

	// 更新人
	private Long updateId;

	// 是否被删除
	private int isDeleted;

	// 商家ID
	private Long companyId;

}
