package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.dto.BrandAdvertisementDto;
import com.itcrazy.alanmall.merchant.model.BrandAdvertisement;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface BrandAdvertisementDao extends BaseDao<BrandAdvertisement, Long> {
  List<BrandAdvertisement> getPageList(BrandAdvertisementDto paramBrandAdvertisementDto);
  
  Integer getPageTotal(BrandAdvertisementDto paramBrandAdvertisementDto);
  
  List<BrandAdvertisement> getList(BrandAdvertisement paramBrandAdvertisement);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\BrandAdvertisementDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */