package com.itcrazy.alanmall.user.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.user.carddto.CompanyBusinessDto;
import java.util.List;

import com.itcrazy.alanmall.user.model.CompanyBusiness;
import org.springframework.stereotype.Component;

@Component
public interface CompanyBusinessDao extends BaseDao<CompanyBusiness, Long> {
  List<CompanyBusiness> getPageList(CompanyBusinessDto paramCompanyBusinessDto);
  
  Integer getPageTotal(CompanyBusinessDto paramCompanyBusinessDto);
}


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meish\\user\dao\CompanyBusinessDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */