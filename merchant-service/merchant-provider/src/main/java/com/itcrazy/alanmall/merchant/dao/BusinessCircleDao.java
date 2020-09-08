package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.model.BusinessCircle;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface BusinessCircleDao extends BaseDao<BusinessCircle, Long> {
  List<BusinessCircle> getBusinessCircleListByCityId(Long paramLong);
  
  List<BusinessCircle> getBusinessCircleListByProvinceId(Long paramLong);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\BusinessCircleDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */