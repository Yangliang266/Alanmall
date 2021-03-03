package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.dto.CompanyTmallAppDto;
import com.itcrazy.alanmall.merchant.model.CompanyTmallApp;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface CompanyTmallAppDao extends BaseDao<CompanyTmallApp, Long> {
  List<CompanyTmallApp> getPageList(CompanyTmallAppDto paramCompanyTmallAppDto);
  
  Integer getPageTotal(CompanyTmallAppDto paramCompanyTmallAppDto);
  
  CompanyTmallApp getByAppkey(CompanyTmallApp paramCompanyTmallApp);
  
  void deleteById(CompanyTmallApp paramCompanyTmallApp);
  
  CompanyTmallApp getCompanyTmallApp(CompanyTmallApp paramCompanyTmallApp);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\CompanyTmallAppDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */