package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.dto.VersionChgDto;
import com.itcrazy.alanmall.merchant.model.VersionChg;
import java.util.List;

public interface VersionChgManager {
  VersionChg getVersionChgById(Long paramLong);
  
  VersionChg addVersionChg(VersionChg paramVersionChg);
  
  int updateVersionChg(VersionChg paramVersionChg);
  
  int removeVersionChg(VersionChg paramVersionChg);
  
  List<VersionChg> getPageList(VersionChgDto paramVersionChgDto);
  
  Integer getPageTotal(VersionChgDto paramVersionChgDto);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\VersionChgManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */