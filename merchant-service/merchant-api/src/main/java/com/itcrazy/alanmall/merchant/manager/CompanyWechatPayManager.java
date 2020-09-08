package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.dto.CompanyWechatPayDto;
import com.itcrazy.alanmall.merchant.model.CompanyWechatPay;
import java.util.List;

public interface CompanyWechatPayManager {
  CompanyWechatPay addCompanyWechatPay(CompanyWechatPay paramCompanyWechatPay);
  
  @Deprecated
  CompanyWechatPay getCompanyWechatPayByWechatConfig(Long paramLong);
  
  @Deprecated
  CompanyWechatPay getCompanyWechatPayByMchId(Long paramLong);
  
  List<CompanyWechatPay> getPageList(CompanyWechatPayDto paramCompanyWechatPayDto);
  
  int remove(CompanyWechatPay paramCompanyWechatPay);
  
  int deleteCompanyWechatPay(CompanyWechatPayDto paramCompanyWechatPayDto);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\CompanyWechatPayManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */