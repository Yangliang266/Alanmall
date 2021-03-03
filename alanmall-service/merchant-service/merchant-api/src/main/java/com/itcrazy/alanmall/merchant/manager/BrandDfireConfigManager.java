package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.model.BrandDfireConfig;

public interface BrandDfireConfigManager {
  BrandDfireConfig getBrandDfireConfigByBrandId(Long paramLong);
  
  int deleteConfigByBrandId(Long paramLong1, Long paramLong2);
  
  BrandDfireConfig insertBrandDfireConfig(BrandDfireConfig paramBrandDfireConfig);
  
  void updateByBrandId(BrandDfireConfig paramBrandDfireConfig);
  
  BrandDfireConfig getBrandDfireConfigByChainEntityId(String paramString1, String paramString2);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\BrandDfireConfigManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */