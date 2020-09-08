 package com.itcrazy.alanmall.office.dto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;

 public class AppVersionDto
   extends BaseDto
 {
   private static final long serialVersionUID = 4140321878071880650L;
   private String app;
   private Integer versionCode;
   private String versionName;

   public String getApp() {
/* 14 */     return this.app;
   }
   public Integer getVersionCode() {
/* 17 */     return this.versionCode;
   }
   public String getVersionName() {
/* 20 */     return this.versionName;
   }
   public void setApp(String app) {
/* 23 */     this.app = app;
   }
   public void setVersionCode(Integer versionCode) {
/* 26 */     this.versionCode = versionCode;
   }
   public void setVersionName(String versionName) {
/* 29 */     this.versionName = versionName;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\dto\AppVersionDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */