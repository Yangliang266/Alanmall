package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.dto.BrandSmsConfigDto;
import com.itcrazy.alanmall.merchant.model.BrandSmsConfig;

public interface BrandSmsConfigManager {
  BrandSmsConfig getByBrandId(Long paramLong);
  
  BrandSmsConfig addBrandSmsConfig(BrandSmsConfig paramBrandSmsConfig);
  
  int updateBrand(BrandSmsConfig paramBrandSmsConfig);
  
  int removeBrand(BrandSmsConfig paramBrandSmsConfig);
  
  BrandSmsConfig getByBrandDto(BrandSmsConfigDto paramBrandSmsConfigDto);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\BrandSmsConfigManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */