package com.itcrazy.alanmall.common.framework.model;

import com.itcrazy.alanmall.common.framework.model.impl.BaseModelImpl;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

public abstract class BaseModelAdapter extends BaseModelImpl {

	private static final long serialVersionUID = -2855310354033585734L;

	public static final int IS_FLAG_NO = 0; // 是否中否
	public static final int IS_FLAG_YES = 1;

	public static final int STATUS_FLAG_OK = 0;
	public static final long ID_DEFAULT = 0; // 默认商家id

	@Getter
	protected Long id;

	@Getter
	@Setter
	private Long officeAreaId;



}
