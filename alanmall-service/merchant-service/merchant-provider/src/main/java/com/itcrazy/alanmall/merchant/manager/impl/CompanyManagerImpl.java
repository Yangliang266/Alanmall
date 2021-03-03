 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.merchant.dao.CompanyDao;
 import com.itcrazy.alanmall.merchant.dto.CompanyDto;
 import com.itcrazy.alanmall.merchant.manager.CompanyManager;
 import com.itcrazy.alanmall.merchant.model.Company;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.Cacheable;

 @Slf4j
 @Service
 public class CompanyManagerImpl
   implements CompanyManager {
   @Autowired
   private CompanyDao companyDao;

   @Cacheable(value = {"dataCache"}, key = "(\"CompanyManager.getCompanyById\").concat(#id)", condition = "#id>0L")
   public Company getCompanyById(Long id) {
/* 20 */     return (Company)this.companyDao.get(id);
   }

   public Company addCompany(Company company) {
/* 24 */     company.setId(null);
/* 25 */     this.companyDao.save(company);
/* 26 */     return company;
   }


   @CacheEvict(value = {"dataCache"}, key = "(\"CompanyManager.getCompanyById\").concat(#company.getId())")
   public void updateCompany(Company company) {
/* 32 */     this.companyDao.update(company);
   }


   public List<Company> getPageList(CompanyDto companyDto) {
/* 37 */     return this.companyDao.getPageList(companyDto);
   }

   public Integer getPageTotal(CompanyDto companyDto) {
/* 41 */     return this.companyDao.getPageTotal(companyDto);
   }

   public void setCompanyDao(CompanyDao companyDao) {
/* 45 */     this.companyDao = companyDao;
   }

   public Company getCompanyBySourceCode(Integer source, String sourceCode) {
/* 49 */     CompanyDto dto = new CompanyDto();
/* 50 */     dto.setSource(source);
/* 51 */     dto.setSourceCode(sourceCode);
/* 52 */     return this.companyDao.getCompanyByDto(dto);
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\CompanyManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */