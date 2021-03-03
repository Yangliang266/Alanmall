 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.merchant.dao.BrandDfireConfigDao;
 import com.itcrazy.alanmall.merchant.manager.BrandDfireConfigManager;
 import com.itcrazy.alanmall.merchant.model.BrandDfireConfig;
 import java.util.HashMap;
 import java.util.Map;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.Cacheable;

 @Slf4j
 @Service
 public class BrandDfireConfigManagerImpl
   implements BrandDfireConfigManager {
   @Autowired
   private BrandDfireConfigDao brandDfireConfigDao;

   @Cacheable(value = {"dataCache"}, key = "(\"BrandDfireConfigManager.getBrandDfireConfigByBrandId\").concat(#brandId)", condition = "#brandId>0L")
   public BrandDfireConfig getBrandDfireConfigByBrandId(Long brandId) {
/* 20 */     return this.brandDfireConfigDao.getBrandDfireConfigByBrandId(brandId);
   }









   @CacheEvict(value = {"dataCache"}, key = "(\"BrandDfireConfigManager.getBrandDfireConfigByBrandId\").concat(#brandId)", condition = "#brandId>0L")
   public int deleteConfigByBrandId(Long brandId, Long updateId) {
/* 33 */     Map<String, Object> param = new HashMap<>();
/* 34 */     param.put("brandId", brandId);
/* 35 */     param.put("updateId", updateId);


/* 38 */     return this.brandDfireConfigDao.deleteByBrandId(param);
   }


   public BrandDfireConfig insertBrandDfireConfig(BrandDfireConfig brandDfireConfig) {
/* 43 */     this.brandDfireConfigDao.save(brandDfireConfig);
/* 44 */     return brandDfireConfig;
   }


   @CacheEvict(value = {"dataCache"}, key = "(\"BrandDfireConfigManager.getBrandDfireConfigByBrandId\").concat(#brandDfireConfig.getBrandId())", condition = "#brandDfireConfig.getBrandId()>0L")
   public void updateByBrandId(BrandDfireConfig brandDfireConfig) {
/* 50 */     this.brandDfireConfigDao.updateByBrandId(brandDfireConfig);
   }



   public BrandDfireConfig getBrandDfireConfigByChainEntityId(String chainEntityId, String plateEntityId) {
/* 56 */     Map<String, Object> param = new HashMap<>();
/* 57 */     param.put("chainEntityId", chainEntityId);
/* 58 */     param.put("plateEntityId", plateEntityId);

/* 60 */     return this.brandDfireConfigDao.getBrandDfireConfigByChainEntityId(param);
   }

   public void setBrandDfireConfigDao(BrandDfireConfigDao brandDfireConfigDao) {
/* 64 */     this.brandDfireConfigDao = brandDfireConfigDao;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\BrandDfireConfigManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */