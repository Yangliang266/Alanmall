 package com.itcrazy.alanmall.merchant.dto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;

 public class PrepaidCardConfigDto
   extends BaseDto
 {
   private static final long serialVersionUID = 5013251497396415098L;
   private Long companyId;
   private Long cityId;
   private Long provinceId;

   public Long getCompanyId() {
/* 17 */     return this.companyId;
   }

   public void setCompanyId(Long companyId) {
/* 21 */     this.companyId = companyId;
   }

   public Long getCityId() {
/* 25 */     return this.cityId;
   }

   public void setCityId(Long cityId) {
/* 29 */     this.cityId = cityId;
   }

   public Long getProvinceId() {
/* 33 */     return this.provinceId;
   }

   public void setProvinceId(Long provinceId) {
/* 37 */     this.provinceId = provinceId;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\dto\PrepaidCardConfigDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */