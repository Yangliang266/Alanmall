 package com.itcrazy.alanmall.user.manager.impl;

 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.user.carddto.CompanyBusinessDto;
 import com.itcrazy.alanmall.user.dao.CompanyBusinessDao;
 import com.itcrazy.alanmall.user.model.CompanyBusiness;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import com.itcrazy.alanmall.user.manager.CompanyBusinessManager;

 import java.util.List;


// @Service(protocol = {"dubbo"}, version = "1.0.0", timeout = 10000)
@Service
 public class CompanyBusinessManagerImpl
   implements CompanyBusinessManager
 {
   @Autowired
   private CompanyBusinessDao companyBusinessDao;

   public CompanyBusiness addCompanyBusiness(CompanyBusiness companyBusiness) {
/* 23 */     this.companyBusinessDao.save(companyBusiness);
/* 24 */     return companyBusiness;
   }



   public List<CompanyBusiness> getCompanyBusinessListByCompanyId(Long companyId) {
/* 30 */     if (companyId == null) {
/* 31 */       return null;
     }
/* 33 */     CompanyBusinessDto dto = new CompanyBusinessDto();
/* 34 */     dto.setCompanyId(companyId);
/* 35 */     return this.companyBusinessDao.getPageList(dto);
   }

   public Integer removeCompanyBusiness(Long companyId, Long updateId) {
/* 39 */     CompanyBusiness cb = new CompanyBusiness();
/* 40 */     cb.setCompanyId(companyId);
/* 41 */     cb.setUpdateId(updateId);
/* 42 */     return Integer.valueOf(this.companyBusinessDao.remove(cb));
   }

   public Boolean isSupportBusinessByCompanyId(Long companyId, Long businessId) {
/* 46 */     if (companyId == null || businessId == null) {
/* 47 */       return Boolean.valueOf(false);
     }
/* 49 */     CompanyBusinessDto dto = new CompanyBusinessDto();
/* 50 */     dto.setCompanyId(companyId);
/* 51 */     dto.setBusinessId(businessId);
/* 52 */     Integer t = this.companyBusinessDao.getPageTotal(dto);
/* 53 */     if (t.intValue() > 0) {
/* 54 */       return Boolean.valueOf(true);
     }
/* 56 */     return Boolean.valueOf(false);
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meish\\user\manager\impl\CompanyBusinessManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */