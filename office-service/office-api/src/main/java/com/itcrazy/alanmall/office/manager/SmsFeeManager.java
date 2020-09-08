package com.itcrazy.alanmall.office.manager;

import com.itcrazy.alanmall.office.dto.SmsFeeDto;
import com.itcrazy.alanmall.office.model.SmsFee;
import java.math.BigDecimal;
import java.util.List;

public interface SmsFeeManager {
  SmsFee addSmsFee(BigDecimal paramBigDecimal, Integer paramInteger) throws Exception;
  
  List<SmsFee> getPageList(SmsFeeDto paramSmsFeeDto);
  
  Integer getPageTotal(SmsFeeDto paramSmsFeeDto);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\manager\SmsFeeManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */