package com.itcrazy.alanmall.user.manager;

import com.itcrazy.alanmall.user.model.RoleHandle;

import java.util.Map;

public interface RoleHandleManager {
  int removeByRole(Long paramLong1, Long paramLong2);
  
  RoleHandle addRoleHandle(RoleHandle paramRoleHandle);
  
  Map<Long, RoleHandle> getRoleHandleMap(Long paramLong);
}


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\manager\RoleHandleManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */