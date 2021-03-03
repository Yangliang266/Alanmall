package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.dto.PrepaidCardConfigDto;
import com.itcrazy.alanmall.merchant.model.PrepaidCardConfig;
import java.util.List;

public interface PrepaidCardConfigManager {
  PrepaidCardConfig getPrepaidCardConfigById(Long paramLong);
  
  List<PrepaidCardConfig> getPageList(PrepaidCardConfigDto paramPrepaidCardConfigDto);
  
  int getPageTotal(PrepaidCardConfigDto paramPrepaidCardConfigDto);
  
  PrepaidCardConfig insertPrepaidCardConfig(PrepaidCardConfig paramPrepaidCardConfig);
  
  int deletePrepaidCardConfig(PrepaidCardConfig paramPrepaidCardConfig);
  
  int updatePrepaidCardConfig(PrepaidCardConfig paramPrepaidCardConfig);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\PrepaidCardConfigManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */