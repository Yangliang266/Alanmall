 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;









 public class Province
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 3368001946693715835L;
   private Long id;
   private String provinceCname;
   private String postCode;
   private Long countryId;
   private Long isDeleted;
   private String code;
   private String firstPinyin;

   public Long getId() {
/* 26 */     return this.id;
   }

   public void setId(Long id) {
/* 30 */     this.id = id;
   }

   public String getProvinceCname() {
/* 34 */     return this.provinceCname;
   }

   public void setProvinceCname(String provinceCname) {
/* 38 */     this.provinceCname = provinceCname;
   }

   public String getPostCode() {
/* 42 */     return this.postCode;
   }

   public void setPostCode(String postCode) {
/* 46 */     this.postCode = postCode;
   }

   public Long getCountryId() {
/* 50 */     return this.countryId;
   }

   public void setCountryId(Long countryId) {
/* 54 */     this.countryId = countryId;
   }

   public Long getIsDeleted() {
/* 58 */     return this.isDeleted;
   }

   public void setIsDeleted(Long isDeleted) {
/* 62 */     this.isDeleted = isDeleted;
   }

   public String getCode() {
/* 66 */     return this.code;
   }

   public String getFirstPinyin() {
/* 70 */     return this.firstPinyin;
   }

   public void setCode(String code) {
/* 74 */     this.code = code;
   }

   public void setFirstPinyin(String firstPinyin) {
/* 78 */     this.firstPinyin = firstPinyin;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\Province.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */