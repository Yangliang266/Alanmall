package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.model.StoreTag;
import java.util.Date;

public interface StoreTagManager {
  int updateStoreTagByTime(Date paramDate) throws Exception;
  
  StoreTag getStoreTagByStoreId(Long paramLong);
  
  void updateStoreTag(StoreTag paramStoreTag);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\StoreTagManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */