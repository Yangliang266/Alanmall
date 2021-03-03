package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.dto.BrandAdvertisementDto;
import com.itcrazy.alanmall.merchant.model.BrandAdvertisement;
import java.util.List;

public interface BrandAdvertisementManager {
  BrandAdvertisement addBrandAdvertisement(BrandAdvertisement paramBrandAdvertisement);
  
  BrandAdvertisement getBrandAdvertisementById(Long paramLong);
  
  int updateBrandAdvertisement(BrandAdvertisement paramBrandAdvertisement);
  
  int deleteBrandAdvertisement(BrandAdvertisement paramBrandAdvertisement);
  
  List<BrandAdvertisement> getPageList(BrandAdvertisementDto paramBrandAdvertisementDto);
  
  Integer getPageTotal(BrandAdvertisementDto paramBrandAdvertisementDto);
  
  List<BrandAdvertisement> getList(BrandAdvertisement paramBrandAdvertisement);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\BrandAdvertisementManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */