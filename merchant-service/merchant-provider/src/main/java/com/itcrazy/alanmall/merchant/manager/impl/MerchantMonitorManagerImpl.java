 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.merchant.dao.MerchantMonitorDao;
 import com.itcrazy.alanmall.merchant.manager.MerchantMonitorManager;
 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;

 @Slf4j
 @Service
 public class MerchantMonitorManagerImpl
   implements MerchantMonitorManager
 {
   @Autowired
   private MerchantMonitorDao merchantMonitorDao;

   public Boolean isConnect() {
/* 15 */     return this.merchantMonitorDao.isConnect();
   }


   public Integer getStoreCount(Integer status) {
/* 20 */     return this.merchantMonitorDao.getStoreCount(status);
   }

   public void setMerchantMonitorDao(MerchantMonitorDao merchantMonitorDao) {
/* 24 */     this.merchantMonitorDao = merchantMonitorDao;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\MerchantMonitorManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */