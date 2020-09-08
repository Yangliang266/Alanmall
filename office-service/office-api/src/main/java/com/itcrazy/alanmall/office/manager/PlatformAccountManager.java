package com.itcrazy.alanmall.office.manager;

import com.itcrazy.alanmall.office.dto.PlatformAccountDto;
import com.itcrazy.alanmall.office.model.PlatformAccount;
import java.util.List;

public interface PlatformAccountManager {
  PlatformAccount getPlatformAccountByCode(Integer paramInteger);
  
  PlatformAccount getPlatformAccountByUserName(String paramString);
  
  List<PlatformAccount> getPageList(PlatformAccountDto paramPlatformAccountDto);
  
  Integer getPageTotal(PlatformAccountDto paramPlatformAccountDto);
  
  PlatformAccount getPlatformAccountById(Long paramLong);
  
  int deletePlatformAccount(PlatformAccount paramPlatformAccount);
  
  PlatformAccount insertPlatformAccount(PlatformAccount paramPlatformAccount);
  
  int updatePlatformAccount(PlatformAccount paramPlatformAccount);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\manager\PlatformAccountManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */