package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.model.BrandDfireConfig;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public interface BrandDfireConfigDao extends BaseDao<BrandDfireConfig, Long> {
  BrandDfireConfig getBrandDfireConfigByBrandId(Long paramLong);
  
  int deleteByBrandId(Map<String, Object> paramMap);
  
  void updateByBrandId(BrandDfireConfig paramBrandDfireConfig);
  
  BrandDfireConfig getBrandDfireConfigByChainEntityId(Map<String, Object> paramMap);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\BrandDfireConfigDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */