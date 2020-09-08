package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.model.LandMark;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface LandMarkDao extends BaseDao<LandMark, Long> {
  List<LandMark> getLandMarkListByCityId(Long paramLong);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\LandMarkDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */