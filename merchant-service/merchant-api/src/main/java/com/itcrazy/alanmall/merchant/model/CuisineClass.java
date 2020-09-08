 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;









 public class CuisineClass
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -1092329333479696373L;
   private Long id;
   private String cuisineClassName;
   private Integer type;

   public Long getId() {
/* 22 */     return this.id;
   }

   public void setId(Long id) {
/* 26 */     this.id = id;
   }

   public String getCuisineClassName() {
/* 30 */     return this.cuisineClassName;
   }

   public void setCuisineClassName(String cuisineClassName) {
/* 34 */     this.cuisineClassName = cuisineClassName;
   }

   public Integer getType() {
/* 38 */     return this.type;
   }

   public void setType(Integer type) {
/* 42 */     this.type = type;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\CuisineClass.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */