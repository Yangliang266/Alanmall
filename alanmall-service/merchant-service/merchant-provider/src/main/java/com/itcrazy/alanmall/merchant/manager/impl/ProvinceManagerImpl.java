 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.merchant.dao.ProvinceDao;
 import com.itcrazy.alanmall.merchant.manager.ProvinceManager;
 import com.itcrazy.alanmall.merchant.model.Province;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.Cacheable;

 @Slf4j
 @Service
 public class ProvinceManagerImpl
   implements ProvinceManager
 {
   @Autowired
   private ProvinceDao provinceDao;

   @Cacheable(value = {"dataCache"}, key = "(\"ProvinceManagergetAllProvinceList\")")
   public List<Province> getAllProvinceList() {
/* 18 */     return this.provinceDao.getAll();
   }

   @Cacheable(value = {"dataCache"}, key = "(\"ProvinceManager\").concat(#provinceCode)")
   public Province getProvinceByCode(String provinceCode) {
/* 23 */     return this.provinceDao.getProvinceByCode(provinceCode);
   }

   public Province getProvinceByName(String name) {
/* 27 */     return this.provinceDao.getProvinceByName(name);
   }

   @Cacheable(value = {"dataCache"}, key = "(\"ProvinceManager.getProvinceById\").concat(#id)", condition = "#id>0L")
   public Province getProvinceById(Long id) {
/* 32 */     return (Province)this.provinceDao.get(id);
   }

   @Cacheable(value = {"dataCache"}, key = "(\"ProvinceManager\").concat(#provinceId)", condition = "#provinceId>0L")
   public String getProvinceName(Long provinceId) {
/* 37 */     Province p = (Province)this.provinceDao.get(provinceId);
/* 38 */     if (p != null) {
/* 39 */       return p.getProvinceCname();
     }
/* 41 */     return "";
   }







   public List<Province> getProvinceByWechatConfigId(Long wechatConfigId) {
/* 51 */     return this.provinceDao.getProvinceByWechatConfigId(wechatConfigId);
   }







   public List<Province> getProvinceForWangxiangyuan(String provinceIds) {
/* 61 */     return this.provinceDao.getProvinceForWangxiangyuan(provinceIds);
   }

   public void setProvinceDao(ProvinceDao provinceDao) {
/* 65 */     this.provinceDao = provinceDao;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\ProvinceManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */