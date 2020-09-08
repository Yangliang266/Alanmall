 package com.itcrazy.alanmall.user.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;

 public class RoleModule
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -2188566557613411370L;
   private Long id;
   private Long roleId;
   private Long moduleId;
   private Long companyId;
   private Long createId;
   private Long updateId;

   public Long getId() {
/* 21 */     return this.id;
   }
   public void setId(Long id) {
/* 24 */     this.id = id;
   }

   public Long getCompanyId() {
/* 28 */     return this.companyId;
   }
   public void setCompanyId(Long companyId) {
/* 31 */     this.companyId = companyId;
   }
   public Long getCreateId() {
/* 34 */     return this.createId;
   }
   public void setCreateId(Long createId) {
/* 37 */     this.createId = createId;
   }
   public Long getUpdateId() {
/* 40 */     return this.updateId;
   }
   public void setUpdateId(Long updateId) {
/* 43 */     this.updateId = updateId;
   }
   public Long getRoleId() {
/* 46 */     return this.roleId;
   }
   public void setRoleId(Long roleId) {
/* 49 */     this.roleId = roleId;
   }
   public Long getModuleId() {
/* 52 */     return this.moduleId;
   }
   public void setModuleId(Long moduleId) {
/* 55 */     this.moduleId = moduleId;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\model\RoleModule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */