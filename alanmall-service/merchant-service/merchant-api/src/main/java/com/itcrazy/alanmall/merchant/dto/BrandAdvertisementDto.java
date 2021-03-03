 package com.itcrazy.alanmall.merchant.dto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;

 public class BrandAdvertisementDto
   extends BaseDto
 {
   private static final long serialVersionUID = -8360033814626194108L;
   private String brandName;
   private String title;
   private Integer isActive;
   private String remark;

   public String getBrandName() {
/* 32 */     return this.brandName;
   }

   public void setBrandName(String brandName) {
/* 36 */     this.brandName = brandName;
   }

   public String getTitle() {
/* 40 */     return this.title;
   }

   public void setTitle(String title) {
/* 44 */     this.title = title;
   }

   public Integer getIsActive() {
/* 48 */     return this.isActive;
   }

   public void setIsActive(Integer isActive) {
/* 52 */     this.isActive = isActive;
   }

   public String getRemark() {
/* 56 */     return this.remark;
   }

   public void setRemark(String remark) {
/* 60 */     this.remark = remark;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\dto\BrandAdvertisementDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */