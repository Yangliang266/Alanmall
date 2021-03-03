package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.dto.BrandSmsConfigDto;
import com.itcrazy.alanmall.merchant.model.BrandSmsConfig;
import org.springframework.stereotype.Component;

@Component
public interface BrandSmsConfigDao extends BaseDao<BrandSmsConfig, Long> {
  BrandSmsConfig getByBrandDto(BrandSmsConfigDto paramBrandSmsConfigDto);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\BrandSmsConfigDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */