 package com.itcrazy.alanmall.merchant.dto;


 import com.itcrazy.alanmall.common.framework.dto.BaseDto;

 public class BrandSmsConfigDto
   extends BaseDto
 {
   private static final long serialVersionUID = 2825316054250464713L;
   private Long companyId;
   private Long brandId;
   private String smsSign;

   public Long getCompanyId() {
/* 17 */     return this.companyId;
   }
   public void setCompanyId(Long companyId) {
/* 20 */     this.companyId = companyId;
   }
   public Long getBrandId() {
/* 23 */     return this.brandId;
   }
   public void setBrandId(Long brandId) {
/* 26 */     this.brandId = brandId;
   }
   public String getSmsSign() {
/* 29 */     return this.smsSign;
   }
   public void setSmsSign(String smsSign) {
/* 32 */     this.smsSign = smsSign;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\dto\BrandSmsConfigDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */