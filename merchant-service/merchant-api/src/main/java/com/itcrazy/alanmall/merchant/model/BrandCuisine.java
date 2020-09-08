 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;










 public class BrandCuisine
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -5566613551949965750L;
   private Long id;
   private Long brandId;
   private Long cuisineId;
   private Long cuisineClassId;
   private Integer type;
   private String cuisineName;
   private String cuisineClassName;

   public Long getId() {
/* 27 */     return this.id;
   }

   public void setId(Long id) {
/* 31 */     this.id = id;
   }

   public Long getBrandId() {
/* 35 */     return this.brandId;
   }

   public void setBrandId(Long brandId) {
/* 39 */     this.brandId = brandId;
   }

   public Long getCuisineId() {
/* 43 */     return this.cuisineId;
   }

   public void setCuisineId(Long cuisineId) {
/* 47 */     this.cuisineId = cuisineId;
   }

   public Long getCuisineClassId() {
/* 51 */     return this.cuisineClassId;
   }

   public void setCuisineClassId(Long cuisineClassId) {
/* 55 */     this.cuisineClassId = cuisineClassId;
   }

   public Integer getType() {
/* 59 */     return this.type;
   }

   public void setType(Integer type) {
/* 63 */     this.type = type;
   }

   public String getCuisineName() {
/* 67 */     return this.cuisineName;
   }

   public void setCuisineName(String cuisineName) {
/* 71 */     this.cuisineName = cuisineName;
   }

   public String getCuisineClassName() {
/* 75 */     return this.cuisineClassName;
   }

   public void setCuisineClassName(String cuisineClassName) {
/* 79 */     this.cuisineClassName = cuisineClassName;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\BrandCuisine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */