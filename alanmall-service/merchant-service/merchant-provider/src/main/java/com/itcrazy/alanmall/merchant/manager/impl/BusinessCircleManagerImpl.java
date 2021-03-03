 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.merchant.dao.BusinessCircleDao;
 import com.itcrazy.alanmall.merchant.manager.BusinessCircleManager;
 import com.itcrazy.alanmall.merchant.model.BusinessCircle;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.Cacheable;

 @Slf4j
 @Service
 public class BusinessCircleManagerImpl
   implements BusinessCircleManager
 {
   @Autowired
   private BusinessCircleDao businessCircleDao;

   @Cacheable(value = {"dataCache"}, key = "(\"BusinessCircleManager.getBusinessCircleListByCityId\").concat(#cityId)", condition = "#cityId>0L")
   public List<BusinessCircle> getBusinessCircleListByCityId(Long cityId) {
/* 18 */     return this.businessCircleDao.getBusinessCircleListByCityId(cityId);
   }




   @Cacheable(value = {"dataCache"}, key = "(\"BusinessCircleManager.getBusinessCircleListByProvinceId\").concat(#provinceId)", condition = "#provinceId>0L")
   public List<BusinessCircle> getBusinessCircleListByProvinceId(Long provinceId) {
/* 26 */     return this.businessCircleDao.getBusinessCircleListByProvinceId(provinceId);
   }


   @Cacheable(value = {"dataCache"}, key = "(\"BusinessCircleManager.getBusinessCircle\").concat(#id)", condition = "#id>0")
   public BusinessCircle getBusinessCircle(Long id) {
/* 32 */     return (BusinessCircle)this.businessCircleDao.get(id);
   }

   public void setBusinessCircleDao(BusinessCircleDao businessCircleDao) {
/* 36 */     this.businessCircleDao = businessCircleDao;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\BusinessCircleManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */