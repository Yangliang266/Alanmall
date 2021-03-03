package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.dto.CompanyDto;
import com.itcrazy.alanmall.merchant.model.Company;
import java.util.List;

public interface CompanyManager {
  Company getCompanyById(Long paramLong);
  
  Company addCompany(Company paramCompany);
  
  void updateCompany(Company paramCompany);
  
  List<Company> getPageList(CompanyDto paramCompanyDto);
  
  Integer getPageTotal(CompanyDto paramCompanyDto);
  
  Company getCompanyBySourceCode(Integer paramInteger, String paramString);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\CompanyManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */