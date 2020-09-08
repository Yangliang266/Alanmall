package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.dto.BrandDto;
import com.itcrazy.alanmall.merchant.model.Brand;
import java.util.List;

public interface BrandManager {
  Brand getBrandById(Long paramLong);
  
  Brand getBrandBySourceCode(Integer paramInteger, String paramString);
  
  Brand addBrand(Brand paramBrand);
  
  void passBrand(Long paramLong1, Long paramLong2);
  
  void disableBrand(Long paramLong1, Long paramLong2);
  
  List<Brand> getPageList(BrandDto paramBrandDto);
  
  Integer getPageTotal(BrandDto paramBrandDto);
  
  int updateBrand(Brand paramBrand);
  
  int removeBrand(Brand paramBrand);
  
  List<Brand> getAdminBrandList(BrandDto paramBrandDto);
  
  List<Brand> getBrandListBasic(BrandDto paramBrandDto);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\BrandManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */