package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.dto.BrandCallDto;
import com.itcrazy.alanmall.merchant.model.BrandCall;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface BrandCallDao extends BaseDao<BrandCall, Long> {
  List<BrandCall> getPageList(BrandCallDto paramBrandCallDto);
  
  Integer getPageTotal(BrandCallDto paramBrandCallDto);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\BrandCallDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */