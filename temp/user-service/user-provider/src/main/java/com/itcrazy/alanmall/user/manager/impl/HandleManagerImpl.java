 package com.itcrazy.alanmall.user.manager.impl;

 import java.util.List;

 import com.itcrazy.alanmall.user.carddto.HandleDto;
 import com.itcrazy.alanmall.user.dao.HandleDao;
 import com.itcrazy.alanmall.user.manager.HandleManager;
 import com.itcrazy.alanmall.user.model.Handle;
 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.Cacheable;

 @Slf4j
 @Service
 public class HandleManagerImpl
   implements HandleManager
 {
   @Autowired
   private HandleDao handleDao;

   @Cacheable(value = {"dataCache"}, key = "(\"HandleManager.getListBySystemId\").concat(#system)")
   public List<Handle> getListBySystemId(Integer system) {
/* 19 */     HandleDto dto = new HandleDto();
/* 20 */     dto.setSystem(system);
/* 21 */     return this.handleDao.getPageList(dto);
   }



   @Cacheable(value = {"dataCache"}, key = "(\"HandleManager.getListByModuleId\").concat(#moduleId)")
   public List<Handle> getListByModuleId(Long moduleId) {
/* 28 */     HandleDto dto = new HandleDto();
/* 29 */     dto.setModuleId(moduleId);
/* 30 */     return this.handleDao.getPageList(dto);
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meish\\user\manager\impl\HandleManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */