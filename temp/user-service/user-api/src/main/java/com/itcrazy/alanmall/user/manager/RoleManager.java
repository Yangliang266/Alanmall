package com.itcrazy.alanmall.user.manager;

import com.itcrazy.alanmall.user.carddto.RoleDto;
import com.itcrazy.alanmall.user.model.Role;

import java.util.List;

public interface RoleManager {
  Role addRole(Role paramRole);
  
  Role getRoleById(Long paramLong);
  
  List<Role> getPageList(RoleDto paramRoleDto);
  
  Integer getPageTotal(RoleDto paramRoleDto);
  
  int updateRole(Role paramRole);
  
  int removeRole(Role paramRole);
}


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\manager\RoleManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */