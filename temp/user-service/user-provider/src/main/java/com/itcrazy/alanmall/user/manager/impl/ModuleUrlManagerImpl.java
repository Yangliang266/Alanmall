 package com.itcrazy.alanmall.user.manager.impl;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import com.itcrazy.alanmall.user.carddto.ModuleUrlDto;
 import com.itcrazy.alanmall.user.dao.ModuleUrlDao;
 import com.itcrazy.alanmall.user.manager.ModuleUrlManager;
 import com.itcrazy.alanmall.user.model.ModuleUrl;
 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.Cacheable;

 @Slf4j
 @Service
 public class ModuleUrlManagerImpl
   implements ModuleUrlManager
 {
   @Autowired
   private ModuleUrlDao moduleUrlDao;

   @Cacheable(value = {"dataCache"}, key = "(\"ModuleUrlManager.getModuleUrlMapBySystem\").concat(#system)")
   public Map<Long, String> getModuleUrlMapBySystem(Integer system) {
      ModuleUrlDto dto = new ModuleUrlDto();
      dto.setSystem(system);
      List<ModuleUrl> muList = moduleUrlDao.getPageList(dto);
      Map<Long, String> m = new HashMap<>();
      for (ModuleUrl mu : muList) {
          m.put(mu.getModuleId(), mu.getUrl());
      }
        return m;
   }
 }

