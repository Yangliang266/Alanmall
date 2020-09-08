 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.merchant.dao.BrandCallDao;
 import com.itcrazy.alanmall.merchant.dto.BrandCallDto;
 import com.itcrazy.alanmall.merchant.manager.BrandCallManager;
 import com.itcrazy.alanmall.merchant.model.BrandCall;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;

 @Slf4j
 @Service
 public class BrandCallManagerImpl
   implements BrandCallManager {
   @Autowired
   private BrandCallDao brandCallDao;

   public List<BrandCall> getPageList(BrandCallDto dto) {
/* 17 */     return this.brandCallDao.getPageList(dto);
   }


   public int save(BrandCall call) {
/* 22 */     return this.brandCallDao.save(call);
   }


   public int update(BrandCall call) {
/* 27 */     return this.brandCallDao.update(call);
   }

   public BrandCallDao getBrandCallDao() {
/* 31 */     return this.brandCallDao;
   }

   public void setBrandCallDao(BrandCallDao brandCallDao) {
/* 35 */     this.brandCallDao = brandCallDao;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\BrandCallManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */