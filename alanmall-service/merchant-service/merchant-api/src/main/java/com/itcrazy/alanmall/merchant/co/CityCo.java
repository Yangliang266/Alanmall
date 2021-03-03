 package com.itcrazy.alanmall.merchant.co;

 import java.io.Serializable;

 public class CityCo
   implements Serializable {
   private static final long serialVersionUID = -3695994474521408955L;
   private String id;
   private String name;
   private String adcode;

   public String getId() {
/* 13 */     return this.id;
   }
   public String getName() {
/* 16 */     return this.name;
   }
   public void setId(String id) {
/* 19 */     this.id = id;
   }
   public void setName(String name) {
/* 22 */     this.name = name;
   }
   public String getAdcode() {
/* 25 */     return this.adcode;
   }
   public void setAdcode(String adcode) {
/* 28 */     this.adcode = adcode;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\co\CityCo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */