 package com.itcrazy.alanmall.user.manager.impl;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

 import com.itcrazy.alanmall.user.carddto.CompanyBusinessDto;
 import com.itcrazy.alanmall.user.carddto.ModuleDto;
 import com.itcrazy.alanmall.user.dao.CompanyBusinessDao;
 import com.itcrazy.alanmall.user.dao.ModuleDao;
 import com.itcrazy.alanmall.user.manager.ModuleManager;
 import com.itcrazy.alanmall.user.model.CompanyBusiness;
 import com.itcrazy.alanmall.user.model.Module;
 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.Cacheable;

 @Slf4j
 @Service
 public class ModuleManagerImpl
   implements ModuleManager
 {
   @Autowired
   private ModuleDao moduleDao;
   @Autowired
   private CompanyBusinessDao companyBusinessDao;

   @Cacheable(value = {"dataCache"}, key = "(\"ModuleManager.getModule\").concat(#id)")
   public Module getModule(Long id) {
/* 36 */     return (Module)this.moduleDao.get(id);
   }




   public List<Module> getPageList(ModuleDto dto) {
/* 43 */     if (dto.getCompanyId() != null) {
/* 44 */       CompanyBusinessDto cbd = new CompanyBusinessDto();
/* 45 */       cbd.setCompanyId(dto.getCompanyId());
/* 46 */       List<CompanyBusiness> cbList = this.companyBusinessDao.getPageList(cbd);
/* 47 */       if (cbList == null || cbList.size() == 0) {
/* 48 */         dto.setBusinessIdStr("0");
       } else {

/* 51 */         String ids = "0";
/* 52 */         for (CompanyBusiness cb : cbList) {
/* 53 */           ids = ids + "," + cb.getBusinessId();
         }
/* 55 */         dto.setBusinessIdStr(ids);
       }
     }
/* 58 */     return this.moduleDao.getPageList(dto);
   }



   @Cacheable(value = {"dataCache"}, key = "(\"ModuleManager.getSystemModuleMap\").concat(#system)")
   public Map<Long, Module> getSystemModuleMap(Integer system) {
/* 65 */     ModuleDto dto = new ModuleDto();
/* 66 */     dto.setSystem(system);
/* 67 */     List<Module> mList = this.moduleDao.getPageList(dto);
/* 68 */     if (mList == null || mList.size() == 0) {
/* 69 */       return null;
     }
/* 71 */     Map<Long, Module> map = new HashMap<>(mList.size());
/* 72 */     for (Module m : mList) {
/* 73 */       map.put(m.getId(), m);
     }
/* 75 */     return map;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meish\\user\manager\impl\ModuleManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */