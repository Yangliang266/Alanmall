package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.merchant.model.Brand;
import com.itcrazy.alanmall.merchant.model.StorePosConfig;

/**
 * 本地服务器缓存
 * @author 5i
 *
 */
public interface LocalCacheService {

	
	public Brand getBrandById(Long brandId);
	public String getStoreNameById(Long storeId);
	public String getMemberLevelNameById(Long memberLevelId);
	public StorePosConfig getConfigBySourceCode(Integer posCode, String posStoreCode);
	public String getProvinceNameById(Long provinceId);
	public String getCityNameById(Long cityId);
}
