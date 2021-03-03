package com.itcrazy.alanmall.office.data.manager;

import com.itcrazy.alanmall.office.dto.SmsDto;
import com.itcrazy.alanmall.office.model.Sms;
import java.util.List;

public interface SmsDataManager {
  List<Sms> getPageList(SmsDto paramSmsDto);
  
  Integer getPageTotal(SmsDto paramSmsDto);
  
  Sms getSmsById(Long paramLong);
  
  Integer getSmsTotal(SmsDto paramSmsDto);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\data\manager\SmsDataManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */