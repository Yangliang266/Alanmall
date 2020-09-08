 package com.itcrazy.alanmall.merchant.co;

 import java.io.Serializable;
 import java.util.ArrayList;
 import java.util.List;

 public class StoreCityCo
   implements Serializable {
   private static final long serialVersionUID = -7278710374563208789L;
   private String pinyin;
/* 11 */   private List<CityCo> cities = new ArrayList<>();

   public String getPinyin() {
/* 14 */     return this.pinyin;
   }

   public void setPinyin(String pinyin) {
/* 18 */     this.pinyin = pinyin;
   }

   public void addCity(CityCo cityCo) {
/* 22 */     this.cities.add(cityCo);
   }

   public List<CityCo> getCities() {
/* 26 */     return this.cities;
   }

   public void setCities(List<CityCo> cities) {
/* 30 */     this.cities = cities;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\co\StoreCityCo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */