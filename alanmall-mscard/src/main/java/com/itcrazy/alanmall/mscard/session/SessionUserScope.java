package com.itcrazy.alanmall.mscard.session;

public class SessionUserScope {

	private Long companyId;
	private Long brandId;
	private Long storeId;
	private String brandIds;
	private String storeIds;
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
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
	
}
