package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.dto.BrandCallDto;
import com.itcrazy.alanmall.merchant.model.BrandCall;
import java.util.List;

public interface BrandCallManager {
  List<BrandCall> getPageList(BrandCallDto paramBrandCallDto);
  
  int save(BrandCall paramBrandCall);
  
  int update(BrandCall paramBrandCall);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\BrandCallManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */