package com.itcrazy.alanmall.user.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.user.carddto.RoleModuleDto;
import com.itcrazy.alanmall.user.model.RoleModule;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface RoleModuleDao extends BaseDao<RoleModule, Long> {
  int removeRoleModule(RoleModule paramRoleModule);
  
  void saveBatch(List<RoleModule> paramList);
  
  List<RoleModule> getPageList(RoleModuleDto paramRoleModuleDto);
}


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meish\\user\dao\RoleModuleDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */