package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.dto.FacilityInfoChgDto;
import com.itcrazy.alanmall.merchant.model.FacilityInfoChg;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface FacilityInfoChgDao extends BaseDao<FacilityInfoChg, Long> {
  FacilityInfoChg getfacilityInfoChgByDto(FacilityInfoChgDto paramFacilityInfoChgDto);
  
  List<FacilityInfoChg> getPageList(FacilityInfoChgDto paramFacilityInfoChgDto);
  
  Integer getPageTotal(FacilityInfoChgDto paramFacilityInfoChgDto);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\FacilityInfoChgDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */