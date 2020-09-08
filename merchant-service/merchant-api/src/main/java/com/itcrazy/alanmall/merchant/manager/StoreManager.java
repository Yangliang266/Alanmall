package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.dto.StoreDto;
import com.itcrazy.alanmall.merchant.model.Store;
import java.util.List;

public interface StoreManager {
  Store getStoreById(Long paramLong);
  
  Store getStoreByName(String paramString);
  
  Store getStoreBySourceCode(Integer paramInteger, String paramString);
  
  void deleteStore(Long paramLong1, Long paramLong2);
  
  Store addStore(Store paramStore);
  
  int updateStore(Store paramStore);
  
  List<Store> getPageList(StoreDto paramStoreDto);
  
  Integer getPageTotal(StoreDto paramStoreDto);
  
  List<Store> getStoreListByCondition(StoreDto paramStoreDto);
  
  List<Long> getStoreProvinceIdList(StoreDto paramStoreDto);
  
  List<Store> getIsUseStoreList(StoreDto paramStoreDto);
  
  List<Store> getAdminStoreList(StoreDto paramStoreDto);
  
  List<Store> getStoreListByStoreIdList(List<Long> paramList);
  
  Store getStoreByIdKey(String paramString);
  
  int unbindWxStore(Store paramStore);
  
  List<Store> getWechatStoreList();
  
  List<Store> getInUseStoreList(StoreDto paramStoreDto);
  
  Store getStoreByTakeOutCode(String paramString);
  
  Store getStoreByIidingyunShopId(Long paramLong);
  
  String getStoreXpushDid(Long paramLong);
  
  Store getStore(StoreDto paramStoreDto);
  
  List<Store> getListByCity(Long paramLong1, Long paramLong2, String paramString);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\StoreManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */