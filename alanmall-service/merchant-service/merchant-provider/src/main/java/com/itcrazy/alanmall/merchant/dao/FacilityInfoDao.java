package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.dto.FacilityInfoDto;
import com.itcrazy.alanmall.merchant.model.FacilityInfo;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface FacilityInfoDao extends BaseDao<FacilityInfo, Long> {
  FacilityInfo getFacilityInfoByDto(FacilityInfoDto paramFacilityInfoDto);
  
  List<FacilityInfo> getPageList(FacilityInfoDto paramFacilityInfoDto);
  
  Integer getPageTotal(FacilityInfoDto paramFacilityInfoDto);
  
  FacilityInfo getFacilityInfoByKey(String paramString);
  
  FacilityInfo getFacilityInfoByDeviceNo(String paramString);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\FacilityInfoDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */