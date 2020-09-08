 package com.itcrazy.alanmall.user.model;

 import java.util.HashMap;
 import java.util.Map;

 public class RoleLevel
 {
   public static final long ID_OFFICE = 1L;
   public static final long ID_COMPANY = 2L;
   public static final long ID_BRAND = 3L;
   public static final long ID_SHOP = 4L;
   public static final long ID_OFFICE_COMPANY = 5L;

   public static String getName(Long id) {
/* 16 */     if (id == null) {
/* 17 */       return "未知";
     }
/* 19 */     Map<Long, String> m = new HashMap<Long, String>()
       {
         private static final long serialVersionUID = 8901077979664491901L;
       };







/* 30 */     return m.get(id);
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\model\RoleLevel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */