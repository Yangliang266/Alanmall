package com.itcrazy.alanmall.office.manager;

import com.itcrazy.alanmall.office.model.SmsType;
import java.util.List;

public interface SmsTypeManager {
  SmsType getSmsTypeById(Long paramLong);
  
  List<SmsType> getSmsTypeList(Long paramLong);
  
  List<SmsType> getListBySmsCode(String paramString);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\manager\SmsTypeManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */