package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.dto.CompanyTmallAppDto;
import com.itcrazy.alanmall.merchant.model.CompanyTmallApp;
import java.util.List;

public interface CompanyTmallAppManager {
  CompanyTmallApp addCompanyTmallApp(CompanyTmallApp paramCompanyTmallApp);
  
  void updateCompanyTmallApp(CompanyTmallApp paramCompanyTmallApp);
  
  List<CompanyTmallApp> getPageList(CompanyTmallAppDto paramCompanyTmallAppDto);
  
  Integer getPageTotal(CompanyTmallAppDto paramCompanyTmallAppDto);
  
  CompanyTmallApp getByAppkey(CompanyTmallApp paramCompanyTmallApp);
  
  CompanyTmallApp getById(Long paramLong);
  
  void deleteById(CompanyTmallApp paramCompanyTmallApp);
  
  CompanyTmallApp getCompanyTmallApp(CompanyTmallApp paramCompanyTmallApp);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\CompanyTmallAppManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */