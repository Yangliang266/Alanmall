package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.model.BrandCuisine;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface BrandCuisineDao extends BaseDao<BrandCuisine, Long> {
  List<BrandCuisine> getCuisineListByBrandId(Long paramLong);
  
  List<BrandCuisine> getCuisineClassListByBrandId(BrandCuisine paramBrandCuisine);
  
  int updateBrandCuisine(BrandCuisine paramBrandCuisine);
  
  int removeBrandCuisineByBrandId(BrandCuisine paramBrandCuisine);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\BrandCuisineDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */