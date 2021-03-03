 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.merchant.dao.PrepaidCardConfigDao;
 import com.itcrazy.alanmall.merchant.dto.PrepaidCardConfigDto;
 import com.itcrazy.alanmall.merchant.manager.PrepaidCardConfigManager;
 import com.itcrazy.alanmall.merchant.model.PrepaidCardConfig;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;

 @Slf4j
 @Service
 public class PrepaidCardConfigManagerImpl
   implements PrepaidCardConfigManager {
   @Autowired
   private PrepaidCardConfigDao prepaidCardConfigDao;

   public PrepaidCardConfig getPrepaidCardConfigById(Long prepaidCardConfigId) {
/* 17 */     return (PrepaidCardConfig)this.prepaidCardConfigDao.get(prepaidCardConfigId);
   }



   public List<PrepaidCardConfig> getPageList(PrepaidCardConfigDto prepaidCardConfigDto) {
/* 23 */     return this.prepaidCardConfigDao.getPageList(prepaidCardConfigDto);
   }


   public int getPageTotal(PrepaidCardConfigDto prepaidCardConfigDto) {
/* 28 */     return this.prepaidCardConfigDao.getPageTotal(prepaidCardConfigDto);
   }



   public PrepaidCardConfig insertPrepaidCardConfig(PrepaidCardConfig prepaidCardConfig) {
/* 34 */     this.prepaidCardConfigDao.save(prepaidCardConfig);
/* 35 */     return prepaidCardConfig;
   }


   public int deletePrepaidCardConfig(PrepaidCardConfig prepaidCardConfig) {
/* 40 */     return this.prepaidCardConfigDao.remove(prepaidCardConfig);
   }


   public int updatePrepaidCardConfig(PrepaidCardConfig prepaidCardConfig) {
/* 45 */     return this.prepaidCardConfigDao.update(prepaidCardConfig);
   }

   public void setPrepaidCardConfigDao(PrepaidCardConfigDao prepaidCardConfigDao) {
/* 49 */     this.prepaidCardConfigDao = prepaidCardConfigDao;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\PrepaidCardConfigManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */