package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.model.ThirdServiceConfig;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface ThirdServiceConfigDao extends BaseDao<ThirdServiceConfig, Long> {
  List<ThirdServiceConfig> getListByStoreId(Long paramLong);
  
  List<ThirdServiceConfig> getListByBrandId(Long paramLong);
  
  int deleteById(Long paramLong1, Long paramLong2);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\ThirdServiceConfigDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */