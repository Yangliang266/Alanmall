package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.model.County;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface CountyDao extends BaseDao<County, Long> {
  List<County> getCountyListById(Long paramLong);
  
  County getCountyByCode(String paramString);
  
  County getCountyByName(String paramString);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\CountyDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */