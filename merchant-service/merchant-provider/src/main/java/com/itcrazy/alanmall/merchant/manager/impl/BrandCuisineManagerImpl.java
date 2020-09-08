 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.merchant.dao.BrandCuisineDao;
 import com.itcrazy.alanmall.merchant.manager.BrandCuisineManager;
 import com.itcrazy.alanmall.merchant.model.BrandCuisine;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;

 @Slf4j
 @Service
 public class BrandCuisineManagerImpl implements BrandCuisineManager {
   @Autowired
   private BrandCuisineDao brandCuisineDao;

   public void setBrandCuisineDao(BrandCuisineDao brandCuisineDao) {
/* 15 */     this.brandCuisineDao = brandCuisineDao;
   }



   public List<BrandCuisine> getCuisineListByBrandId(Long brandId) {
/* 21 */     return this.brandCuisineDao.getCuisineListByBrandId(brandId);
   }




   public List<BrandCuisine> getCuisineClassListByBrandId(Long brandId, Integer type) {
/* 28 */     BrandCuisine brandCuisine = new BrandCuisine();
/* 29 */     brandCuisine.setBrandId(brandId);
/* 30 */     brandCuisine.setType(type);

/* 32 */     return this.brandCuisineDao.getCuisineClassListByBrandId(brandCuisine);
   }


   public BrandCuisine addBrandCuisine(BrandCuisine brandCuisine) {
/* 37 */     this.brandCuisineDao.save(brandCuisine);
/* 38 */     return brandCuisine;
   }



   public int removeBrandCuisineByBrandId(Long brandId, Integer type) {
/* 44 */     BrandCuisine brandCuisine = new BrandCuisine();
/* 45 */     brandCuisine.setBrandId(brandId);
/* 46 */     brandCuisine.setType(type);
/* 47 */     return this.brandCuisineDao.removeBrandCuisineByBrandId(brandCuisine);
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\BrandCuisineManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */