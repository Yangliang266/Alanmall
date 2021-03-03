package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.model.City;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public interface CityDao extends BaseDao<City, Long> {
  List<City> getCityListById(Long paramLong);
  
  List<City> getCityList();
  
  City getCityByCode(String paramString);
  
  City getCityByName(String paramString);
  
  void updateCityByName(City paramCity);
  
  List<City> getCityListByStore(Map<String, Object> paramMap);
  
  List<City> getProvinceCityList(Map<String, Object> paramMap);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\CityDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */