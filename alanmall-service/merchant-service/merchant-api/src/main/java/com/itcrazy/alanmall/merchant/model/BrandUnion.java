 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;



































 public class BrandUnion
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 8153682974962741936L;
   private Long id;
   private Long srcBrandId;
   private Long dstBrandId;
   private Integer showOrder;
   private Date createTime;
   private Date updateTime;
   private Long createId;
   private Long updateId;
   private Integer isDeleted;
   private String companyName;
   private String brandName;
   private Date serviceTime;
   private Integer isBind;

   public Long getId() {
/*  59 */     return this.id;
   }

   public void setId(Long id) {
/*  63 */     this.id = id;
   }

   public Long getSrcBrandId() {
/*  67 */     return this.srcBrandId;
   }

   public void setSrcBrandId(Long srcBrandId) {
/*  71 */     this.srcBrandId = srcBrandId;
   }

   public Long getDstBrandId() {
/*  75 */     return this.dstBrandId;
   }

   public void setDstBrandId(Long dstBrandId) {
/*  79 */     this.dstBrandId = dstBrandId;
   }

   public Integer getShowOrder() {
/*  83 */     return this.showOrder;
   }

   public void setShowOrder(Integer showOrder) {
/*  87 */     this.showOrder = showOrder;
   }

   public Date getCreateTime() {
/*  91 */     return this.createTime;
   }

   public void setCreateTime(Date createTime) {
/*  95 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public Date getUpdateTime() {
/*  99 */     return this.updateTime;
/*     */   }
/*     */   
/*     */   public void setUpdateTime(Date updateTime) {
/* 103 */     this.updateTime = updateTime;
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
/*     */   public Long getUpdateId() {
/* 115 */     return this.updateId;
/*     */   }
/*     */   
/*     */   public void setUpdateId(Long updateId) {
/* 119 */     this.updateId = updateId;
/*     */   }
/*     */   
/*     */   public Integer getIsDeleted() {
/* 123 */     return this.isDeleted;
/*     */   }
/*     */   
/*     */   public void setIsDeleted(Integer isDeleted) {
/* 127 */     this.isDeleted = isDeleted;
/*     */   }
/*     */   
/*     */   public String getCompanyName() {
/* 131 */     return this.companyName;
/*     */   }
/*     */   
/*     */   public void setCompanyName(String companyName) {
/* 135 */     this.companyName = companyName;
/*     */   }
/*     */   
/*     */   public String getBrandName() {
/* 139 */     return this.brandName;
/*     */   }
/*     */   
/*     */   public void setBrandName(String brandName) {
/* 143 */     this.brandName = brandName;
/*     */   }
/*     */   
/*     */   public Date getServiceTime() {
/* 147 */     return this.serviceTime;
/*     */   }
/*     */   
/*     */   public void setServiceTime(Date serviceTime) {
/* 151 */     this.serviceTime = serviceTime;
/*     */   }
/*     */   
/*     */   public Integer getIsBind() {
/* 155 */     return this.isBind;
/*     */   }
/*     */   
/*     */   public void setIsBind(Integer isBind) {
/* 159 */     this.isBind = isBind;
/*     */   }
/*     */ }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\BrandUnion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */