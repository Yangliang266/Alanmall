package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.dto.FacilityInfoDto;
import com.itcrazy.alanmall.merchant.model.FacilityInfo;
import java.util.List;

public interface FacilityInfoManager {
  FacilityInfo getFacilityInfoById(Long paramLong);
  
  FacilityInfo getFacilityInfoByKey(String paramString);
  
  FacilityInfo getFacilityInfoByDeviceNo(String paramString);
  
  FacilityInfo addFacilityInfo(FacilityInfo paramFacilityInfo);
  
  int updateFacilityInfo(FacilityInfo paramFacilityInfo);
  
  int removeFacilityInfo(FacilityInfo paramFacilityInfo);
  
  List<FacilityInfo> getPageList(FacilityInfoDto paramFacilityInfoDto);
  
  Integer getPageTotal(FacilityInfoDto paramFacilityInfoDto);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\FacilityInfoManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */