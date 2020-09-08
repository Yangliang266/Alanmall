 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.merchant.dao.CuisineClassDao;
 import com.itcrazy.alanmall.merchant.manager.CuisineClassManager;
 import com.itcrazy.alanmall.merchant.model.CuisineClass;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.Cacheable;

 @Slf4j
 @Service
 public class CuisineClassManagerImpl
   implements CuisineClassManager
 {
   @Autowired
   private CuisineClassDao cuisineClassDao;

   @Cacheable(value = {"dataCache"}, key = "(\"CuisineClassManager.getCuisineClassList\").concat(#type)")
   public List<CuisineClass> getCuisineClassList(int type) {
/* 20 */     return this.cuisineClassDao.getCuisineClassList(type);
   }

   @Cacheable(value = {"dataCache"}, key = "(\"CuisineClassManager.getCuisineClassIdNameMap\").concat(#type)")
   public Map<Long, String> getCuisineClassIdNameMap(int type) {
/* 25 */     List<CuisineClass> ccList = getCuisineClassList(type);
/* 26 */     Map<Long, String> idNameMap = new HashMap<>();
/* 27 */     for (CuisineClass cc : ccList) {
/* 28 */       idNameMap.put(cc.getId(), cc.getCuisineClassName());
     }
/* 30 */     return idNameMap;
   }

   public CuisineClassDao getCuisineClassDao() {
/* 34 */     return this.cuisineClassDao;
   }

   public void setCuisineClassDao(CuisineClassDao cuisineClassDao) {
/* 38 */     this.cuisineClassDao = cuisineClassDao;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\CuisineClassManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */