 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.merchant.dao.BrandAgesDao;
 import com.itcrazy.alanmall.merchant.manager.BrandAgesManager;
 import com.itcrazy.alanmall.merchant.model.BrandAges;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.Cacheable;

 @Slf4j
 @Service
 public class BrandAgesManagerImpl
   implements BrandAgesManager {
   @Autowired
   private BrandAgesDao brandAgesDao;

   @Cacheable(value = {"dataCache"}, key = "(\"BrandAgeManager.getBrandAgesListByBrandId\").concat(#brandId)", condition = "#brandId>0L")
   public List<BrandAges> getBrandAgesListByBrandId(Long brandId) {
/* 19 */     return this.brandAgesDao.getBrandAgesListByBrandId(brandId);
   }


   public BrandAges addBrandAge(BrandAges brandAges) {
/* 24 */     this.brandAgesDao.save(brandAges);
/* 25 */     return brandAges;
   }


   @CacheEvict(value = {"dataCache"}, key = "(\"BrandAgeManager.getBrandAgesListByBrandId\").concat(#brandId)", condition = "#brandId>0L")
   public int removeBrandAgesByBrandId(Long brandId) {
/* 31 */     return this.brandAgesDao.removeBrandAgesByBrandId(brandId);
   }

   public void setBrandAgesDao(BrandAgesDao brandAgesDao) {
/* 35 */     this.brandAgesDao = brandAgesDao;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\BrandAgesManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */