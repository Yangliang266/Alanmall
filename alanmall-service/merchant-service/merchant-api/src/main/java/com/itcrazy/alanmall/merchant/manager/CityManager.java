package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.co.CityCo;
import com.itcrazy.alanmall.merchant.co.ProvinceCityCo;
import com.itcrazy.alanmall.merchant.co.StoreCityCo;
import com.itcrazy.alanmall.merchant.model.City;
import java.util.List;

public interface CityManager {
  List<City> getCityListById(Long paramLong);
  
  List<City> getCityList();
  
  City getCityByCode(String paramString);
  
  City getCityByName(String paramString);
  
  String getCityName(Long paramLong);
  
  Long getProvinceIdById(Long paramLong);
  
  void updateCityByName(City paramCity);
  
  List<StoreCityCo> getCityListByStore(Long paramLong1, Long paramLong2);
  
  List<CityCo> getCityListByStore4Combox(Long paramLong1, Long paramLong2);
  
  List<ProvinceCityCo> getProvinceCityList(Long paramLong1, Long paramLong2);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\CityManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */