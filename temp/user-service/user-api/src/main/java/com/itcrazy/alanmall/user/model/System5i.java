 package com.itcrazy.alanmall.user.model;

 public class System5i
 {
/*  5 */   public static int ID_OFFICE = 1;
/*  6 */   public static int ID_CRM = 2;
/*  7 */   public static int ID_SHOP = 3;
/*  8 */   public static int ID_PS = 4;
/*  9 */   public static int ID_WECHAT = 5;

   public static String getSystemName(Integer systemId) {
/* 12 */     if (systemId.intValue() == ID_OFFICE) {
/* 13 */       return "office系统";
     }
/* 15 */     if (systemId.intValue() == ID_CRM) {
/* 16 */       return "CRM系统";
     }
/* 18 */     if (systemId.intValue() == ID_SHOP) {
/* 19 */       return "shop系统";
     }
/* 21 */     if (systemId.intValue() == ID_PS) {
/* 22 */       return "配送系统";
     }
/* 24 */     if (systemId.intValue() == ID_WECHAT) {
/* 25 */       return "微信系系统";
     }
/* 27 */     return "";
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\model\System5i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */