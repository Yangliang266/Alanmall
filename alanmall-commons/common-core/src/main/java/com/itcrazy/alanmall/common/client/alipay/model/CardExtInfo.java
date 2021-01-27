package com.itcrazy.alanmall.common.client.alipay.model;


import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class CardExtInfo extends BaseModelAdapter {
	private static final long serialVersionUID = -6274473693570324553L;

	private String bizCardNo;
	private String externalCardNo;
	private Date openDate;
	private Date validDate;
	private String level;
	private String point;
	private String balance;
	private String templateId;
	private String frontImageId;

}
