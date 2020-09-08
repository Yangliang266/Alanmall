 package com.itcrazy.alanmall.user.manager.impl;

 import java.util.List;

 import com.itcrazy.alanmall.user.dao.BusinessDao;
 import com.itcrazy.alanmall.user.manager.BusinessManager;
 import com.itcrazy.alanmall.user.model.Business;
 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.Cacheable;

 @Slf4j
 @Service
 public class BusinessManagerImpl
   implements BusinessManager
 {
   @Autowired
   private BusinessDao businessDao;

   @Cacheable(value = {"dataCache"}, key = "(\"BusinessManager.getBusinessById\").concat(#businessId)")
   public Business getBusinessById(Long businessId) {
/* 19 */     return (Business)this.businessDao.get(businessId);
   }
   public List<Business> getBusinessList() {
/* 22 */     return this.businessDao.getAll();
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meish\\user\manager\impl\BusinessManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */