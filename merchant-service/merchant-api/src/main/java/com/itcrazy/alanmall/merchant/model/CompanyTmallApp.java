 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;



 public class CompanyTmallApp
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 255505220185156789L;
/*  12 */   public static int TYPE_1 = 1;
/*  13 */   public static int TYPE_2 = 2;
   private Long id;
   private Long companyId;
   private Long brandId;
   private Date createTime;
   private Long createId;
   private Date updateTime;
   private Long updateId;
   private Integer isDeleted;
   private String appKey;
   private String appSecret;
   private String appName;
   private Integer appType;

   public Integer getAppType() {
/*  28 */     return this.appType;
   }

   public void setAppType(Integer appType) {
/*  32 */     this.appType = appType;
   }

   public Long getId() {
/*  36 */     return this.id;
   }

   public void setId(Long id) {
/*  40 */     this.id = id;
   }

   public Long getCompanyId() {
/*  44 */     return this.companyId;
   }

   public void setCompanyId(Long companyId) {
/*  48 */     this.companyId = companyId;
   }

   public Long getBrandId() {
/*  52 */     return this.brandId;
   }

   public void setBrandId(Long brandId) {
/*  56 */     this.brandId = brandId;
   }

   public Date getCreateTime() {
/*  60 */     return this.createTime;
   }

   public void setCreateTime(Date createTime) {
/*  64 */     this.createTime = createTime;
   }

   public Long getCreateId() {
/*  68 */     return this.createId;
   }

   public void setCreateId(Long createId) {
/*  72 */     this.createId = createId;
   }

   public Date getUpdateTime() {
/*  76 */     return this.updateTime;
   }

   public void setUpdateTime(Date updateTime) {
/*  80 */     this.updateTime = updateTime;
   }

   public Long getUpdateId() {
/*  84 */     return this.updateId;
   }

   public void setUpdateId(Long updateId) {
/*  88 */     this.updateId = updateId;
   }

   public Integer getIsDeleted() {
/*  92 */     return this.isDeleted;
   }

   public void setIsDeleted(Integer isDeleted) {
/*  96 */     this.isDeleted = isDeleted;
   }

   public String getAppKey() {
/* 100 */     return this.appKey;
/*     */   }
/*     */   
/*     */   public void setAppKey(String appKey) {
/* 104 */     this.appKey = appKey;
/*     */   }
/*     */   
/*     */   public String getAppSecret() {
/* 108 */     return this.appSecret;
/*     */   }
/*     */   
/*     */   public void setAppSecret(String appSecret) {
/* 112 */     this.appSecret = appSecret;
/*     */   }
/*     */   
/*     */   public String getAppName() {
/* 116 */     return this.appName;
/*     */   }
/*     */   
/*     */   public void setAppName(String appName) {
/* 120 */     this.appName = appName;
/*     */   }
/*     */ }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\CompanyTmallApp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */