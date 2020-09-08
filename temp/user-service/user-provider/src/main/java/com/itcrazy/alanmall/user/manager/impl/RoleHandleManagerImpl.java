 package com.itcrazy.alanmall.user.manager.impl;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.user.carddto.RoleHandleDto;
 import com.itcrazy.alanmall.user.dao.RoleHandleDao;
 import com.itcrazy.alanmall.user.manager.RoleHandleManager;
 import com.itcrazy.alanmall.user.model.RoleHandle;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;

// @Service(protocol = {"dubbo"}, version = "1.0.0", timeout = 10000)
 @Service
 public class RoleHandleManagerImpl
   implements RoleHandleManager {
   @Autowired
   private RoleHandleDao roleHandleDao;

   public RoleHandle addRoleHandle(RoleHandle roleHandle) {
/* 21 */     this.roleHandleDao.save(roleHandle);
/* 22 */     return roleHandle;
   }

   public Map<Long, RoleHandle> getRoleHandleMap(Long roleId) {
/* 26 */     RoleHandleDto dto = new RoleHandleDto();
/* 27 */     dto.setRoleId(roleId);
/* 28 */     List<RoleHandle> rhList = this.roleHandleDao.getPageList(dto);
/* 29 */     Map<Long, RoleHandle> m = new HashMap<>();
/* 30 */     if (rhList != null && rhList.size() > 0) {
/* 31 */       for (RoleHandle rh : rhList) {
/* 32 */         m.put(rh.getHandleId(), rh);
       }
     }
/* 35 */     return m;
   }

   public int removeByRole(Long roleId, Long updateId) {
/* 39 */     RoleHandle rh = new RoleHandle();
/* 40 */     rh.setRoleId(roleId);
/* 41 */     rh.setUpdateId(updateId);
/* 42 */     return this.roleHandleDao.remove(rh);
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meish\\user\manager\impl\RoleHandleManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */