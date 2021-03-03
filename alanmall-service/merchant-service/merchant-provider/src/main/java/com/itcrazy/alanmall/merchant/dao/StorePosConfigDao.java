package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.model.StorePosConfig;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public interface StorePosConfigDao extends BaseDao<StorePosConfig, Long> {
  List<StorePosConfig> getListByStoreId(Long paramLong);
  
  int deleteByStoreId(Map<String, Object> paramMap);
  
  List<StorePosConfig> getConfigBySourceCode(StorePosConfig paramStorePosConfig);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\StorePosConfigDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */