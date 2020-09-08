 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;


















 public class PrepaidCardConfig
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 7166471290676304462L;
   private Long id;
   private Long companyId;
   private Long provinceId;
   private Long cityId;
   private String interfaceUrl;
   private String uniqueNo;
   private String symmetricKeyEncrpt;
   private String accessKey;
   private String accessKeySecret;
   private Date createTime;
   private Long createId;
   private Date updateTime;
   private Long updateId;
   private Integer isDeleted;

   public Long getId() {
/*  43 */     return this.id;
   }

   public void setId(Long id) {
/*  47 */     this.id = id;
   }

   public Long getCompanyId() {
/*  51 */     return this.companyId;
   }

   public void setCompanyId(Long companyId) {
/*  55 */     this.companyId = companyId;
   }

   public Long getProvinceId() {
/*  59 */     return this.provinceId;
   }

   public void setProvinceId(Long provinceId) {
/*  63 */     this.provinceId = provinceId;
   }
/*     */   
/*     */   public Long getCityId() {
/*  67 */     return this.cityId;
/*     */   }
/*     */   
/*     */   public void setCityId(Long cityId) {
/*  71 */     this.cityId = cityId;
/*     */   }
/*     */   
/*     */   public String getInterfaceUrl() {
/*  75 */     return this.interfaceUrl;
/*     */   }
/*     */   
/*     */   public void setInterfaceUrl(String interfaceUrl) {
/*  79 */     this.interfaceUrl = interfaceUrl;
/*     */   }
/*     */   
/*     */   public String getUniqueNo() {
/*  83 */     return this.uniqueNo;
/*     */   }
/*     */   
/*     */   public void setUniqueNo(String uniqueNo) {
/*  87 */     this.uniqueNo = uniqueNo;
/*     */   }
/*     */   
/*     */   public String getSymmetricKeyEncrpt() {
/*  91 */     return this.symmetricKeyEncrpt;
/*     */   }
/*     */   
/*     */   public void setSymmetricKeyEncrpt(String symmetricKeyEncrpt) {
/*  95 */     this.symmetricKeyEncrpt = symmetricKeyEncrpt;
/*     */   }
/*     */   
/*     */   public Date getCreateTime() {
/*  99 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Date createTime) {
/* 103 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public Long getCreateId() {
/* 107 */     return this.createId;
/*     */   }
/*     */   
/*     */   public void setCreateId(Long createId) {
/* 111 */     this.createId = createId;
/*     */   }
/*     */   
/*     */   public Date getUpdateTime() {
/* 115 */     return this.updateTime;
/*     */   }
/*     */   
/*     */   public void setUpdateTime(Date updateTime) {
/* 119 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */   public Long getUpdateId() {
/* 123 */     return this.updateId;
/*     */   }
/*     */   
/*     */   public void setUpdateId(Long updateId) {
/* 127 */     this.updateId = updateId;
/*     */   }
/*     */   
/*     */   public Integer getIsDeleted() {
/* 131 */     return this.isDeleted;
/*     */   }
/*     */   
/*     */   public void setIsDeleted(Integer isDeleted) {
/* 135 */     this.isDeleted = isDeleted;
/*     */   }
/*     */   
/*     */   public String getAccessKey() {
/* 139 */     return this.accessKey;
/*     */   }
/*     */   
/*     */   public void setAccessKey(String accessKey) {
/* 143 */     this.accessKey = accessKey;
/*     */   }
/*     */   
/*     */   public String getAccessKeySecret() {
/* 147 */     return this.accessKeySecret;
/*     */   }
/*     */   
/*     */   public void setAccessKeySecret(String accessKeySecret) {
/* 151 */     this.accessKeySecret = accessKeySecret;
/*     */   }
/*     */ }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\PrepaidCardConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */