 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.merchant.dao.BrandSmsConfigDao;
 import com.itcrazy.alanmall.merchant.dto.BrandSmsConfigDto;
 import com.itcrazy.alanmall.merchant.manager.BrandSmsConfigManager;
 import com.itcrazy.alanmall.merchant.model.BrandSmsConfig;
 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.Cacheable;


 @Slf4j
 @Service
 public class BrandSmsConfigManagerImpl
   implements BrandSmsConfigManager
 {
   @Autowired
   private BrandSmsConfigDao brandSmsConfigDao;

   @Cacheable(value = {"dataCache"}, key = "(\"BrandSmsConfigManager.getByBrandId\").concat(#brandId)", condition = "#brandId>0L")
   public BrandSmsConfig getByBrandId(Long brandId) {
/* 22 */     BrandSmsConfigDto dto = new BrandSmsConfigDto();
/* 23 */     dto.setBrandId(brandId);
/* 24 */     return this.brandSmsConfigDao.getByBrandDto(dto);
   }





   public BrandSmsConfig getByBrandDto(BrandSmsConfigDto dto) {
/* 32 */     return this.brandSmsConfigDao.getByBrandDto(dto);
   }





   public BrandSmsConfig addBrandSmsConfig(BrandSmsConfig brandSmsConfig) {
/* 40 */     this.brandSmsConfigDao.save(brandSmsConfig);
/* 41 */     return brandSmsConfig;
   }





   @CacheEvict(value = {"dataCache"}, key = "(\"BrandSmsConfigManager.getByBrandId\").concat(#brandSmsConfig.getBrandId())", condition = "#brandSmsConfig.getBrandId()>0L")
   public int updateBrand(BrandSmsConfig brandSmsConfig) {
/* 50 */     return this.brandSmsConfigDao.update(brandSmsConfig);
   }





   @CacheEvict(value = {"dataCache"}, key = "(\"BrandSmsConfigManager.getByBrandId\").concat(#brandSmsConfig.getBrandId())", condition = "#brandSmsConfig.getBrandId()>0L")
   public int removeBrand(BrandSmsConfig brandSmsConfig) {
/* 59 */     return this.brandSmsConfigDao.remove(brandSmsConfig);
   }

   public void setBrandSmsConfigDao(BrandSmsConfigDao brandSmsConfigDao) {
/* 63 */     this.brandSmsConfigDao = brandSmsConfigDao;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\BrandSmsConfigManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */