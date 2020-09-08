 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.merchant.dao.UnionRecmdRecordDao;
 import com.itcrazy.alanmall.merchant.manager.UnionRecmdRecordManager;
 import com.itcrazy.alanmall.merchant.model.UnionRecmdRecord;
 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;

 @Slf4j
 @Service
 public class UnionRecmdRecordManagerImpl
   implements UnionRecmdRecordManager
 {
   @Autowired
   private UnionRecmdRecordDao unionRecmdRecordDao;

   public UnionRecmdRecord addUnionRecmdRecord(UnionRecmdRecord unionRecmdRecord) {
/* 22 */     this.unionRecmdRecordDao.save(unionRecmdRecord);
/* 23 */     return unionRecmdRecord;
   }


   public UnionRecmdRecord getLastRecmd(UnionRecmdRecord unionRecmdRecord) {
/* 28 */     return this.unionRecmdRecordDao.getLastRecmd(unionRecmdRecord);
   }

   public void setUnionRecmdRecordDao(UnionRecmdRecordDao unionRecmdRecordDao) {
/* 32 */     this.unionRecmdRecordDao = unionRecmdRecordDao;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\UnionRecmdRecordManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */