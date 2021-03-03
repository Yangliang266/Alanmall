package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.dto.StoreDto;
import com.itcrazy.alanmall.merchant.model.Store;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface StoreDao extends BaseDao<Store, Long> {
  Store getStoreByDto(StoreDto paramStoreDto);
  
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
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\StoreDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */