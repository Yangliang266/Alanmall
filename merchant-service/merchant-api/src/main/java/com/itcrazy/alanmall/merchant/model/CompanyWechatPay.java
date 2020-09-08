 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;






 public class CompanyWechatPay
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -5191671028676991349L;
   private Long id;
   private Long companyId;
   private Long brandId;
   private Long wechatConfigId;
   private Long mchId;
   private String keyValue;
   private String opUserId;
   private Long createId;
   private Long updateId;
   private Long storeId;
   private Integer isCertUpload;
   private String serviceAppId;
   private String serviceSecret;
   private Long serviceMchId;
   private String posMchNo;

   public Long getId() {
/*  31 */     return this.id;
   }

   public void setId(Long id) {
/*  35 */     this.id = id;
   }

   public Long getCompanyId() {
/*  39 */     return this.companyId;
   }

   public void setCompanyId(Long companyId) {
/*  43 */     this.companyId = companyId;
   }

   public Long getBrandId() {
/*  47 */     return this.brandId;
   }

   public void setBrandId(Long brandId) {
/*  51 */     this.brandId = brandId;
   }

   public Long getWechatConfigId() {
/*  55 */     return this.wechatConfigId;
   }

   public void setWechatConfigId(Long wechatConfigId) {
/*  59 */     this.wechatConfigId = wechatConfigId;
   }

   public Long getMchId() {
/*  63 */     return this.mchId;
   }

   public void setMchId(Long mchId) {
/*  67 */     this.mchId = mchId;
/*     */   }
/*     */   
/*     */   public String getKeyValue() {
/*  71 */     return this.keyValue;
/*     */   }
/*     */   
/*     */   public void setKeyValue(String keyValue) {
/*  75 */     this.keyValue = keyValue;
/*     */   }
/*     */   
/*     */   public Long getCreateId() {
/*  79 */     return this.createId;
/*     */   }
/*     */   
/*     */   public void setCreateId(Long createId) {
/*  83 */     this.createId = createId;
/*     */   }
/*     */   
/*     */   public Long getUpdateId() {
/*  87 */     return this.updateId;
/*     */   }
/*     */   
/*     */   public void setUpdateId(Long updateId) {
/*  91 */     this.updateId = updateId;
/*     */   }
/*     */   
/*     */   public String getOpUserId() {
/*  95 */     return this.opUserId;
/*     */   }
/*     */   
/*     */   public void setOpUserId(String opUserId) {
/*  99 */     this.opUserId = opUserId;
/*     */   }
/*     */   
/*     */   public Long getStoreId() {
/* 103 */     return this.storeId;
/*     */   }
/*     */   
/*     */   public void setStoreId(Long storeId) {
/* 107 */     this.storeId = storeId;
/*     */   }
/*     */   
/*     */   public Integer getIsCertUpload() {
/* 111 */     return this.isCertUpload;
/*     */   }
/*     */   
/*     */   public void setIsCertUpload(Integer isCertUpload) {
/* 115 */     this.isCertUpload = isCertUpload;
/*     */   }
/*     */   
/*     */   public String getIsCertUploadStr() {
/* 119 */     if (this.isCertUpload == null) {
/* 120 */       return "";
/*     */     }
/* 122 */     if (this.isCertUpload.intValue() == 1) {
/* 123 */       return "是";
/*     */     }
/* 125 */     return "否";
/*     */   }
/*     */ 
/*     */   
/*     */   public String getServiceAppId() {
/* 130 */     return this.serviceAppId;
/*     */   }
/*     */   
/*     */   public String getServiceSecret() {
/* 134 */     return this.serviceSecret;
/*     */   }
/*     */   
/*     */   public Long getServiceMchId() {
/* 138 */     return this.serviceMchId;
/*     */   }
/*     */   
/*     */   public void setServiceAppId(String serviceAppId) {
/* 142 */     this.serviceAppId = serviceAppId;
/*     */   }
/*     */   
/*     */   public void setServiceSecret(String serviceSecret) {
/* 146 */     this.serviceSecret = serviceSecret;
/*     */   }
/*     */   
/*     */   public void setServiceMchId(Long serviceMchId) {
/* 150 */     this.serviceMchId = serviceMchId;
/*     */   }
/*     */   
/*     */   public String getPosMchNo() {
/* 154 */     return this.posMchNo;
/*     */   }
/*     */   
/*     */   public void setPosMchNo(String posMchNo) {
/* 158 */     this.posMchNo = posMchNo;
/*     */   }
/*     */ }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\CompanyWechatPay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */