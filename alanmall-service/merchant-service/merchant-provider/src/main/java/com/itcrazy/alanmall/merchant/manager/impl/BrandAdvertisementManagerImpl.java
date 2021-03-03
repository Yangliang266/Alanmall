 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.merchant.dao.BrandAdvertisementDao;
 import com.itcrazy.alanmall.merchant.dto.BrandAdvertisementDto;
 import com.itcrazy.alanmall.merchant.manager.BrandAdvertisementManager;
 import com.itcrazy.alanmall.merchant.model.BrandAdvertisement;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.Cacheable;






 @Slf4j
 @Service
 public class BrandAdvertisementManagerImpl
   implements BrandAdvertisementManager
 {
   @Autowired
   private BrandAdvertisementDao brandAdvertisementDao;

   public BrandAdvertisement addBrandAdvertisement(BrandAdvertisement brandAdvertisement) {
/* 26 */     this.brandAdvertisementDao.save(brandAdvertisement);
/* 27 */     return brandAdvertisement;
   }


   @Cacheable(value = {"dataCache"}, key = "(\"BrandAdvertisementManager.getBrandAdvertisementById\").concat(#id)", condition = "#id>0L")
   public BrandAdvertisement getBrandAdvertisementById(Long id) {
/* 33 */     return (BrandAdvertisement)this.brandAdvertisementDao.get(id);
   }


   @CacheEvict(value = {"dataCache"}, key = "(\"BrandAdvertisementManager.getBrandAdvertisementById\").concat(#brandAdvertisement.getId())", condition = "#brandAdvertisement.getId()>0L")
   public int updateBrandAdvertisement(BrandAdvertisement brandAdvertisement) {
/* 39 */     return this.brandAdvertisementDao.update(brandAdvertisement);
   }


   @CacheEvict(value = {"dataCache"}, key = "(\"BrandAdvertisementManager.getBrandAdvertisementById\").concat(#brandAdvertisement.getId())", condition = "#brandAdvertisement.getId()>0L")
   public int deleteBrandAdvertisement(BrandAdvertisement brandAdvertisement) {
/* 45 */     return this.brandAdvertisementDao.remove(brandAdvertisement);
   }


   public List<BrandAdvertisement> getPageList(BrandAdvertisementDto dto) {
/* 50 */     return this.brandAdvertisementDao.getPageList(dto);
   }


   public Integer getPageTotal(BrandAdvertisementDto dto) {
/* 55 */     return this.brandAdvertisementDao.getPageTotal(dto);
   }



   public List<BrandAdvertisement> getList(BrandAdvertisement brandAdvertisement) {
/* 61 */     return this.brandAdvertisementDao.getList(brandAdvertisement);
   }

   public void setBrandAdvertisementDao(BrandAdvertisementDao brandAdvertisementDao) {
/* 65 */     this.brandAdvertisementDao = brandAdvertisementDao;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\BrandAdvertisementManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */