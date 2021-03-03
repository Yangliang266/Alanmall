package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.dto.AppPosConfigDto;
import com.itcrazy.alanmall.merchant.model.AppPosConfig;
import java.util.List;

public interface AppPosConfigManager {
  AppPosConfig add(AppPosConfig paramAppPosConfig);
  
  int remove(AppPosConfig paramAppPosConfig);
  
  AppPosConfig get(Long paramLong);
  
  List<AppPosConfig> getPageList(AppPosConfigDto paramAppPosConfigDto);
  
  Integer getPageTotal(AppPosConfigDto paramAppPosConfigDto);
  
  int update(AppPosConfig paramAppPosConfig);
  
  AppPosConfig getAppPosConfigByDto(AppPosConfigDto paramAppPosConfigDto);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\AppPosConfigManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */