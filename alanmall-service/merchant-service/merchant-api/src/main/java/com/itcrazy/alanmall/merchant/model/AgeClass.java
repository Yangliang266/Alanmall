 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;


 public class AgeClass
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 1693637500103084258L;
   private Long id;
   private String name;
   private Integer type;

   public Long getId() {
/* 23 */     return this.id;
   }

   public void setId(Long id) {
/* 27 */     this.id = id;
   }

   public String getName() {
/* 31 */     return this.name;
   }

   public void setName(String name) {
/* 35 */     this.name = name;
   }

   public Integer getType() {
/* 39 */     return this.type;
   }

   public void setType(Integer type) {
/* 43 */     this.type = type;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\AgeClass.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */