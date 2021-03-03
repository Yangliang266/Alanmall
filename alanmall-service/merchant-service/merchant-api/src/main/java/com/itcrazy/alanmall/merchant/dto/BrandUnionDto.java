 package com.itcrazy.alanmall.merchant.dto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;

 public class BrandUnionDto
   extends BaseDto
 {
   private static final long serialVersionUID = -8314649614782421040L;
   private Integer businessType;
   private String recmdBrandDishName;
   private String srcBrandName;
   private String srcCompanyName;
   private Long srcBrandId;
   private String cuisineIds;

   public Integer getBusinessType() {
/* 36 */     return this.businessType;
   }

   public void setBusinessType(Integer businessType) {
/* 40 */     this.businessType = businessType;
   }

   public String getRecmdBrandDishName() {
/* 44 */     return this.recmdBrandDishName;
   }

   public void setRecmdBrandDishName(String recmdBrandDishName) {
/* 48 */     this.recmdBrandDishName = recmdBrandDishName;
   }

   public String getSrcBrandName() {
/* 52 */     return this.srcBrandName;
   }

   public void setSrcBrandName(String srcBrandName) {
/* 56 */     this.srcBrandName = srcBrandName;
   }

   public Long getSrcBrandId() {
/* 60 */     return this.srcBrandId;
   }

   public void setSrcBrandId(Long srcBrandId) {
/* 64 */     this.srcBrandId = srcBrandId;
   }

   public String getSrcCompanyName() {
/* 68 */     return this.srcCompanyName;
   }

   public void setSrcCompanyName(String srcCompanyName) {
/* 72 */     this.srcCompanyName = srcCompanyName;
   }

   public String getCuisineIds() {
/* 76 */     return this.cuisineIds;
   }

   public void setCuisineIds(String cuisineIds) {
/* 80 */     this.cuisineIds = cuisineIds;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\dto\BrandUnionDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */