 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.common.client.cache.DataCache;
 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.merchant.dao.StoreDao;
 import com.itcrazy.alanmall.merchant.dto.StoreDto;
 import com.itcrazy.alanmall.merchant.manager.StoreManager;
 import com.itcrazy.alanmall.merchant.model.Store;
 import java.util.ArrayList;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.commons.lang.StringUtils;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.dao.DataAccessException;


 @Slf4j
 @Service
 public class StoreManagerImpl
   implements StoreManager
 {
   @Autowired
   private StoreDao storeDao;

   @Cacheable(value = {"dataCache"}, key = "(\"StoreManager.getStoreById\").concat(#id)", condition = "#id>0L")
   public Store getStoreById(Long id) {
/*  27 */     return (Store)this.storeDao.get(id);
   }

   @Cacheable(value = {"dataCache"}, key = "(\"StoreManager.getStoreBySourceCode\").concat(#source).concat(#sourceCode)")
   public Store getStoreBySourceCode(Integer source, String sourceCode) {
/*  32 */     StoreDto dto = new StoreDto();
/*  33 */     dto.setSource(source);
/*  34 */     dto.setSourceCode(sourceCode);
/*  35 */     return this.storeDao.getStoreByDto(dto);
   }


   public Store getStoreByName(String name) {
/*  40 */     StoreDto dto = new StoreDto();
/*  41 */     dto.setName(name);
/*  42 */     return this.storeDao.getStoreByDto(dto);
   }

   @CacheEvict(value = {"dataCache"}, key = "(\"StoreManager.getStoreById\").concat(#storeId)", condition = "#storeId>0L")
   public void deleteStore(Long storeId, Long managerId) {
/*  47 */     Store store = new Store();
/*  48 */     store.setId(storeId);
/*  49 */     store.setUpdateId(managerId);
/*  50 */     this.storeDao.remove(store);
   }



   public List<Long> getStoreProvinceIdList(StoreDto storeDto) {
/*  56 */     return this.storeDao.getStoreProvinceIdList(storeDto);
   }
   public Store addStore(Store store) {
/*  59 */     this.storeDao.save(store);

     try {
/*  62 */       DataCache.remove("CityManager.getCityListByStore" + store.getCompanyId() + store.getBrandId());
/*  63 */       DataCache.remove("CityManager.getCityListByStore4Combox" + store.getCompanyId() + store.getBrandId());
/*  64 */     } catch (Exception exception) {}

/*  66 */     return store;
   }

   public void setStoreDao(StoreDao storeDao) {
/*  70 */     this.storeDao = storeDao;
   }



   public List<Store> getPageList(StoreDto storeDto) throws DataAccessException {
/*  76 */     return this.storeDao.getPageList(storeDto);
   }

   public Integer getPageTotal(StoreDto storeDto) {
/*  80 */     return this.storeDao.getPageTotal(storeDto);
   }


   @CacheEvict(value = {"dataCache"}, key = "(\"StoreManager.getStoreById\").concat(#store.getId())", condition = "#store.getId()>0L")
   public int updateStore(Store store) {
/*  86 */     if (store.getId().longValue() > 0L) {
/*  87 */       DataCache.remove("StoreManager.getStoreXpushDid" + store.getId());
     }
/*  89 */     if (store.getSource() != null && store.getSourceCode() != null) {
/*  90 */       DataCache.remove("StoreManager.getStoreBySourceCode" + store.getSource() + store.getSourceCode());
     }
/*  92 */     if (store.getIdKey() != null) {
/*  93 */       DataCache.remove("StoreManager.getStoreByIdKey" + store.getIdKey());
     }

     try {
/*  97 */       DataCache.remove("CityManager.getCityListByStore" + store.getCompanyId() + store.getBrandId());
/*  98 */       DataCache.remove("CityManager.getCityListByStore4Combox" + store.getCompanyId() + store.getBrandId());
/*  99 */     } catch (Exception exception) {}

/* 101 */     return this.storeDao.update(store);
   }


   public List<Store> getAdminStoreList(StoreDto storeDto) {
/* 106 */     return this.storeDao.getAdminStoreList(storeDto);
   }

   public List<Store> getStoreListByCondition(StoreDto storeDto) {
/* 110 */     return this.storeDao.getStoreListByCondition(storeDto);
   }







   public List<Store> getIsUseStoreList(StoreDto storeDto) {
/* 120 */     return this.storeDao.getIsUseStoreList(storeDto);
   }







   public List<Store> getStoreListByStoreIdList(List<Long> storeIdList) {
/* 130 */     return this.storeDao.getStoreListByStoreIdList(storeIdList);
   }

   @Cacheable(value = {"dataCache"}, key = "(\"StoreManager.getStoreByIdKey\").concat(#idKey)")
   public Store getStoreByIdKey(String idKey) {
/* 135 */     return this.storeDao.getStoreByIdKey(idKey);
   }





   @CacheEvict(value = {"dataCache"}, key = "(\"StoreManager.getStoreById\").concat(#store.getId())", condition = "#store.getId()>0L")
   public int unbindWxStore(Store store) {
/* 144 */     if (store == null || store.getPoiId() == null) return 0;

/* 146 */     return this.storeDao.unbindWxStore(store);
   }





   public List<Store> getWechatStoreList() {
/* 154 */     return this.storeDao.getWechatStoreList();
   }


   public List<Store> getInUseStoreList(StoreDto storeDto) {
/* 159 */     return this.storeDao.getInUseStoreList(storeDto);
   }







   public Store getStoreByTakeOutCode(String takeOutCode) {
/* 169 */     return this.storeDao.getStoreByTakeOutCode(takeOutCode);
   }


   @Cacheable(value = {"dataCache"}, key = "(\"StoreManager.getStoreByIidingyunShopId\").concat(#iidingyunShopId)", condition = "#iidingyunShopId>0L")
   public Store getStoreByIidingyunShopId(Long iidingyunShopId) {
/* 175 */     return this.storeDao.getStoreByIidingyunShopId(iidingyunShopId);
   }

   public Store getStore(StoreDto storeDto) {
/* 179 */     return this.storeDao.getStore(storeDto);
   }

   @Cacheable(value = {"dataCache"}, key = "(\"StoreManager.getStoreXpushDid\").concat(#storeId)", condition = "#storeId>0L")
   public String getStoreXpushDid(Long storeId) {
/* 184 */     return this.storeDao.getStoreXpushDid(storeId);
   }

   public List<Store> getListByCity(Long companyId, Long brandId, String cityId) {
/* 188 */     List<Store> list = new ArrayList<>();
/* 189 */     if (companyId == null && brandId == null) {
/* 190 */       return list;
     }

/* 193 */     StoreDto storeDto = new StoreDto();
/* 194 */     storeDto.setCompanyId(companyId);
/* 195 */     storeDto.setBrandId(brandId);
/* 196 */     if (StringUtils.isNotBlank(cityId)) {
/* 197 */       if (cityId.startsWith("p")) {
/* 198 */         storeDto.setProvinceId(Long.valueOf(cityId.substring(1)));
/* 199 */       } else if (cityId.startsWith("c")) {
/* 200 */         storeDto.setCityId(Long.valueOf(cityId.substring(1)));
       } else {
/* 202 */         storeDto.setCityId(Long.valueOf(cityId));
       }
     }
/* 205 */     storeDto.setLimit(10000);
/* 206 */     list = this.storeDao.getPageList(storeDto);
/* 207 */     return list;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\StoreManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */