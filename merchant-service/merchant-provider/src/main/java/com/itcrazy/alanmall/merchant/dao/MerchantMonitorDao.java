package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.model.MerchantMonitor;
import org.springframework.stereotype.Component;

@Component
public interface MerchantMonitorDao extends BaseDao<MerchantMonitor, Long> {
  Boolean isConnect();
  
  Integer getStoreCount(Integer paramInteger);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\MerchantMonitorDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */