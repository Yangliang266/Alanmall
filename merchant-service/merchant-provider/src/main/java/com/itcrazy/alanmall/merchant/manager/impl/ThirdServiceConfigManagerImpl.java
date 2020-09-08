 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.common.client.cache.DataCache;
 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.merchant.dao.ThirdServiceConfigDao;
 import com.itcrazy.alanmall.merchant.manager.ThirdServiceConfigManager;
 import com.itcrazy.alanmall.merchant.model.ThirdServiceConfig;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.Cacheable;

 @Slf4j
 @Service
 public class ThirdServiceConfigManagerImpl implements ThirdServiceConfigManager {
   @Autowired
   private ThirdServiceConfigDao storePosConfigDao;

   public void setThirdServiceConfigDao(ThirdServiceConfigDao storePosConfigDao) {
/* 18 */     this.storePosConfigDao = storePosConfigDao;
   }


   @Cacheable(value = {"dataCache"}, key = "(\"ThirdServiceConfigManager.getById\").concat(#id)", condition = "#id>0L")
   public ThirdServiceConfig getById(Long id) {
/* 24 */     return (ThirdServiceConfig)this.storePosConfigDao.get(id);
   }


   @Cacheable(value = {"dataCache"}, key = "(\"ThirdServiceConfigManager.getListByStoreId\").concat(#storeId)", condition = "#storeId>0L")
   public List<ThirdServiceConfig> getListByStoreId(Long storeId) {
/* 30 */     return this.storePosConfigDao.getListByStoreId(storeId);
   }


   @Cacheable(value = {"dataCache"}, key = "(\"ThirdServiceConfigManager.getListByBrandId\").concat(#brandId)", condition = "#brandId>0L")
   public List<ThirdServiceConfig> getListByBrandId(Long brandId) {
/* 36 */     return this.storePosConfigDao.getListByBrandId(brandId);
   }


   public ThirdServiceConfig add(ThirdServiceConfig model) {
/* 41 */     this.storePosConfigDao.save(model);

     try {
/* 44 */       DataCache.remove("ThirdServiceConfigManager.getListByBrandId" + model.getBrandId());
/* 45 */       if (model.getStoreId() != null) {
/* 46 */         DataCache.remove("ThirdServiceConfigManager.getListByStoreId" + model.getStoreId());
       }
/* 48 */     } catch (Exception exception) {}

/* 50 */     return model;
   }


   @CacheEvict(value = {"dataCache"}, key = "(\"ThirdServiceConfigManager.getById\").concat(#model.getId())", condition = "#model.getId()>0L")
   public int update(ThirdServiceConfig model) {
     try {
/* 57 */       DataCache.remove("ThirdServiceConfigManager.getListByBrandId" + model.getBrandId());
/* 58 */       if (model.getStoreId() != null) {
/* 59 */         DataCache.remove("ThirdServiceConfigManager.getListByStoreId" + model.getStoreId());
       }
/* 61 */     } catch (Exception exception) {}

/* 63 */     return this.storePosConfigDao.update(model);
   }


   @CacheEvict(value = {"dataCache"}, key = "(\"ThirdServiceConfigManager.getById\").concat(#id)", condition = "#id>0L")
   public int deleteById(Long id, Long updateId) {
/* 69 */     ThirdServiceConfig model = (ThirdServiceConfig)this.storePosConfigDao.get(id);
/* 70 */     if (model != null) {
       try {
/* 72 */         DataCache.remove("ThirdServiceConfigManager.getListByBrandId" + model.getBrandId());
/* 73 */         if (model.getStoreId() != null) {
/* 74 */           DataCache.remove("ThirdServiceConfigManager.getListByStoreId" + model.getStoreId());
         }
/* 76 */       } catch (Exception exception) {}

/* 78 */       return this.storePosConfigDao.deleteById(id, updateId);
     }

/* 81 */     return 0;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\ThirdServiceConfigManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */