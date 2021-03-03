package com.itcrazy.alanmall.office.manager;

import com.itcrazy.alanmall.office.model.SmsTypeCompany;
import java.util.List;

public interface SmsTypeCompanyManager {
  SmsTypeCompany addSmsTypeCompany(Long paramLong1, Long paramLong2, Long paramLong3, String paramString1, String paramString2, Long paramLong4, Integer paramInteger);
  
  SmsTypeCompany getSmsTypeCompanyById(Long paramLong);
  
  int updateSmsTypeCompany(SmsTypeCompany paramSmsTypeCompany);
  
  List<SmsTypeCompany> getSmsTypeCompanyListBySmsTypeId(Long paramLong1, Long paramLong2);
  
  SmsTypeCompany getSmsTypeCompanyBySmsTypeId(Long paramLong1, Long paramLong2);
  
  SmsTypeCompany getSmsTypeCompanyByStatus(Long paramLong1, Long paramLong2);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\manager\SmsTypeCompanyManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */