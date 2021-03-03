package com.itcrazy.alanmall.mscard.model;

/**
 * UCloud云的令牌
 * @author zhangli
 * 2018-10-28
 */
public class UCloudToken {
	// 存储空间名称
	private String bucketName = "";

	// 存储空间域名URL地址
	private String bucketUrl = "" ;

	// 令牌公钥
	private String tokenPublicKey = "";

	// 令牌私钥
	private String tokenPrivateKey = "";

	// 计算token的地址
	private String prefix = "";

	// 令牌配置的前缀，无前缀填空字符串
	private String tokenServerUrl;

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getBucketUrl() {
		return bucketUrl;
	}

	public void setBucketUrl(String bucketUrl) {
		this.bucketUrl = bucketUrl;
	}

	public String getTokenPublicKey() {
		return tokenPublicKey;
	}

	public void setTokenPublicKey(String tokenPublicKey) {
		this.tokenPublicKey = tokenPublicKey;
	}

	public String getTokenPrivateKey() {
		return tokenPrivateKey;
	}

	public void setTokenPrivateKey(String tokenPrivateKey) {
		this.tokenPrivateKey = tokenPrivateKey;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getTokenServerUrl() {
		return tokenServerUrl;
	}

	public void setTokenServerUrl(String tokenServerUrl) {
		this.tokenServerUrl = tokenServerUrl;
	}

}
