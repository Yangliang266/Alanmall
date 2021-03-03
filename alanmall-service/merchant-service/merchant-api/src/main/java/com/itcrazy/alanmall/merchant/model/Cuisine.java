 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;










 public class Cuisine
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 6414524456404104287L;
   private Long id;
   private Long cuisineClassId;
   private String cuisineName;
   private String cousineClassName;

   public Long getId() {
/* 24 */     return this.id;
   }

   public void setId(Long id) {
/* 28 */     this.id = id;
   }

   public Long getCuisineClassId() {
/* 32 */     return this.cuisineClassId;
   }

   public void setCuisineClassId(Long cuisineClassId) {
/* 36 */     this.cuisineClassId = cuisineClassId;
   }

   public String getCuisineName() {
/* 40 */     return this.cuisineName;
   }

   public void setCuisineName(String cuisineName) {
/* 44 */     this.cuisineName = cuisineName;
   }

   public String getCousineClassName() {
/* 48 */     return this.cousineClassName;
   }

   public void setCousineClassName(String cousineClassName) {
/* 52 */     this.cousineClassName = cousineClassName;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\Cuisine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */