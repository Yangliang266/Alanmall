package com.itcrazy.alanmall.office.manager;

import com.itcrazy.alanmall.office.dto.SmsRechargeDto;
import com.itcrazy.alanmall.office.model.SmsRecharge;
import java.util.List;

public interface SmsRechargeManager {
  Integer getSumRecharge(Long paramLong);
  
  List<SmsRecharge> getSmsRechargeList(SmsRechargeDto paramSmsRechargeDto);
  
  List<SmsRecharge> getSmsRechargeSumList(SmsRechargeDto paramSmsRechargeDto);
  
  SmsRecharge addSmsRecharge(SmsRecharge paramSmsRecharge);
  
  Integer getSmsRechargeSumListTotal(SmsRechargeDto paramSmsRechargeDto);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\manager\SmsRechargeManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */