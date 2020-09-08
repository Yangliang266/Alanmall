package com.itcrazy.alanmall.common.client.alipay.model;

import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
import lombok.Data;

@Data
public class MemberExtInfo extends BaseModelAdapter {
	private String name;
	private String gende;
	private String birth;
	private String cell;
}
