 package com.itcrazy.alanmall.user.manager.impl;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.user.carddto.RoleModuleDto;
 import com.itcrazy.alanmall.user.dao.RoleModuleDao;
 import com.itcrazy.alanmall.user.manager.RoleModuleManager;
 import com.itcrazy.alanmall.user.model.RoleModule;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;

// @Service(protocol = {"dubbo"}, version = "1.0.0", timeout = 10000)
@Service
 public class RoleModuleManagerImpl implements RoleModuleManager {
   @Autowired
   private RoleModuleDao roleModuleDao;

   public int removeRoleModuleByRole(Long roleId, Long updateId) {
/* 20 */     RoleModule rm = new RoleModule();
/* 21 */     rm.setRoleId(roleId);
/* 22 */     rm.setUpdateId(updateId);
/* 23 */     return this.roleModuleDao.remove(rm);
   }
   public RoleModule addRoleModule(RoleModule rm) {
/* 26 */     this.roleModuleDao.save(rm);
/* 27 */     return rm;
   }


   public List<RoleModule> getPageList(RoleModuleDto dto) {
/* 32 */     return this.roleModuleDao.getPageList(dto);
   }

   public Map<Long, RoleModule> getRoleModuleMap(RoleModuleDto rmdto) {
/* 36 */     Map<Long, RoleModule> checkMap = new HashMap<>();
/* 37 */     List<RoleModule> rmList = this.roleModuleDao.getPageList(rmdto);
/* 38 */     if (rmList != null) {
/* 39 */       for (RoleModule rm : rmList) {
/* 40 */         checkMap.put(rm.getModuleId(), rm);
       }
     }
/* 43 */     return checkMap;
   }


   public void saveBatch(List<RoleModule> rmList) {
/* 48 */     if (rmList == null || rmList.size() < 1) {
       return;
     }
/* 51 */     this.roleModuleDao.saveBatch(rmList);
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meish\\user\manager\impl\RoleModuleManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */