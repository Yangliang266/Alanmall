 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.merchant.dao.AgeClassDao;
 import com.itcrazy.alanmall.merchant.manager.AgeClassManager;
 import com.itcrazy.alanmall.merchant.model.AgeClass;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.Cacheable;

 @Slf4j
 @Service
 public class AgeClassManagerImpl
   implements AgeClassManager
 {
   @Autowired
   private AgeClassDao ageClassDao;

   @Cacheable(value = {"dataCache"}, key = "(\"ageClassManager.getAgeClassList\")")
   public List<AgeClass> getAgeClassList() {
/* 18 */     return this.ageClassDao.getAgeClassList();
   }

   public void setAgeClassDao(AgeClassDao ageClassDao) {
/* 22 */     this.ageClassDao = ageClassDao;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\AgeClassManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */