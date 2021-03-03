package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.model.CuisineClass;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface CuisineClassDao extends BaseDao<CuisineClass, Long> {
  List<CuisineClass> getCuisineClassList(int paramInt);
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\CuisineClassDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */