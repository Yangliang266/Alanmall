 package com.itcrazy.alanmall.merchant.co;

 import java.io.Serializable;
 import java.util.ArrayList;
 import java.util.List;

 public class ProvinceCityCo
   implements Serializable
 {
   private static final long serialVersionUID = -3695994474521408955L;
   private String id;
   private String name;
   private String adcode;
/* 14 */   private List<CityCo> cities = new ArrayList<>();

   public String getId() {
/* 17 */     return this.id;
   }
   public String getName() {
/* 20 */     return this.name;
   }
   public void setId(String id) {
/* 23 */     this.id = id;
   }
   public void setName(String name) {
/* 26 */     this.name = name;
   }
   public String getAdcode() {
/* 29 */     return this.adcode;
   }
   public void setAdcode(String adcode) {
/* 32 */     this.adcode = adcode;
   }
   public List<CityCo> getCities() {
/* 35 */     return this.cities;
   }
   public void setCities(List<CityCo> cities) {
/* 38 */     this.cities = cities;
   }
   public void addCity(CityCo cityCo) {
/* 41 */     this.cities.add(cityCo);
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\co\ProvinceCityCo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */