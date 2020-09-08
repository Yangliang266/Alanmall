 package com.itcrazy.alanmall.user.carddto;

 public class ModuleDto {
   private Long companyId;
   private Integer system;
   private Long officeRoleId;
   private Long companyRoleId;
   private Long parentId;
   private Long roleLevelId;
   private String businessIdStr;

   public Long getCompanyId() {
/* 13 */     return this.companyId;
   }
   public void setCompanyId(Long companyId) {
/* 16 */     this.companyId = companyId;
   }
   public Integer getSystem() {
/* 19 */     return this.system;
   }
   public void setSystem(Integer system) {
/* 22 */     this.system = system;
   }

   public Long getParentId() {
/* 26 */     return this.parentId;
   }
   public void setParentId(Long parentId) {
/* 29 */     this.parentId = parentId;
   }
   public Long getOfficeRoleId() {
/* 32 */     return this.officeRoleId;
   }
   public void setOfficeRoleId(Long officeRoleId) {
/* 35 */     this.officeRoleId = officeRoleId;
   }
   public Long getCompanyRoleId() {
/* 38 */     return this.companyRoleId;
   }
   public void setCompanyRoleId(Long companyRoleId) {
/* 41 */     this.companyRoleId = companyRoleId;
   }
   public Long getRoleLevelId() {
/* 44 */     return this.roleLevelId;
   }
   public void setRoleLevelId(Long roleLevelId) {
/* 47 */     this.roleLevelId = roleLevelId;
   }
   public String getBusinessIdStr() {
/* 50 */     return this.businessIdStr;
   }
   public void setBusinessIdStr(String businessIdStr) {
/* 53 */     this.businessIdStr = businessIdStr;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\dto\ModuleDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */