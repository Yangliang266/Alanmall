 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.merchant.dao.AppPosConfigDao;
 import com.itcrazy.alanmall.merchant.dto.AppPosConfigDto;
 import com.itcrazy.alanmall.merchant.manager.AppPosConfigManager;
 import com.itcrazy.alanmall.merchant.model.AppPosConfig;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.Cacheable;

 @Slf4j
 @Service
 public class AppPosConfigManagerImpl
   implements AppPosConfigManager {
   @Autowired
   private AppPosConfigDao appPosConfigDao;

   public AppPosConfig add(AppPosConfig appPosConfig) {
/* 19 */     if (this.appPosConfigDao.save(appPosConfig) > 0) {
/* 20 */       return appPosConfig;
     }
/* 22 */     return null;
   }


   public AppPosConfig getAppPosConfigByDto(AppPosConfigDto appPosConfigDto) {
/* 27 */     return this.appPosConfigDao.getAppPosConfigByDto(appPosConfigDto);
   }



   @CacheEvict(value = {"dataCache"}, key = "(\"AppPosConfigManager.get\").concat(#appPosConfig.getId())", condition = "#appPosConfig.getId()>0L")
   public int update(AppPosConfig appPosConfig) {
/* 34 */     return this.appPosConfigDao.update(appPosConfig);
   }


   @CacheEvict(value = {"dataCache"}, key = "(\"AppPosConfigManager.get\").concat(#appPosConfig.getId())")
   public int remove(AppPosConfig appPosConfig) {
/* 40 */     return this.appPosConfigDao.remove(appPosConfig);
   }


   @Cacheable(value = {"dataCache"}, key = "(\"AppPosConfigManager.get\").concat(#id)")
   public AppPosConfig get(Long id) {
/* 46 */     return (AppPosConfig)this.appPosConfigDao.get(id);
   }


   public List<AppPosConfig> getPageList(AppPosConfigDto appPosConfigDto) {
/* 51 */     return this.appPosConfigDao.getPageList(appPosConfigDto);
   }


   public Integer getPageTotal(AppPosConfigDto appPosConfigDto) {
/* 56 */     return this.appPosConfigDao.getPageTotal(appPosConfigDto);
   }

   public void setAppPosConfigDao(AppPosConfigDao appPosConfigDao) {
/* 60 */     this.appPosConfigDao = appPosConfigDao;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\AppPosConfigManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */