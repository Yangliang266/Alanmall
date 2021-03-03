package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.model.County;
import java.util.List;

public interface CountyManager {
  List<County> getCountyListById(Long paramLong);
  
  County getCountyByCode(String paramString);
  
  County getCountyByName(String paramString);
  
  String getCountyName(Long paramLong);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\CountyManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */