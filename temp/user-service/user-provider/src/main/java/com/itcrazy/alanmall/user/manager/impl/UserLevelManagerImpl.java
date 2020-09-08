 package com.itcrazy.alanmall.user.manager.impl;


 import com.itcrazy.alanmall.user.manager.UserLevelManager;
 import org.apache.dubbo.config.annotation.Service;

// @Service(protocol = {"dubbo"}, version = "1.0.0", timeout = 10000)
@Service
 public class UserLevelManagerImpl
   implements UserLevelManager {
   public String getUserLevelNameById(Long id) {
/* 10 */     if (id == null)
/* 11 */       return "未知"; 
/* 12 */     if (id.longValue() == 1L)
/* 13 */       return "商家级别"; 
/* 14 */     if (id.longValue() == 2L) {
/* 15 */       return "品牌级别";
     }
/* 17 */     return "门店级别";
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-service\BOOT-INF\classes\!\com\meish\\user\manager\impl\UserLevelManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */