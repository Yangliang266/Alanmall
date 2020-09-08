package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.model.Store;
import com.itcrazy.alanmall.merchant.model.StorePosConfig;
import java.util.List;

public interface StorePosConfigManager {
  List<StorePosConfig> getListByStoreId(Long paramLong);
  
  int updateStorePosConfig(Store paramStore, List<StorePosConfig> paramList);
  
  StorePosConfig getConfigBySourceCode(Integer paramInteger, String paramString);
  
  int deleteConfigByStoreId(Long paramLong1, Long paramLong2);
  
  List<StorePosConfig> getStorePosConfig(StorePosConfig paramStorePosConfig);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\StorePosConfigManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */