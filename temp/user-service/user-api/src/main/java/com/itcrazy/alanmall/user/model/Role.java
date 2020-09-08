 package com.itcrazy.alanmall.user.model;


 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;

 public class Role
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -610001688942907796L;
   private Long id;
   private String name;
   private Long companyId;
   private Long brandId;
   private Integer isDefault;
   private Long roleLevelId;
   private Long createId;
   private Long updateId;
   private String remark;
   private Integer status;

   public Long getId() {
/* 25 */     return this.id;
   }
   public void setId(Long id) {
/* 28 */     this.id = id;
   }
   public String getName() {
/* 31 */     return this.name;
   }
   public void setName(String name) {
/* 34 */     this.name = name;
   }
   public Long getCompanyId() {
/* 37 */     return this.companyId;
   }
   public void setCompanyId(Long companyId) {
/* 40 */     this.companyId = companyId;
   }
   public Long getBrandId() {
/* 43 */     return this.brandId;
   }
   public void setBrandId(Long brandId) {
/* 46 */     this.brandId = brandId;
   }
   public Integer getIsDefault() {
/* 49 */     return this.isDefault;
   }
   public void setIsDefault(Integer isDefault) {
/* 52 */     this.isDefault = isDefault;
   }
   public Long getUpdateId() {
/* 55 */     return this.updateId;
   }
   public void setUpdateId(Long updateId) {
/* 58 */     this.updateId = updateId;
   }
   public Long getCreateId() {
/* 61 */     return this.createId;
   }
   public void setCreateId(Long createId) {
/* 64 */     this.createId = createId;
   }
   public String getRemark() {
/* 67 */     return this.remark;
   }
   public void setRemark(String remark) {
/* 70 */     this.remark = remark;
   }
   public Long getRoleLevelId() {
/* 73 */     return this.roleLevelId;
   }
   public void setRoleLevelId(Long roleLevelId) {
/* 76 */     this.roleLevelId = roleLevelId;
   }
   public Integer getStatus() {
/* 79 */     return this.status;
   }
   public void setStatus(Integer status) {
/* 82 */     this.status = status;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\model\Role.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */