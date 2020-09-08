package com.itcrazy.alanmall.mscard.dto.Base;


import com.itcrazy.alanmall.common.framework.dto.BaseDto;

import java.util.Date;

/**
 * 根据要求，添加公共字段，
 * 为了不改变com.itcrazy.alanmall.common.framework.dto.BaseDto共通，新建此类
 * @author chenfei
 * 2018-09-10
 */
public class CardBaseDto extends BaseDto {

	/**
	 *
	 */
	private static final long serialVersionUID = 4326106332125494929L;


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


	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getCreateId() {
		return createId;
	}

	public void setCreateId(Long createId) {
		this.createId = createId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
