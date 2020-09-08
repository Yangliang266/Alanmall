package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.client.alipay.model.CompanyAlipay;
import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.dto.CompanyAlipayDto;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface CompanyAlipayDao extends BaseDao<CompanyAlipay, Long> {
  List<CompanyAlipay> getPageList(CompanyAlipayDto paramCompanyAlipayDto);
  
  Integer getPageTotal(CompanyAlipayDto paramCompanyAlipayDto);
  
  int deleteCompanyAlipayConfig(List<CompanyAlipay> paramList);
  
  void saveBatch(List<CompanyAlipay> paramList);
  
  void deleteByAppId(CompanyAlipay paramCompanyAlipay);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\CompanyAlipayDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */