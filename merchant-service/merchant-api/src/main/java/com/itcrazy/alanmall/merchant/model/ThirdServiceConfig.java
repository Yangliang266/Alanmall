 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;

 public class ThirdServiceConfig
   extends BaseModelAdapter {
   private static final long serialVersionUID = 9165356253864589310L;
   private Long id;
   private Long companyId;
   private Long brandId;
   private Long storeId;
   private String service;
   private String description;
   private String linkUrl;
   private String linkLabel;
   private Integer type;
   private Integer status;
   private Date createTime;
   private Date updateTime;
   private Long createId;
   private Long updateId;
   private Integer isDeleted;

   public Long getId() {
/*  26 */     return this.id;
   }
   public Long getCompanyId() {
/*  29 */     return this.companyId;
   }
   public Long getBrandId() {
/*  32 */     return this.brandId;
   }
   public Long getStoreId() {
/*  35 */     return this.storeId;
   }
   public String getService() {
/*  38 */     return this.service;
   }
   public String getDescription() {
/*  41 */     return this.description;
   }
   public String getLinkUrl() {
/*  44 */     return this.linkUrl;
   }
   public String getLinkLabel() {
/*  47 */     return this.linkLabel;
   }
   public Integer getType() {
/*  50 */     return this.type;
   }
   public Integer getStatus() {
/*  53 */     return this.status;
   }
   public Date getCreateTime() {
/*  56 */     return this.createTime;
   }
   public Date getUpdateTime() {
/*  59 */     return this.updateTime;
   }
   public Long getCreateId() {
/*  62 */     return this.createId;
/*     */   }
/*     */   public Long getUpdateId() {
/*  65 */     return this.updateId;
/*     */   }
/*     */   public Integer getIsDeleted() {
/*  68 */     return this.isDeleted;
/*     */   }
/*     */   public void setId(Long id) {
/*  71 */     this.id = id;
/*     */   }
/*     */   public void setCompanyId(Long companyId) {
/*  74 */     this.companyId = companyId;
/*     */   }
/*     */   public void setBrandId(Long brandId) {
/*  77 */     this.brandId = brandId;
/*     */   }
/*     */   public void setStoreId(Long storeId) {
/*  80 */     this.storeId = storeId;
/*     */   }
/*     */   public void setService(String service) {
/*  83 */     this.service = service;
/*     */   }
/*     */   public void setDescription(String description) {
/*  86 */     this.description = description;
/*     */   }
/*     */   public void setLinkUrl(String linkUrl) {
/*  89 */     this.linkUrl = linkUrl;
/*     */   }
/*     */   public void setLinkLabel(String linkLabel) {
/*  92 */     this.linkLabel = linkLabel;
/*     */   }
/*     */   public void setType(Integer type) {
/*  95 */     this.type = type;
/*     */   }
/*     */   public void setStatus(Integer status) {
/*  98 */     this.status = status;
/*     */   }
/*     */   public void setCreateTime(Date createTime) {
/* 101 */     this.createTime = createTime;
/*     */   }
/*     */   public void setUpdateTime(Date updateTime) {
/* 104 */     this.updateTime = updateTime;
/*     */   }
/*     */   public void setCreateId(Long createId) {
/* 107 */     this.createId = createId;
/*     */   }
/*     */   public void setUpdateId(Long updateId) {
/* 110 */     this.updateId = updateId;
/*     */   }
/*     */   public void setIsDeleted(Integer isDeleted) {
/* 113 */     this.isDeleted = isDeleted;
/*     */   }
/*     */ }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\ThirdServiceConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */