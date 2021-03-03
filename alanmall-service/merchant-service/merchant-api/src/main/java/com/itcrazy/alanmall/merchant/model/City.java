 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;









 public class City
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -5331295029626638313L;
   private Long id;
   private String cityCname;
   private String cityPostcode;
   private Long provinceId;
   private String code;
   private String firstPinyin;

   public Long getId() {
/* 25 */     return this.id;
   }

   public void setId(Long id) {
/* 29 */     this.id = id;
   }

   public String getCityCname() {
/* 33 */     return this.cityCname;
   }

   public void setCityCname(String cityCname) {
/* 37 */     this.cityCname = cityCname;
   }

   public String getCityPostcode() {
/* 41 */     return this.cityPostcode;
   }

   public void setCityPostcode(String cityPostcode) {
/* 45 */     this.cityPostcode = cityPostcode;
   }

   public Long getProvinceId() {
/* 49 */     return this.provinceId;
   }

   public void setProvinceId(Long provinceId) {
/* 53 */     this.provinceId = provinceId;
   }

   public String getCode() {
/* 57 */     return this.code;
   }

   public void setCode(String code) {
/* 61 */     this.code = code;
   }

   public String getFirstPinyin() {
/* 65 */     return this.firstPinyin;
   }

   public void setFirstPinyin(String firstPinyin) {
/* 69 */     this.firstPinyin = firstPinyin;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\City.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */