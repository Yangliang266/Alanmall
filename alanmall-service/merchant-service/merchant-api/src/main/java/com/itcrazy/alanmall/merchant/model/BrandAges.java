 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;









 public class BrandAges
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -5566613551949965750L;
   private Long id;
   private Long brandId;
   private Long ageClassId;

   public Long getId() {
/* 22 */     return this.id;
   }

   public void setId(Long id) {
/* 26 */     this.id = id;
   }

   public Long getBrandId() {
/* 30 */     return this.brandId;
   }

   public void setBrandId(Long brandId) {
/* 34 */     this.brandId = brandId;
   }

   public Long getAgeClassId() {
/* 38 */     return this.ageClassId;
   }

   public void setAgeClassId(Long ageClassId) {
/* 42 */     this.ageClassId = ageClassId;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\BrandAges.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */