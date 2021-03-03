 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.merchant.dao.FacilityInfoChgDao;
 import com.itcrazy.alanmall.merchant.dto.FacilityInfoChgDto;
 import com.itcrazy.alanmall.merchant.manager.FacilityInfoChgManager;
 import com.itcrazy.alanmall.merchant.model.FacilityInfoChg;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 @Slf4j
 @org.apache.dubbo.config.annotation.Service
 @Service("facilityInfoChgService")
 public class FacilityInfoChgManagerImpl
   implements FacilityInfoChgManager
 {
   @Autowired
   private FacilityInfoChgDao facilityInfoChgDao;

   public List<FacilityInfoChg> getPageList(FacilityInfoChgDto facilityInfoChgDto) {
/* 23 */     List<FacilityInfoChg> facilityInfoChgList = this.facilityInfoChgDao.getPageList(facilityInfoChgDto);
/* 24 */     if (facilityInfoChgList != null && facilityInfoChgList.size() > 0)
     {

/* 27 */       return facilityInfoChgList;
     }

/* 30 */     return null;
   }



   public Integer getPageTotal(FacilityInfoChgDto facilityInfoChgDto) {
/* 36 */     return this.facilityInfoChgDao.getPageTotal(facilityInfoChgDto);
   }



   @Cacheable(value = {"dataCache"}, key = "(\"facilityInfoChgManager\").concat(#id)", condition = "#id>0L")
   public FacilityInfoChg getFacilityInfoChgById(Long id) {
/* 43 */     return (FacilityInfoChg)this.facilityInfoChgDao.get(id);
   }



   public FacilityInfoChg addFacilityInfoChg(FacilityInfoChg facilityInfoChg) {
/* 49 */     this.facilityInfoChgDao.save(facilityInfoChg);
/* 50 */     return facilityInfoChg;
   }



   @CacheEvict(value = {"dataCache"}, key = "(\"facilityInfoManager\").concat(#facilityInfoChg.getId())")
   public int updateFacilityInfoChg(FacilityInfoChg facilityInfoChg) {
/* 57 */     return this.facilityInfoChgDao.update(facilityInfoChg);
   }



   @CacheEvict(value = {"dataCache"}, key = "(\"facilityInfoManager\").concat(#facilityInfoChg.getId())")
   public int removeFacilityInfoChg(FacilityInfoChg facilityInfoChg) {
/* 64 */     return this.facilityInfoChgDao.remove(facilityInfoChg);
   }







   public FacilityInfoChgDao getFacilityInfoChgDao() {
/* 74 */     return this.facilityInfoChgDao;
   }

   public void setFacilityInfoChgDao(FacilityInfoChgDao facilityInfoChgDao) {
/* 78 */     this.facilityInfoChgDao = facilityInfoChgDao;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\FacilityInfoChgManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */