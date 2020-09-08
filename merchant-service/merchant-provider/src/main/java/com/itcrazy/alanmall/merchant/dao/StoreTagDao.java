package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.model.StoreTag;
import org.springframework.stereotype.Component;

@Component
public interface StoreTagDao extends BaseDao<StoreTag, Long> {
  StoreTag getStoreTagByStoreId(Long paramLong);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\StoreTagDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */