package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.dto.CompanyDto;
import com.itcrazy.alanmall.merchant.model.Company;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface CompanyDao extends BaseDao<Company, Long> {
  List<Company> getPageList(CompanyDto paramCompanyDto);
  
  Integer getPageTotal(CompanyDto paramCompanyDto);
  
  Company getCompanyByDto(CompanyDto paramCompanyDto);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\CompanyDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */