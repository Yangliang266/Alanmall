 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.common.client.alipay.model.CompanyAlipay;
 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.merchant.dao.CompanyAlipayDao;
 import com.itcrazy.alanmall.merchant.dto.CompanyAlipayDto;
 import com.itcrazy.alanmall.merchant.manager.CompanyAlipayManager;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.Cacheable;

 @Slf4j
 @Service
 public class CompanyAlipayManagerImpl implements CompanyAlipayManager {
   @Autowired
   private CompanyAlipayDao companyAlipayDao;

   public void setCompanyAlipayDao(CompanyAlipayDao companyAlipayDao) {
/*  18 */     this.companyAlipayDao = companyAlipayDao;
   }





   public CompanyAlipay add(CompanyAlipay model) {
/*  26 */     this.companyAlipayDao.save(model);
/*  27 */     return model;
   }





   @Cacheable(value = {"dataCache"}, key = "(\"companyAlipayManager.getByBrandId\").concat(#brandId)", condition = "#brandId>0L")
   public CompanyAlipay getByBrandId(Long brandId) {
/*  36 */     if (brandId == null) {
/*  37 */       return null;
     }
/*  39 */     CompanyAlipayDto dto = new CompanyAlipayDto();
/*  40 */     dto.setBrandId(brandId);
/*  41 */     List<CompanyAlipay> list = this.companyAlipayDao.getPageList(dto);
/*  42 */     if (list.isEmpty())
/*  43 */       return null; 
/*  44 */     return list.get(0);
   }





   @CacheEvict(value = {"dataCache"}, key = "(\"companyAlipayManager\").concat(#model.getId())")
   public int update(CompanyAlipay model) {
/*  53 */     return this.companyAlipayDao.update(model);
   }





   @CacheEvict(value = {"dataCache"}, key = "(\"companyAlipayManager\").concat(#model.getId())", condition = "#model.getId()>0L")
   public int remove(CompanyAlipay model) {
/*  62 */     return this.companyAlipayDao.remove(model);
   }





   @Cacheable(value = {"dataCache"}, key = "(\"companyAlipayManager\").concat(#id)", condition = "#id>0L")
   public CompanyAlipay getById(Long id) {
/*  71 */     return (CompanyAlipay)this.companyAlipayDao.get(id);
   }





   public List<CompanyAlipay> getPageList(CompanyAlipayDto dto) {
/*  79 */     return this.companyAlipayDao.getPageList(dto);
   }





   public Integer getPageTotal(CompanyAlipayDto dto) {
/*  87 */     return this.companyAlipayDao.getPageTotal(dto);
   }





   public CompanyAlipay getByStoreId(Long storeId) {
/*  95 */     if (storeId == null) {
/*  96 */       return null;
     }
/*  98 */     CompanyAlipayDto dto = new CompanyAlipayDto();
/*  99 */     dto.setStoreId(storeId);
/* 100 */     List<CompanyAlipay> list = this.companyAlipayDao.getPageList(dto);
/* 101 */     if (list.isEmpty())
/* 102 */       return null; 
/* 103 */     return list.get(0);
   }


   public int deleteCompanyAlipayConfig(List<CompanyAlipay> list) {
/* 108 */     return this.companyAlipayDao.deleteCompanyAlipayConfig(list);
   }


   public void saveBatch(List<CompanyAlipay> list) {
/* 113 */     this.companyAlipayDao.saveBatch(list);
   }


   public void deleteByAppId(CompanyAlipay companyAlipay) {
/* 118 */     this.companyAlipayDao.deleteByAppId(companyAlipay);
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\CompanyAlipayManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */