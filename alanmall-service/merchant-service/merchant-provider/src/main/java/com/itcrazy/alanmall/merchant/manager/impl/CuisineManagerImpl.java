 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.merchant.dao.CuisineDao;
 import com.itcrazy.alanmall.merchant.manager.CuisineManager;
 import com.itcrazy.alanmall.merchant.model.Cuisine;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.Cacheable;

 @Slf4j
 @Service
 public class CuisineManagerImpl
   implements CuisineManager
 {
   @Autowired
   private CuisineDao cuisineDao;

   @Cacheable(value = {"dataCache"}, key = "(\"CuisineManager.getCuisineByParentId\").concat(#parentId)", condition = "#parentId>0")
   public List<Cuisine> getCuisineByParentId(Long parentId) {
/* 18 */     return this.cuisineDao.getCuisineByParentId(parentId);
   }

   public void setCuisineDao(CuisineDao cuisineDao) {
/* 22 */     this.cuisineDao = cuisineDao;
   }

   @Cacheable(value = {"dataCache"}, key = "(\"CuisineManager.getAllCuisineClassCuisine\")")
   public List<Cuisine> getAllCuisineClassCuisine() {
/* 27 */     return this.cuisineDao.getAllCuisineClassCuisine();
   }


   @Cacheable(value = {"dataCache"}, key = "(\"CuisineManager.getCuisineByCode\").concat(#code)")
   public Cuisine getCuisineByCode(String code) {
/* 33 */     return this.cuisineDao.getCuisineByCode(code);
   }

   @Cacheable(value = {"dataCache"}, key = "(\"CuisineManager.getCuisineById\").concat(#id)", condition = "#id>0")
   public Cuisine getCuisineById(Long id) {
/* 38 */     return (Cuisine)this.cuisineDao.get(id);
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\CuisineManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */