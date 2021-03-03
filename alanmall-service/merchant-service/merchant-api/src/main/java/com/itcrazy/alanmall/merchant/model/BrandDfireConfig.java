 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;





 public class BrandDfireConfig
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -5336052133220674755L;
   private Long id;
   private Long companyId;
   private Long brandId;
   private String appKey;
   private String secret;
   private String chainEntityId;
   private String plateEntityId;
   private Date createTime;
   private Date updateTime;
   private Long createId;
   private Long updateId;
   private Integer isDeleted;

   public Long getId() {
/*  28 */     return this.id;
   }

   public void setId(Long id) {
/*  32 */     this.id = id;
   }

   public Long getCompanyId() {
/*  36 */     return this.companyId;
   }

   public void setCompanyId(Long companyId) {
/*  40 */     this.companyId = companyId;
   }

   public Long getBrandId() {
/*  44 */     return this.brandId;
   }

   public void setBrandId(Long brandId) {
/*  48 */     this.brandId = brandId;
   }

   public String getAppKey() {
/*  52 */     return this.appKey;
   }

   public String getSecret() {
/*  56 */     return this.secret;
   }

   public String getPlateEntityId() {
/*  60 */     return this.plateEntityId;
   }

   public void setAppKey(String appKey) {
/*  64 */     this.appKey = appKey;
   }

   public void setSecret(String secret) {
/*  68 */     this.secret = secret;
/*     */   }
/*     */   
/*     */   public void setPlateEntityId(String plateEntityId) {
/*  72 */     this.plateEntityId = plateEntityId;
/*     */   }
/*     */   
/*     */   public String getChainEntityId() {
/*  76 */     return this.chainEntityId;
/*     */   }
/*     */   
/*     */   public void setChainEntityId(String chainEntityId) {
/*  80 */     this.chainEntityId = chainEntityId;
/*     */   }
/*     */   
/*     */   public Date getCreateTime() {
/*  84 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public Date getUpdateTime() {
/*  88 */     return this.updateTime;
/*     */   }
/*     */   
/*     */   public Long getCreateId() {
/*  92 */     return this.createId;
/*     */   }
/*     */   
/*     */   public Long getUpdateId() {
/*  96 */     return this.updateId;
/*     */   }
/*     */   
/*     */   public Integer getIsDeleted() {
/* 100 */     return this.isDeleted;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Date createTime) {
/* 104 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public void setUpdateTime(Date updateTime) {
/* 108 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */   public void setCreateId(Long createId) {
/* 112 */     this.createId = createId;
/*     */   }
/*     */   
/*     */   public void setUpdateId(Long updateId) {
/* 116 */     this.updateId = updateId;
/*     */   }
/*     */   
/*     */   public void setIsDeleted(Integer isDeleted) {
/* 120 */     this.isDeleted = isDeleted;
/*     */   }
/*     */ }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\BrandDfireConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */