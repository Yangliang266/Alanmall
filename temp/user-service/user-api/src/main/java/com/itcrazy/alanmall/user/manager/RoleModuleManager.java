package com.itcrazy.alanmall.user.manager;

import com.itcrazy.alanmall.user.carddto.RoleModuleDto;
import com.itcrazy.alanmall.user.model.RoleModule;
import java.util.List;
import java.util.Map;

public interface RoleModuleManager {
  void saveBatch(List<RoleModule> paramList);
  
  List<RoleModule> getPageList(RoleModuleDto paramRoleModuleDto);
  
  Map<Long, RoleModule> getRoleModuleMap(RoleModuleDto paramRoleModuleDto);
  
  int removeRoleModuleByRole(Long paramLong1, Long paramLong2);
}


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\manager\RoleModuleManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */