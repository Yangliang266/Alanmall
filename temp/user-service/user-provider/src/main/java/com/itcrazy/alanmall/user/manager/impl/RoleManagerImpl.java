 package com.itcrazy.alanmall.user.manager.impl;

 import java.util.List;

 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.user.carddto.RoleDto;
 import com.itcrazy.alanmall.user.dao.RoleDao;
 import com.itcrazy.alanmall.user.manager.RoleManager;
 import com.itcrazy.alanmall.user.model.Role;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;

// @Service(protocol = {"dubbo"}, version = "1.0.0", timeout = 10000)
@Service
 public class RoleManagerImpl implements RoleManager {
   @Autowired
   private RoleDao userRoleDao;

   public Role addRole(Role userRole) {
/* 18 */     this.userRoleDao.save(userRole);
/* 19 */     return userRole;
   }

   public List<Role> getPageList(RoleDto dto) {
/* 23 */     return this.userRoleDao.getPageList(dto);
   }

   public Integer getPageTotal(RoleDto dto) {
/* 27 */     return this.userRoleDao.getPageTotal(dto);
   }
   public int updateRole(Role userRole) {
/* 30 */     return this.userRoleDao.update(userRole);
   }

   public int removeRole(Role userRole) {
/* 34 */     return this.userRoleDao.remove(userRole);
   }





   public Role getRoleById(Long id) {
/* 42 */     return (Role)this.userRoleDao.get(id);
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meish\\user\manager\impl\RoleManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */