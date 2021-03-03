package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.model.BusinessCircle;
import java.util.List;

public interface BusinessCircleManager {
  List<BusinessCircle> getBusinessCircleListByCityId(Long paramLong);
  
  BusinessCircle getBusinessCircle(Long paramLong);
  
  List<BusinessCircle> getBusinessCircleListByProvinceId(Long paramLong);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\BusinessCircleManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */