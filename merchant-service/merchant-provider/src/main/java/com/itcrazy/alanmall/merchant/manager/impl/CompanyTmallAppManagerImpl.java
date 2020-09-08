 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.merchant.dao.CompanyTmallAppDao;
 import com.itcrazy.alanmall.merchant.dto.CompanyTmallAppDto;
 import com.itcrazy.alanmall.merchant.manager.CompanyTmallAppManager;
 import com.itcrazy.alanmall.merchant.model.CompanyTmallApp;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.Cacheable;



 @Slf4j
 @Service
 public class CompanyTmallAppManagerImpl
   implements CompanyTmallAppManager
 {
   @Autowired
   private CompanyTmallAppDao companyTmallAppDao;

   @Cacheable(value = {"dataCache"}, key = "(\"CompanyTmallAppManager.getById\").concat(#id)", condition = "#id>0L")
   public CompanyTmallApp getById(Long id) {
/* 24 */     return (CompanyTmallApp)this.companyTmallAppDao.get(id);
   }


   @CacheEvict(value = {"dataCache"}, key = "(\"CompanyTmallAppManager.getById\").concat(#tmallApp.getId())")
   public void deleteById(CompanyTmallApp tmallApp) {
/* 30 */     this.companyTmallAppDao.deleteById(tmallApp);
   }


   public CompanyTmallApp addCompanyTmallApp(CompanyTmallApp tmallApp) {
/* 35 */     this.companyTmallAppDao.save(tmallApp);
/* 36 */     return tmallApp;
   }


   public CompanyTmallApp getCompanyTmallApp(CompanyTmallApp tmallApp) {
/* 41 */     return this.companyTmallAppDao.getCompanyTmallApp(tmallApp);
   }


   @CacheEvict(value = {"dataCache"}, key = "(\"CompanyTmallAppManager.getById\").concat(#tmallApp.getId())")
   public void updateCompanyTmallApp(CompanyTmallApp tmallApp) {
/* 47 */     this.companyTmallAppDao.update(tmallApp);
   }


   public List<CompanyTmallApp> getPageList(CompanyTmallAppDto tmallAppDto) {
/* 52 */     return this.companyTmallAppDao.getPageList(tmallAppDto);
   }


   public Integer getPageTotal(CompanyTmallAppDto tmallAppDto) {
/* 57 */     return this.companyTmallAppDao.getPageTotal(tmallAppDto);
   }


   public CompanyTmallApp getByAppkey(CompanyTmallApp tmallApp) {
/* 62 */     return this.companyTmallAppDao.getByAppkey(tmallApp);
   }


   public void setCompanyTmallAppDao(CompanyTmallAppDao companyTmallAppDao) {
/* 67 */     this.companyTmallAppDao = companyTmallAppDao;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\CompanyTmallAppManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */