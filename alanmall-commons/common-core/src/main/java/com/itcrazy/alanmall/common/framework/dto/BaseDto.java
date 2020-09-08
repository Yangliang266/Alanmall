package com.itcrazy.alanmall.common.framework.dto;

import java.io.Serializable;

public abstract class BaseDto implements Serializable {

	private static final long serialVersionUID = -3421967713124993855L;

	private int start = 0; // 开始记录

	private int limit = 10; // 默认每页记录数

	private String sort; // 排序字段名

	private String dir; // 排序

	private boolean needCount;

	private int totalCount;

	private String companyIds;

	private String brandIds;

	private String storeIds;

	private Long roleLevelId;

	private String officeAreaIds;

	private String keyValue; // 根据关键字搜索

	private boolean includeHQ; // 是否包含总部，true：包含，false：不包含

	public BaseDto() {
		officeAreaIds = "1,2";
	}

	final public int getTotalCount() {
		return totalCount;
	}

	final public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	final public void calStart() {
		if (start >= totalCount) {
			start = ((int) ((totalCount - 1) / limit)) * limit;
		}
	}

	final public void setPgNumber(int pgNumber) {
		if (pgNumber < 1)
			pgNumber = 1;

		start = (pgNumber - 1) * limit;
	}

	final public int getPgNumber() {
		return start / limit + 1;
	}

	final public int getEnd() {
		return this.start + this.limit;
	}

	final public int getStart() {
		return start;
	}

	final public void setStart(int start) {
		this.start = start;
	}

	final public int getLimit() {
		return limit;
	}

	final public void setLimit(int limit) {
		this.limit = limit;
	}

	final public boolean isNeedCount() {
		return needCount;
	}

	final public void setNeedCount(boolean needCount) {
		this.needCount = needCount;
	}

	final public String getSort() {
		return sort;
	}

	final public void setSort(String sort) {
		this.sort = sort;
	}

	final public String getDir() {
		return dir;
	}

	final public void setDir(String dir) {
		this.dir = dir;
	}

	public String getCompanyIds() {
		return companyIds;
	}

	public void setCompanyIds(String companyIds) {
		this.companyIds = companyIds;
	}

	public String getBrandIds() {
		return brandIds;
	}

	public void setBrandIds(String brandIds) {
		this.brandIds = brandIds;
	}

	public String getStoreIds() {
		return storeIds;
	}

	public void setStoreIds(String storeIds) {
		this.storeIds = storeIds;
	}

	public Long getRoleLevelId() {
		return roleLevelId;
	}

	public void setRoleLevelId(Long roleLevelId) {
		this.roleLevelId = roleLevelId;
	}

	/**
	 * @return the keyValue
	 */
	public String getKeyValue() {
		return keyValue;
	}

	/**
	 * 设置搜索关键字（字段值）
	 * 
	 * @param keyValue
	 *            the keyValue to set
	 */
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	public String getOfficeAreaIds() {
		return officeAreaIds;
	}

	public void setOfficeAreaIds(String officeAreaIds) {
		this.officeAreaIds = officeAreaIds;
	}

	public boolean isIncludeHQ() {
		return includeHQ;
	}

	public void setIncludeHQ(boolean includeHQ) {
		this.includeHQ = includeHQ;
	}

}
