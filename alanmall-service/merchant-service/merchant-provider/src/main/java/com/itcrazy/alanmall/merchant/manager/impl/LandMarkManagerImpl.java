 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.merchant.dao.LandMarkDao;
 import com.itcrazy.alanmall.merchant.manager.LandMarkManager;
 import com.itcrazy.alanmall.merchant.model.LandMark;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.Cacheable;

 @Slf4j
 @Service
 public class LandMarkManagerImpl
   implements LandMarkManager
 {
   @Autowired
   private LandMarkDao landMarkDao;

   @Cacheable(value = {"dataCache"}, key = "(\"LandMarkManager.getLandMarkListByCityId\").concat(#cityId)", condition = "#cityId>0")
   public List<LandMark> getLandMarkListByCityId(Long cityId) {
/* 18 */     return this.landMarkDao.getLandMarkListByCityId(cityId);
   }


   @Cacheable(value = {"dataCache"}, key = "(\"LandMarkManager.getLandMark\").concat(#id)", condition = "#id>0")
   public LandMark getLandMark(Long id) {
/* 24 */     return (LandMark)this.landMarkDao.get(id);
   }

   public void setLandMarkDao(LandMarkDao landMarkDao) {
/* 28 */     this.landMarkDao = landMarkDao;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\LandMarkManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */