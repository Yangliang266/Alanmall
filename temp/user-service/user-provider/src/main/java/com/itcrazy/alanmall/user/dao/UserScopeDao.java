package com.itcrazy.alanmall.user.dao;

import java.util.List;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.user.carddto.UserScopeDto;
import com.itcrazy.alanmall.user.model.UserScope;
import org.springframework.stereotype.Component;

@Component
public interface UserScopeDao extends BaseDao<UserScope, Long> {
  List<UserScope> getPageList(UserScopeDto paramUserScopeDto);
  
  void saveBatch(List<UserScope> paramList);
}


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meish\\user\dao\UserScopeDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */