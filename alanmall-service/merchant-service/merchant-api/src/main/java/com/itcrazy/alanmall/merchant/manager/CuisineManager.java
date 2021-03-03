package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.model.Cuisine;
import java.util.List;

public interface CuisineManager {
  List<Cuisine> getCuisineByParentId(Long paramLong);
  
  Cuisine getCuisineByCode(String paramString);
  
  List<Cuisine> getAllCuisineClassCuisine();
  
  Cuisine getCuisineById(Long paramLong);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\CuisineManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */