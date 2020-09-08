 package com.itcrazy.alanmall.user.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;

 public class Handle
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -2641091875700895723L;
   public static final long ID_MIN = 100000000L;
   private Long id;
   private Long moduleId;
   private String name;
   private String code;
   private Integer system;
   private String url;

   public Long getId() {
/* 21 */     return this.id;
   }
   public void setId(Long id) {
/* 24 */     this.id = id;
   }
   public Long getModuleId() {
/* 27 */     return this.moduleId;
   }
   public void setModuleId(Long moduleId) {
/* 30 */     this.moduleId = moduleId;
   }
   public String getName() {
/* 33 */     return this.name;
   }
   public void setName(String name) {
/* 36 */     this.name = name;
   }
   public String getCode() {
/* 39 */     return this.code;
   }
   public void setCode(String code) {
/* 42 */     this.code = code;
   }
   public Integer getSystem() {
/* 45 */     return this.system;
   }
   public void setSystem(Integer system) {
/* 48 */     this.system = system;
   }
   public String getUrl() {
/* 51 */     return this.url;
   }
   public void setUrl(String url) {
/* 54 */     this.url = url;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\model\Handle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */