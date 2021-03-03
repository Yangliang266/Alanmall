 package com.itcrazy.alanmall.merchant.dto;


 import com.itcrazy.alanmall.common.framework.dto.BaseDto;

 public class CompanyAlipayDto
   extends BaseDto
 {
   private static final long serialVersionUID = 4674918911676606084L;
   private Long companyId;
   private Long brandId;
   private String partner;
   private Long storeId;
   private String storeIds;
   private String appId;
   private String partentId;
   private String privateKey;
   private Long updateId;

   public Long getBrandId() {
/* 22 */     return this.brandId;
   }



   public void setBrandId(Long brandId) {
/* 28 */     this.brandId = brandId;
   }



   public String getPartner() {
/* 34 */     return this.partner;
   }



   public void setPartner(String partner) {
/* 40 */     this.partner = partner;
   }
   public Long getCompanyId() {
/* 43 */     return this.companyId;
   }
   public void setCompanyId(Long companyId) {
/* 46 */     this.companyId = companyId;
   }
   public Long getStoreId() {
/* 49 */     return this.storeId;
   }
   public void setStoreId(Long storeId) {
/* 52 */     this.storeId = storeId;
   }
   public String getStoreIds() {
/* 55 */     return this.storeIds;
   }
   public void setStoreIds(String storeIds) {
/* 58 */     this.storeIds = storeIds;
   }
   public String getPartentId() {
/* 61 */     return this.partentId;
   }
   public void setPartentId(String partentId) {
/* 64 */     this.partentId = partentId;
   }
   public String getPrivateKey() {
/* 67 */     return this.privateKey;
   }
   public void setPrivateKey(String privateKey) {
/* 70 */     this.privateKey = privateKey;
   }
   public Long getUpdateId() {
/* 73 */     return this.updateId;
   }
   public void setUpdateId(Long updateId) {
/* 76 */     this.updateId = updateId;
   }
   public String getAppId() {
/* 79 */     return this.appId;
   }
   public void setAppId(String appId) {
/* 82 */     this.appId = appId;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\dto\CompanyAlipayDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */