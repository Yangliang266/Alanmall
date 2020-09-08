package com.itcrazy.alanmall.user.dao;

import java.util.List;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.user.carddto.ModuleUrlDto;
import com.itcrazy.alanmall.user.model.ModuleUrl;
import org.springframework.stereotype.Component;

@Component
public interface ModuleUrlDao extends BaseDao<ModuleUrl, Long> {
  List<ModuleUrl> getPageList(ModuleUrlDto paramModuleUrlDto);
}


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meish\\user\dao\ModuleUrlDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */