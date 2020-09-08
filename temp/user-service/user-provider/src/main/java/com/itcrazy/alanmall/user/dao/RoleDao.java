package com.itcrazy.alanmall.user.dao;

import java.util.List;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.user.carddto.RoleDto;
import com.itcrazy.alanmall.user.model.Role;
import org.springframework.stereotype.Component;

@Component
public interface RoleDao extends BaseDao<Role, Long> {
  List<Role> getRoleListByUserId(RoleDto paramRoleDto);
  
  List<Role> getPageList(RoleDto paramRoleDto);
  
  Integer getPageTotal(RoleDto paramRoleDto);
}


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meish\\user\dao\RoleDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */