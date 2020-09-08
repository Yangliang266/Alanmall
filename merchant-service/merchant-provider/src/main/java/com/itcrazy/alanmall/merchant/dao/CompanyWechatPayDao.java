package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.dto.CompanyWechatPayDto;
import com.itcrazy.alanmall.merchant.model.CompanyWechatPay;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface CompanyWechatPayDao extends BaseDao<CompanyWechatPay, Long> {
  List<CompanyWechatPay> getPageList(CompanyWechatPayDto paramCompanyWechatPayDto);
  
  int deleteCompanyWechatPay(CompanyWechatPayDto paramCompanyWechatPayDto);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\CompanyWechatPayDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */