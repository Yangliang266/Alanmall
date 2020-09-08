package com.itcrazy.alanmall.user.manager;

import com.itcrazy.alanmall.user.model.CompanyBusiness;
import java.util.List;

public interface CompanyBusinessManager {
  CompanyBusiness addCompanyBusiness(CompanyBusiness paramCompanyBusiness);
  
  List<CompanyBusiness> getCompanyBusinessListByCompanyId(Long paramLong);
  
  Integer removeCompanyBusiness(Long paramLong1, Long paramLong2);
  
  Boolean isSupportBusinessByCompanyId(Long paramLong1, Long paramLong2);
}


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\manager\CompanyBusinessManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */