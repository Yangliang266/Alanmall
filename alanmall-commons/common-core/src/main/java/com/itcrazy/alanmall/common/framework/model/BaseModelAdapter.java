package com.itcrazy.alanmall.common.framework.model;

import com.itcrazy.alanmall.common.framework.model.impl.BaseModelImpl;

public abstract class BaseModelAdapter extends BaseModelImpl {

	private static final long serialVersionUID = -2855310354033585734L;

	public static final int IS_FLAG_NO = 0; // 是否中否
	public static final int IS_FLAG_YES = 1;

	public static final int STATUS_FLAG_OK = 0;
	public static final long ID_DEFAULT = 0; // 默认商家id

	protected Long id;
	private Long officeAreaId;

	public Long getId() {
		return id;
	}

	public Long getOfficeAreaId() {
		officeAreaId = 1L;
		return officeAreaId;
	}

	public void setOfficeAreaId(Long officeAreaId) {
		this.officeAreaId = officeAreaId;
	}

}
