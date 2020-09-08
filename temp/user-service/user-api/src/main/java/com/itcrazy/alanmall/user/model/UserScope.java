 package com.itcrazy.alanmall.user.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;

 public class UserScope
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -7061046314007163321L;
   private Long id;
   private Long userId;
   private Long companyId;
   private Long brandId;
   private Long storeId;
   private Long createId;
   private Long updateId;

   public Long getId() {
/* 23 */     return this.id;
   }
   public void setId(Long id) {
/* 26 */     this.id = id;
   }
   public Long getUserId() {
/* 29 */     return this.userId;
   }
   public void setUserId(Long userId) {
/* 32 */     this.userId = userId;
   }

   public Long getCreateId() {
/* 36 */     return this.createId;
   }
   public void setCreateId(Long createId) {
/* 39 */     this.createId = createId;
   }
   public Long getUpdateId() {
/* 42 */     return this.updateId;
   }
   public void setUpdateId(Long updateId) {
/* 45 */     this.updateId = updateId;
   }
   public Long getCompanyId() {
/* 48 */     return this.companyId;
   }
   public void setCompanyId(Long companyId) {
/* 51 */     this.companyId = companyId;
   }
   public Long getBrandId() {
/* 54 */     return this.brandId;
   }
   public void setBrandId(Long brandId) {
/* 57 */     this.brandId = brandId;
   }
   public Long getStoreId() {
/* 60 */     return this.storeId;
   }
   public void setStoreId(Long storeId) {
/* 63 */     this.storeId = storeId;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\model\UserScope.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */