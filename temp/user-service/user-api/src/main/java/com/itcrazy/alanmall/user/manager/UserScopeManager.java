package com.itcrazy.alanmall.user.manager;

import com.itcrazy.alanmall.user.carddto.UserScopeDto;
import com.itcrazy.alanmall.user.model.UserScope;

import java.util.List;
import java.util.Map;

public interface UserScopeManager {
  List<UserScope> getPageList(UserScopeDto paramUserScopeDto);
  
  Map<String, UserScope> storeIdMap(Long paramLong);
  
  int removeUserScope(UserScope paramUserScope);
  
  void saveBatch(List<UserScope> paramList);
}


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\manager\UserScopeManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */