package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.dto.BrandDto;
import com.itcrazy.alanmall.merchant.model.Brand;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface BrandDao extends BaseDao<Brand, Long> {
  Brand getBrandByDto(BrandDto paramBrandDto);
  
  List<Brand> getPageList(BrandDto paramBrandDto);
  
  Integer getPageTotal(BrandDto paramBrandDto);
  
  List<Brand> getAdminBrandList(BrandDto paramBrandDto);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\BrandDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */