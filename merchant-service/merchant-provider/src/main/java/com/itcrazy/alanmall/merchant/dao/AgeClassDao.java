package com.itcrazy.alanmall.merchant.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.merchant.model.AgeClass;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface AgeClassDao extends BaseDao<AgeClass, Long> {
  List<AgeClass> getAgeClassList();
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\dao\AgeClassDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */