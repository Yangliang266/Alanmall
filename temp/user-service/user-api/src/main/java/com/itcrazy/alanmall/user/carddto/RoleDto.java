 package com.itcrazy.alanmall.user.carddto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;

 public class RoleDto
   extends BaseDto
 {
   private static final long serialVersionUID = 9131897643359846917L;
   private Long companyId;
   private Long brandId;
   private Integer isDefault;
   private String searchName;
   private String name;
   private String roleLevelIds;
   private Integer status;

   public Long getCompanyId() {
/* 19 */     return this.companyId;
   }
   public void setCompanyId(Long companyId) {
/* 22 */     this.companyId = companyId;
   }
   public Integer getIsDefault() {
/* 25 */     return this.isDefault;
   }
   public void setIsDefault(Integer isDefault) {
/* 28 */     this.isDefault = isDefault;
   }
   public String getName() {
/* 31 */     return this.name;
   }
   public void setName(String name) {
/* 34 */     this.name = name;
   }
   public Long getBrandId() {
/* 37 */     return this.brandId;
   }
   public void setBrandId(Long brandId) {
/* 40 */     this.brandId = brandId;
   }
   public String getSearchName() {
/* 43 */     return this.searchName;
   }
   public void setSearchName(String searchName) {
/* 46 */     this.searchName = searchName;
   }
   public String getRoleLevelIds() {
/* 49 */     return this.roleLevelIds;
   }
   public void setRoleLevelIds(String roleLevelIds) {
/* 52 */     this.roleLevelIds = roleLevelIds;
   }
   public Integer getStatus() {
/* 55 */     return this.status;
   }
   public void setStatus(Integer status) {
/* 58 */     this.status = status;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\dto\RoleDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */