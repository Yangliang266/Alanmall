package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.model.ThirdServiceConfig;
import java.util.List;

public interface ThirdServiceConfigManager {
  ThirdServiceConfig getById(Long paramLong);
  
  List<ThirdServiceConfig> getListByStoreId(Long paramLong);
  
  List<ThirdServiceConfig> getListByBrandId(Long paramLong);
  
  ThirdServiceConfig add(ThirdServiceConfig paramThirdServiceConfig);
  
  int update(ThirdServiceConfig paramThirdServiceConfig);
  
  int deleteById(Long paramLong1, Long paramLong2);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\ThirdServiceConfigManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */