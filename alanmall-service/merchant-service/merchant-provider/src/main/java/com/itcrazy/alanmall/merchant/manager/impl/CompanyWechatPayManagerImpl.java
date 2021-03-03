 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.merchant.dao.CompanyWechatPayDao;
 import com.itcrazy.alanmall.merchant.dto.CompanyWechatPayDto;
 import com.itcrazy.alanmall.merchant.manager.CompanyWechatPayManager;
 import com.itcrazy.alanmall.merchant.model.CompanyWechatPay;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.Cacheable;

 @Slf4j
 @Service
 public class CompanyWechatPayManagerImpl implements CompanyWechatPayManager {
   @Autowired
   private CompanyWechatPayDao companyWechatPayDao;

   public CompanyWechatPay addCompanyWechatPay(CompanyWechatPay companyWechatPay) {
/* 18 */     this.companyWechatPayDao.save(companyWechatPay);
/* 19 */     return companyWechatPay;
   }

   @Cacheable(value = {"dataCache"}, key = "(\"CompanyWechatPayManager.getCompanyWechatPayByWechatConfig\").concat(#wechatConfigId)", condition = "#wechatConfigId>0L")
   @Deprecated
   public CompanyWechatPay getCompanyWechatPayByWechatConfig(Long wechatConfigId) {
/* 25 */     if (wechatConfigId == null) {
/* 26 */       return null;
     }

/* 29 */     CompanyWechatPayDto dto = new CompanyWechatPayDto();
/* 30 */     dto.setWechatConfigId(wechatConfigId);
/* 31 */     List<CompanyWechatPay> cwpList = this.companyWechatPayDao.getPageList(dto);
/* 32 */     if (cwpList == null || cwpList.size() != 1) {
/* 33 */       return null;
     }
/* 35 */     return cwpList.get(0);
   }


   @Deprecated
   public CompanyWechatPay getCompanyWechatPayByMchId(Long mchId) {
/* 41 */     if (mchId == null) {
/* 42 */       return null;
     }
/* 44 */     CompanyWechatPayDto dto = new CompanyWechatPayDto();
/* 45 */     dto.setMchId(mchId);
/* 46 */     List<CompanyWechatPay> cwpList = this.companyWechatPayDao.getPageList(dto);
/* 47 */     if (cwpList == null || cwpList.size() != 1) {
/* 48 */       return null;
     }
/* 50 */     return cwpList.get(0);
   }


   @CacheEvict(value = {"dataCache"}, key = "(\"CompanyWechatPayManager.getCompanyWechatPayByWechatConfig\").concat(#companyWechatPay.getWechatConfigId())")
   public int remove(CompanyWechatPay companyWechatPay) {
/* 56 */     return this.companyWechatPayDao.remove(companyWechatPay);
   }



   public List<CompanyWechatPay> getPageList(CompanyWechatPayDto companyWechatPayDto) {
/* 62 */     return this.companyWechatPayDao.getPageList(companyWechatPayDto);
   }


   @CacheEvict(value = {"dataCache"}, key = "(\"CompanyWechatPayManager.getCompanyWechatPayByWechatConfig\").concat(#companyWechatPayDto.getWechatConfigId())")
   public int deleteCompanyWechatPay(CompanyWechatPayDto companyWechatPayDto) {
/* 68 */     return this.companyWechatPayDao.deleteCompanyWechatPay(companyWechatPayDto);
   }


   public void setCompanyWechatPayDao(CompanyWechatPayDao companyWechatPayDao) {
/* 73 */     this.companyWechatPayDao = companyWechatPayDao;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\CompanyWechatPayManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */