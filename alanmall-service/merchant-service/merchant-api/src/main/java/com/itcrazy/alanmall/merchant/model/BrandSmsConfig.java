 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;




 public class BrandSmsConfig
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -2743433523225013490L;
   private Long id;
   private Long companyId;
   private Long brandId;
   private String smsSign;
   private Integer isDeleted;

   public Long getId() {
/* 19 */     return this.id;
   }
   public void setId(Long id) {
/* 22 */     this.id = id;
   }
   public Long getCompanyId() {
/* 25 */     return this.companyId;
   }
   public void setCompanyId(Long companyId) {
/* 28 */     this.companyId = companyId;
   }
   public Long getBrandId() {
/* 31 */     return this.brandId;
   }
   public void setBrandId(Long brandId) {
/* 34 */     this.brandId = brandId;
   }
   public String getSmsSign() {
/* 37 */     return this.smsSign;
   }
   public void setSmsSign(String smsSign) {
/* 40 */     this.smsSign = smsSign;
   }
   public Integer getIsDeleted() {
/* 43 */     return this.isDeleted;
   }
   public void setIsDeleted(Integer isDeleted) {
/* 46 */     this.isDeleted = isDeleted;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\BrandSmsConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */