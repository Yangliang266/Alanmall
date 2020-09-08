package com.itcrazy.alanmall.common.client.alipay.model;

import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
import lombok.Data;

import java.util.Date;

/**
 * 商家支付宝帐号配置
 */
@Data
public class CompanyAlipay extends BaseModelAdapter {
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
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the companyId
	 */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId
	 *            the companyId to set
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the brandId
	 */
	public Long getBrandId() {
		return brandId;
	}

	/**
	 * @param brandId
	 *            the brandId to set
	 */
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	/**
	 * @return the partner
	 */
	public String getPartner() {
		return partner;
	}

	/**
	 * @param partner
	 *            the partner to set
	 */
	public void setPartner(String partner) {
		this.partner = partner;
	}

	/**
	 * @return the privateKey
	 */
	public String getPrivateKey() {
		return privateKey;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * @param privateKey
	 *            the privateKey to set
	 */
	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	/**
	 * @return the md5Key
	 */
	public String getMd5Key() {
		return md5Key;
	}

	/**
	 * @param md5Key
	 *            the md5Key to set
	 */
	public void setMd5Key(String md5Key) {
		this.md5Key = md5Key;
	}

	/**
	 * @return the signType
	 */
	public Integer getSignType() {
		return signType;
	}

	/**
	 * @param signType
	 *            the signType to set
	 */
	public void setSignType(Integer signType) {
		this.signType = signType;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 *            the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the createId
	 */
	public Long getCreateId() {
		return createId;
	}

	/**
	 * @param createId
	 *            the createId to set
	 */
	public void setCreateId(Long createId) {
		this.createId = createId;
	}

	/**
	 * @return the updateId
	 */
	public Long getUpdateId() {
		return updateId;
	}

	/**
	 * @param updateId
	 *            the updateId to set
	 */
	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	/**
	 * @return the isDeleted
	 */
	public Integer getIsDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted
	 *            the isDeleted to set
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

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

	public String getApplyCardUrl() {
		return applyCardUrl;
	}

	public void setApplyCardUrl(String applyCardUrl) {
		this.applyCardUrl = applyCardUrl;
	}
}
