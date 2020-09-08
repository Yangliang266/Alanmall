package com.itcrazy.alanmall.user.dao;

import java.util.List;
import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.user.model.Business;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public interface BusinessDao extends BaseDao<Business, Long> {
  @Cacheable(value = {"dataCache"}, key = "(\"BusinessDao.getAll\")")
  List<Business> getAll();
}


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meish\\user\dao\BusinessDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */