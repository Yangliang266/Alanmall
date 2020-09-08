 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;









 public class County
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 3275696244612743464L;
   private Long id;
   private String countyCname;
   private String countyPostcode;
   private Long cityId;
   private String code;

   public Long getId() {
/* 24 */     return this.id;
   }

   public void setId(Long id) {
/* 28 */     this.id = id;
   }

   public String getCountyCname() {
/* 32 */     return this.countyCname;
   }

   public void setCountyCname(String countyCname) {
/* 36 */     this.countyCname = countyCname;
   }

   public String getCountyPostcode() {
/* 40 */     return this.countyPostcode;
   }

   public void setCountyPostcode(String countyPostcode) {
/* 44 */     this.countyPostcode = countyPostcode;
   }

   public Long getCityId() {
/* 48 */     return this.cityId;
   }

   public void setCityId(Long cityId) {
/* 52 */     this.cityId = cityId;
   }

   public String getCode() {
/* 56 */     return this.code;
   }

   public void setCode(String code) {
/* 60 */     this.code = code;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\County.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */