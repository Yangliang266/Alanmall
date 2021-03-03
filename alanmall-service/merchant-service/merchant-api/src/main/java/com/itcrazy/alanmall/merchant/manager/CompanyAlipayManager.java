package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.common.client.alipay.model.CompanyAlipay;
import com.itcrazy.alanmall.merchant.dto.CompanyAlipayDto;
import java.util.List;

public interface CompanyAlipayManager {
  CompanyAlipay add(CompanyAlipay paramCompanyAlipay);
  
  int update(CompanyAlipay paramCompanyAlipay);
  
  int remove(CompanyAlipay paramCompanyAlipay);
  
  CompanyAlipay getById(Long paramLong);
  
  List<CompanyAlipay> getPageList(CompanyAlipayDto paramCompanyAlipayDto);
  
  Integer getPageTotal(CompanyAlipayDto paramCompanyAlipayDto);
  
  CompanyAlipay getByBrandId(Long paramLong);
  
  CompanyAlipay getByStoreId(Long paramLong);
  
  int deleteCompanyAlipayConfig(List<CompanyAlipay> paramList);
  
  void saveBatch(List<CompanyAlipay> paramList);
  
  void deleteByAppId(CompanyAlipay paramCompanyAlipay);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\CompanyAlipayManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */