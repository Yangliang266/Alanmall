package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.model.BrandCuisine;
import java.util.List;

public interface BrandCuisineManager {
  List<BrandCuisine> getCuisineListByBrandId(Long paramLong);
  
  List<BrandCuisine> getCuisineClassListByBrandId(Long paramLong, Integer paramInteger);
  
  BrandCuisine addBrandCuisine(BrandCuisine paramBrandCuisine);
  
  int removeBrandCuisineByBrandId(Long paramLong, Integer paramInteger);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\BrandCuisineManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */