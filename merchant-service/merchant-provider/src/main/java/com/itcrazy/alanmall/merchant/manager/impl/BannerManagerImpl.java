 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.merchant.dao.BannerDao;
 import com.itcrazy.alanmall.merchant.dto.BannerDto;
 import com.itcrazy.alanmall.merchant.manager.BannerManager;
 import com.itcrazy.alanmall.merchant.model.Banner;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.Cacheable;

 @Slf4j
 @Service
 public class BannerManagerImpl
   implements BannerManager
 {
   @Autowired
   private BannerDao bannerDao;

   public Banner addBanner(Banner banner) {
/* 25 */     this.bannerDao.save(banner);
/* 26 */     return banner;
   }


   @Cacheable(value = {"dataCache"}, key = "(\"BannerManager.getBannerById\").concat(#id)", condition = "#id>0L")
   public Banner getBannerById(Long id) {
/* 32 */     return (Banner)this.bannerDao.get(id);
   }


   @CacheEvict(value = {"dataCache"}, key = "(\"BannerManager.getBannerById\").concat(#banner.getId())", condition = "#banner.getId()>0L")
   public int updateBanner(Banner banner) {
/* 38 */     return this.bannerDao.update(banner);
   }


   public List<Banner> getPageList(BannerDto bannerDto) {
/* 43 */     return this.bannerDao.getPageList(bannerDto);
   }


   public int getPageTotal(BannerDto bannerDto) {
/* 48 */     return this.bannerDao.getPageTotal(bannerDto);
   }

   public void setBannerDao(BannerDao bannerDao) {
/* 52 */     this.bannerDao = bannerDao;
   }


   @CacheEvict(value = {"dataCache"}, key = "(\"BannerManager.getBannerById\").concat(#bannerId))", condition = "#bannerId>0L")
   public int deleteBannerById(Long bannerId, Long updateId) {
/* 58 */     Banner banner = new Banner();
/* 59 */     banner.setId(bannerId);
/* 60 */     banner.setUpdateId(updateId);
/* 61 */     return this.bannerDao.remove(banner);
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\BannerManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */