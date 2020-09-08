package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.model.BrandAges;
import java.util.List;

public interface BrandAgesManager {
  List<BrandAges> getBrandAgesListByBrandId(Long paramLong);
  
  BrandAges addBrandAge(BrandAges paramBrandAges);
  
  int removeBrandAgesByBrandId(Long paramLong);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\BrandAgesManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */