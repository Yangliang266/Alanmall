package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.model.Cuisine;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface CuisineDao extends BaseDao<Cuisine, Long> {
  List<Cuisine> getCuisineByParentId(Long paramLong);
  
  Cuisine getCuisineByCode(String paramString);
  
  List<Cuisine> getAllCuisineClassCuisine();
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\CuisineDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */