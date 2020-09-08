package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.dto.AppPosConfigDto;
import com.itcrazy.alanmall.merchant.model.AppPosConfig;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface AppPosConfigDao extends BaseDao<AppPosConfig, Long> {
  List<AppPosConfig> getPageList(AppPosConfigDto paramAppPosConfigDto);
  
  Integer getPageTotal(AppPosConfigDto paramAppPosConfigDto);
  
  AppPosConfig getAppPosConfigByDto(AppPosConfigDto paramAppPosConfigDto);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\AppPosConfigDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */