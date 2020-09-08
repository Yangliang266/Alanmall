package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.dto.BrandUnionDto;
import com.itcrazy.alanmall.merchant.model.BrandUnion;
import java.util.List;

public interface BrandUnionManager {
  BrandUnion addBrandUnion(BrandUnion paramBrandUnion);
  
  BrandUnion getBrandUnionById(Long paramLong);
  
  int updateBrandUnion(BrandUnion paramBrandUnion);
  
  int deleteBrandUnion(BrandUnion paramBrandUnion);
  
  List<BrandUnion> getPageList(BrandUnionDto paramBrandUnionDto);
  
  Integer getPageTotal(BrandUnionDto paramBrandUnionDto);
  
  List<BrandUnion> getPageListBySrcId(BrandUnionDto paramBrandUnionDto);
  
  Integer getPageTotalBySrcId(BrandUnionDto paramBrandUnionDto);
  
  List<BrandUnion> getBrandUnionList(BrandUnion paramBrandUnion);
  
  BrandUnion getBrandUnionBySrcAndDst(BrandUnion paramBrandUnion);
  
  Integer getUnionTotal(BrandUnionDto paramBrandUnionDto);
  
  Integer getBindTotal(BrandUnionDto paramBrandUnionDto);
  
  List<BrandUnion> getRecmdBrandUnionList(BrandUnion paramBrandUnion);
  
  List<BrandUnion> getNextRecmdBrandUnionList(BrandUnion paramBrandUnion);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\BrandUnionManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */