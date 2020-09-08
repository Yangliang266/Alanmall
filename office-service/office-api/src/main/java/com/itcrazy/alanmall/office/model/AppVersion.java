 package com.itcrazy.alanmall.office.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;

 public class AppVersion
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 4140321878071880650L;
   private Long id;
   private String app;
   private Integer versionCode;
   private String versionName;
   private String url;
   private Long createId;
   private Date createTime;
   private Long updateId;
   private Date updateTime;

   public Long getId() {
/* 21 */     return this.id;
   }
   public String getApp() {
/* 24 */     return this.app;
   }
   public Integer getVersionCode() {
/* 27 */     return this.versionCode;
   }
   public String getVersionName() {
/* 30 */     return this.versionName;
   }
   public String getUrl() {
/* 33 */     return this.url;
   }
   public Long getCreateId() {
/* 36 */     return this.createId;
   }
   public Date getCreateTime() {
/* 39 */     return this.createTime;
   }
   public void setId(Long id) {
/* 42 */     this.id = id;
   }
   public void setApp(String app) {
/* 45 */     this.app = app;
   }
   public void setVersionCode(Integer versionCode) {
/* 48 */     this.versionCode = versionCode;
   }
   public void setVersionName(String versionName) {
/* 51 */     this.versionName = versionName;
   }
   public void setUrl(String url) {
/* 54 */     this.url = url;
   }
   public void setCreateId(Long createId) {
/* 57 */     this.createId = createId;
   }
   public void setCreateTime(Date createTime) {
/* 60 */     this.createTime = createTime;
   }
   public Long getUpdateId() {
/* 63 */     return this.updateId;
   }
   public Date getUpdateTime() {
/* 66 */     return this.updateTime;
   }
   public void setUpdateId(Long updateId) {
/* 69 */     this.updateId = updateId;
   }
   public void setUpdateTime(Date updateTime) {
/* 72 */     this.updateTime = updateTime;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\model\AppVersion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */