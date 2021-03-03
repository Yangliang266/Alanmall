package com.itcrazy.alanmall.mscard.service.impl;

import com.itcrazy.alanmall.merchant.manager.*;
import com.itcrazy.alanmall.merchant.model.Brand;
import com.itcrazy.alanmall.merchant.model.Store;
import com.itcrazy.alanmall.merchant.model.StorePosConfig;
import com.itcrazy.alanmall.mscard.service.LocalCacheService;
import org.apache.commons.lang.StringUtils;
import java.util.HashMap;
import java.util.Map;

public class LocalCacheServiceImpl implements LocalCacheService {

	private static Map<Long, Brand> brandMap=new HashMap<Long,Brand>();
	private static Map<Long,String> storeMap=new HashMap<Long,String>();
	private static Map<String, StorePosConfig> storePosConfigMap = new HashMap<String, StorePosConfig>();
	private static Map<Long, String> provinceMap = new HashMap<Long, String>();
	private static Map<Long, String> cityMap = new HashMap<Long, String>();


	private BrandManager brandManager;
	private StoreManager storeManager;

	private StorePosConfigManager storePosConfigManager;
	private ProvinceManager provinceManager;
	private CityManager cityManager;

	@Override
	public Brand getBrandById(Long brandId){
		if(brandMap.get(brandId)!=null){
			return brandMap.get(brandId);
		}
		Brand b= brandManager.getBrandById(brandId);
		if(b==null){
			return null;
		}
		if(brandMap.size()>1000){
			brandMap.remove(brandMap.keySet().iterator().next());
		}
		brandMap.put(brandId, b);
		return b;
	}
	@Override
	public String getStoreNameById(Long storeId) {
		if(storeMap.get(storeId)!=null){
			return storeMap.get(storeId);
		}
		Store o= storeManager.getStoreById(storeId);
		if(o==null){
			return null;
		}
		if(storeMap.size()>1000){
			storeMap.remove(storeMap.keySet().iterator().next());
		}
		storeMap.put(storeId, o.getName());
		return o.getName();
	}

	@Override
	public StorePosConfig getConfigBySourceCode(Integer posCode, String posStoreCode) {
		String key = posCode + "@#@" + posStoreCode;
		if (storePosConfigMap.get(key) != null) {
			return storePosConfigMap.get(key);
		}
		StorePosConfig spc = storePosConfigManager.getConfigBySourceCode(posCode, posStoreCode);
		if (spc == null) {
			return null;
		}
		if (storePosConfigMap.size() > 1000) {
			storePosConfigMap.remove(storePosConfigMap.keySet().iterator().next());
		}
		storePosConfigMap.put(key, spc);
		return spc;
	}


	@Override
	public String getProvinceNameById(Long provinceId) {
		if(provinceId == null){
			return "";
		}
		if (provinceMap.get(provinceId) != null) {
			return provinceMap.get(provinceId);
		}
		String provinceName = provinceManager.getProvinceName(provinceId);
		if (StringUtils.isBlank(provinceName)) {
			return "";
		}
		if (provinceMap.size() > 1000) {
			provinceMap.remove(provinceMap.keySet().iterator().next());
		}
		provinceMap.put(provinceId, provinceName);
		return provinceName;
	}

	@Override
	public String getCityNameById(Long cityId) {
		if(cityId == null){
			return "";
		}
		if (cityMap.get(cityId) != null) {
			return cityMap.get(cityId);
		}
		String cityName = cityManager.getCityName(cityId);
		if (StringUtils.isBlank(cityName)) {
			return "";
		}
		if (cityMap.size() > 1000) {
			cityMap.remove(cityMap.keySet().iterator().next());
		}
		cityMap.put(cityId, cityName);
		return cityName;
	}


	public void setBrandManager(BrandManager brandManager) {
		this.brandManager = brandManager;
	}
	public void setStoreManager(StoreManager storeManager) {
		this.storeManager = storeManager;
	}



	public void setStorePosConfigManager(StorePosConfigManager storePosConfigManager) {
		this.storePosConfigManager = storePosConfigManager;
	}



	public void setProvinceManager(ProvinceManager provinceManager) {
		this.provinceManager = provinceManager;
	}
	public void setCityManager(CityManager cityManager) {
		this.cityManager = cityManager;
	}
	@Override
	public String getMemberLevelNameById(Long memberLevelId) {
		// TODO Auto-generated method stub
		return null;
	}

}
