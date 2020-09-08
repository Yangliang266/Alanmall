package com.itcrazy.alanmall.merchant.manager;

import com.itcrazy.alanmall.merchant.dto.FacilityInfoChgDto;
import com.itcrazy.alanmall.merchant.model.FacilityInfoChg;
import java.util.List;

public interface FacilityInfoChgManager {
  FacilityInfoChg getFacilityInfoChgById(Long paramLong);
  
  FacilityInfoChg addFacilityInfoChg(FacilityInfoChg paramFacilityInfoChg);
  
  int updateFacilityInfoChg(FacilityInfoChg paramFacilityInfoChg);
  
  int removeFacilityInfoChg(FacilityInfoChg paramFacilityInfoChg);
  
  List<FacilityInfoChg> getPageList(FacilityInfoChgDto paramFacilityInfoChgDto);
  
  Integer getPageTotal(FacilityInfoChgDto paramFacilityInfoChgDto);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\manager\FacilityInfoChgManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */