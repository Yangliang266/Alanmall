 package com.itcrazy.alanmall.user.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;

 public class CompanyBusiness
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 6220178534589494831L;
   private Long id;
   private Long companyId;
   private Long createId;
   private Long updateId;
   private Long businessId;

   public Long getId() {
/* 21 */     return this.id;
   }
   public void setId(Long id) {
/* 24 */     this.id = id;
   }
   public Long getCompanyId() {
/* 27 */     return this.companyId;
   }
   public void setCompanyId(Long companyId) {
/* 30 */     this.companyId = companyId;
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
   public Long getBusinessId() {
/* 46 */     return this.businessId;
   }
   public void setBusinessId(Long businessId) {
/* 49 */     this.businessId = businessId;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\model\CompanyBusiness.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */