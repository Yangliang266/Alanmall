package com.itcrazy.alanmall.user.dao;

import java.util.List;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.user.carddto.ModuleDto;
import com.itcrazy.alanmall.user.model.Module;
import org.springframework.stereotype.Component;

@Component
public interface ModuleDao extends BaseDao<Module, Long> {
  List<Module> getPageList(ModuleDto paramModuleDto);
}


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meish\\user\dao\ModuleDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */