package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.model.LandMark;
import java.util.List;

public interface LandMarkManager {
  List<LandMark> getLandMarkListByCityId(Long paramLong);
  
  LandMark getLandMark(Long paramLong);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\LandMarkManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */