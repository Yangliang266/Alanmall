 package com.itcrazy.alanmall.user.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;

 public class ModuleUrl
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -2607107164658502211L;
   private Long id;
   private Long moduleId;
   private String url;
   private Integer system;

   public Long getId() {
/* 16 */     return this.id;
   }
   public void setId(Long id) {
/* 19 */     this.id = id;
   }
   public Long getModuleId() {
/* 22 */     return this.moduleId;
   }
   public void setModuleId(Long moduleId) {
/* 25 */     this.moduleId = moduleId;
   }
   public String getUrl() {
/* 28 */     return this.url;
   }
   public void setUrl(String url) {
/* 31 */     this.url = url;
   }
   public Integer getSystem() {
/* 34 */     return this.system;
   }
   public void setSystem(Integer system) {
/* 37 */     this.system = system;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\model\ModuleUrl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */