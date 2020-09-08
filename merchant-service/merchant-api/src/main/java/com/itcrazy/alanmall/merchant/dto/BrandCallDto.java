 package com.itcrazy.alanmall.merchant.dto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;

 import java.util.Date;

 public class BrandCallDto
   extends BaseDto
 {
   private static final long serialVersionUID = -4466084090911608375L;
   private Long companyId;
   private Long brandId;
   private Integer status;
   private String mobile;
   private String seatCode;
   private Date minCreateTime;

   public Long getCompanyId() {
/* 19 */     return this.companyId;
   }

   public void setCompanyId(Long companyId) {
/* 23 */     this.companyId = companyId;
   }

   public Long getBrandId() {
/* 27 */     return this.brandId;
   }

   public void setBrandId(Long brandId) {
/* 31 */     this.brandId = brandId;
   }

   public Integer getStatus() {
/* 35 */     return this.status;
   }

   public void setStatus(Integer status) {
/* 39 */     this.status = status;
   }

   public String getMobile() {
/* 43 */     return this.mobile;
   }

   public void setMobile(String mobile) {
/* 47 */     this.mobile = mobile;
   }

   public String getSeatCode() {
/* 51 */     return this.seatCode;
   }

   public void setSeatCode(String seatCode) {
/* 55 */     this.seatCode = seatCode;
   }

   public Date getMinCreateTime() {
/* 59 */     return this.minCreateTime;
   }

   public void setMinCreateTime(Date minCreateTime) {
/* 63 */     this.minCreateTime = minCreateTime;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\dto\BrandCallDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */