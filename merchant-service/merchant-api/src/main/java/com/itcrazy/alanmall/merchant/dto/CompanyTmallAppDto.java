 package com.itcrazy.alanmall.merchant.dto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;
 import java.util.Date;

 public class CompanyTmallAppDto
   extends BaseDto
 {
   private static final long serialVersionUID = 808505220185156789L;
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

   public Long getId() {
/*  25 */     return this.id;
   }

   public void setId(Long id) {
/*  29 */     this.id = id;
   }

   public Long getCompanyId() {
/*  33 */     return this.companyId;
   }

   public void setCompanyId(Long companyId) {
/*  37 */     this.companyId = companyId;
   }

   public Long getBrandId() {
/*  41 */     return this.brandId;
   }

   public void setBrandId(Long brandId) {
/*  45 */     this.brandId = brandId;
   }

   public Date getCreateTime() {
/*  49 */     return this.createTime;
   }

   public void setCreateTime(Date createTime) {
/*  53 */     this.createTime = createTime;
   }

   public Long getCreateId() {
/*  57 */     return this.createId;
   }

   public void setCreateId(Long createId) {
/*  61 */     this.createId = createId;
   }

   public Date getUpdateTime() {
/*  65 */     return this.updateTime;
   }

   public void setUpdateTime(Date updateTime) {
/*  69 */     this.updateTime = updateTime;
   }

   public Long getUpdateId() {
/*  73 */     return this.updateId;
   }

   public void setUpdateId(Long updateId) {
/*  77 */     this.updateId = updateId;
   }

   public Integer getIsDeleted() {
/*  81 */     return this.isDeleted;
   }

   public void setIsDeleted(Integer isDeleted) {
/*  85 */     this.isDeleted = isDeleted;
   }

   public String getAppKey() {
/*  89 */     return this.appKey;
   }

   public void setAppKey(String appKey) {
/*  93 */     this.appKey = appKey;
   }

/*     */   public String getAppSecret() {
/*  97 */     return this.appSecret;
/*     */   }
/*     */   
/*     */   public void setAppSecret(String appSecret) {
/* 101 */     this.appSecret = appSecret;
/*     */   }
/*     */   
/*     */   public String getAppName() {
/* 105 */     return this.appName;
/*     */   }
/*     */   
/*     */   public void setAppName(String appName) {
/* 109 */     this.appName = appName;
/*     */   }
/*     */ }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\dto\CompanyTmallAppDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */