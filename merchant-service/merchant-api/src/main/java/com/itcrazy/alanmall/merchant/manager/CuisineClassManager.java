package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.model.CuisineClass;
import java.util.List;
import java.util.Map;

public interface CuisineClassManager {
  List<CuisineClass> getCuisineClassList(int paramInt);
  
  Map<Long, String> getCuisineClassIdNameMap(int paramInt);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\CuisineClassManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */