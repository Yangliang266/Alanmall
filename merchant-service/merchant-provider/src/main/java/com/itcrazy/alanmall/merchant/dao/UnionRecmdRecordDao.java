package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.model.UnionRecmdRecord;
import org.springframework.stereotype.Component;

@Component
public interface UnionRecmdRecordDao extends BaseDao<UnionRecmdRecord, Long> {
  UnionRecmdRecord getLastRecmd(UnionRecmdRecord paramUnionRecmdRecord);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\UnionRecmdRecordDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */