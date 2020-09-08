 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;









 public class LandMark
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 4750510096721855596L;
   private Long id;
   private String name;
   private Long cityId;

   public Long getId() {
/* 22 */     return this.id;
   }

   public void setId(Long id) {
/* 26 */     this.id = id;
   }

   public String getName() {
/* 30 */     return this.name;
   }

   public void setName(String name) {
/* 34 */     this.name = name;
   }

   public Long getCityId() {
/* 38 */     return this.cityId;
   }

   public void setCityId(Long cityId) {
/* 42 */     this.cityId = cityId;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\LandMark.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */