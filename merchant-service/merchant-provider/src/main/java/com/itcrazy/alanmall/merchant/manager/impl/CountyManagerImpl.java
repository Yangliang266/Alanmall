 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.merchant.dao.CountyDao;
 import com.itcrazy.alanmall.merchant.manager.CountyManager;
 import com.itcrazy.alanmall.merchant.model.County;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.Cacheable;

 @Slf4j
 @Service
 public class CountyManagerImpl
   implements CountyManager
 {
   @Autowired
   private CountyDao countyDao;

   @Cacheable(value = {"dataCache"}, key = "(\"CountyManager.getCountyListById\").concat(#cityId)")
   public List<County> getCountyListById(Long cityId) {
/* 18 */     return this.countyDao.getCountyListById(cityId);
   }

   public void setCountyDao(CountyDao countyDao) {
/* 22 */     this.countyDao = countyDao;
   }


   @Cacheable(value = {"dataCache"}, key = "(\"CountyManager.getCountyByCode\").concat(#code)")
   public County getCountyByCode(String code) {
/* 28 */     return this.countyDao.getCountyByCode(code);
   }


   @Cacheable(value = {"dataCache"}, key = "(\"CountyManager.getCountyByName\").concat(#name)")
   public County getCountyByName(String name) {
/* 34 */     return this.countyDao.getCountyByName(name);
   }


   @Cacheable(value = {"dataCache"}, key = "(\"CountyManager.getCountyName\").concat(#countyId) ", condition = "#countyId>0L")
   public String getCountyName(Long countyId) {
/* 40 */     County c = (County)this.countyDao.get(countyId);
/* 41 */     if (c != null) {
/* 42 */       return c.getCountyCname();
     }
/* 44 */     return "";
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\CountyManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */