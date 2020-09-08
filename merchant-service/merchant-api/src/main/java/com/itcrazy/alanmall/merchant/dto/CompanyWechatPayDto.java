 package com.itcrazy.alanmall.merchant.dto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;

 public class CompanyWechatPayDto
   extends BaseDto
 {
   private static final long serialVersionUID = -2442337102889919757L;
   private Long companyId;
   private Long wechatConfigId;
   private Long mchId;
   private Long storeId;
   private Long brandId;
   private Long updateId;

   public Long getCompanyId() {
/* 20 */     return this.companyId;
   }

   public void setCompanyId(Long companyId) {
/* 24 */     this.companyId = companyId;
   }

   public Long getWechatConfigId() {
/* 28 */     return this.wechatConfigId;
   }

   public void setWechatConfigId(Long wechatConfigId) {
/* 32 */     this.wechatConfigId = wechatConfigId;
   }

   public Long getMchId() {
/* 36 */     return this.mchId;
   }

   public void setMchId(Long mchId) {
/* 40 */     this.mchId = mchId;
   }

   public Long getStoreId() {
/* 44 */     return this.storeId;
   }

   public void setStoreId(Long storeId) {
/* 48 */     this.storeId = storeId;
   }

   public Long getBrandId() {
/* 52 */     return this.brandId;
   }

   public void setBrandId(Long brandId) {
/* 56 */     this.brandId = brandId;
   }

   public Long getUpdateId() {
/* 60 */     return this.updateId;
   }

   public void setUpdateId(Long updateId) {
/* 64 */     this.updateId = updateId;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\dto\CompanyWechatPayDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */