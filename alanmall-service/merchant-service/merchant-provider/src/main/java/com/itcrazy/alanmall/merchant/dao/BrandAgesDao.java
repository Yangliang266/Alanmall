package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.model.BrandAges;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface BrandAgesDao extends BaseDao<BrandAges, Long> {
  List<BrandAges> getBrandAgesListByBrandId(Long paramLong);
  
  int removeBrandAgesByBrandId(Long paramLong);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\BrandAgesDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */