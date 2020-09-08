 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.merchant.dao.FacilityInfoDao;
 import com.itcrazy.alanmall.merchant.dto.FacilityInfoDto;
 import com.itcrazy.alanmall.merchant.manager.FacilityInfoManager;
 import com.itcrazy.alanmall.merchant.model.FacilityInfo;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 @Service("facilityInfoService")
 @Slf4j
 @org.apache.dubbo.config.annotation.Service
 public class FacilityInfoManagerImpl
   implements FacilityInfoManager
 {
   @Autowired
   private FacilityInfoDao facilityInfoDao;

   public List<FacilityInfo> getPageList(FacilityInfoDto facilityInfoDto) {
/* 22 */     List<FacilityInfo> facilityInfoList = this.facilityInfoDao.getPageList(facilityInfoDto);
/* 23 */     if (facilityInfoList != null && facilityInfoList.size() > 0)
     {

/* 26 */       return facilityInfoList;
     }

/* 29 */     return null;
   }



   public Integer getPageTotal(FacilityInfoDto facilityInfoDto) {
/* 35 */     return this.facilityInfoDao.getPageTotal(facilityInfoDto);
   }



   @Cacheable(value = {"dataCache"}, key = "(\"facilityInfoManager\").concat(#id)", condition = "#id>0L")
   public FacilityInfo getFacilityInfoById(Long id) {
/* 42 */     return (FacilityInfo)this.facilityInfoDao.get(id);
   }



   public FacilityInfo getFacilityInfoByKey(String key) {
/* 48 */     return this.facilityInfoDao.getFacilityInfoByKey(key);
   }



   public FacilityInfo getFacilityInfoByDeviceNo(String deviceNo) {
/* 54 */     return this.facilityInfoDao.getFacilityInfoByDeviceNo(deviceNo);
   }



   public FacilityInfo addFacilityInfo(FacilityInfo facilityInfo) {
/* 60 */     this.facilityInfoDao.save(facilityInfo);
/* 61 */     return facilityInfo;
   }



   @CacheEvict(value = {"dataCache"}, key = "(\"facilityInfoManager\").concat(#facilityInfo.getId())")
   public int updateFacilityInfo(FacilityInfo facilityInfo) {
/* 68 */     return this.facilityInfoDao.update(facilityInfo);
   }



   @CacheEvict(value = {"dataCache"}, key = "(\"facilityInfoManager\").concat(#facilityInfo.getId())")
   public int removeFacilityInfo(FacilityInfo facilityInfo) {
/* 75 */     return this.facilityInfoDao.remove(facilityInfo);
   }








   public FacilityInfoDao getFacilityInfoDao() {
/* 86 */     return this.facilityInfoDao;
   }

   public void setFacilityInfoDao(FacilityInfoDao facilityInfoDao) {
/* 90 */     this.facilityInfoDao = facilityInfoDao;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\FacilityInfoManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */