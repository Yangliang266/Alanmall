package com.itcrazy.alanmall.common.client.alipay.model;

import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 商家支付宝帐号配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CompanyAlipay extends BaseModelAdapter {
	private static final long serialVersionUID = -8469004794436485639L;
	private Long id;
	private Long companyId;
	private Long brandId;
	private Long storeId;
	private String partner; // 合作身份者ID，以2088开头由16位纯数字组成
	private String appId; // 收款支付宝账号，一般情况下与合作身份者ID相同
	private String privateKey; // 商户的私钥
	private String publicKey;
	private String md5Key; // 安全校验码
	private Integer signType; // 密钥签名方式，1:RSA, 2:DSA, 3:MD5
	private Date createTime;
	private Date updateTime;
	private Long createId;
	private Long updateId;
	private Integer isDeleted;
	private String applyCardUrl;

	/**
	 * 加密方法，默认 RSA2
	 */
	public String getSignTypeName() {
		if (signType == 1) {
			return "RSA";
		} else if (signType == 2) {
			return "DSA";
		} else if (signType == 3) {
			return "MD5";
		} else if (signType == 4) {
			return "RSA2";
		}
		return "RSA2";
	}

}
