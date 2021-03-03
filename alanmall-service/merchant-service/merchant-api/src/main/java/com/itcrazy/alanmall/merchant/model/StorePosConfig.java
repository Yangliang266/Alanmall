 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;





 public class StorePosConfig
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -2490203201702458245L;
   private Long id;
   private Long companyId;
   private Long brandId;
   private Long storeId;
   private Integer posCode;
   private String posStoreCode;
   private String posNotifyUrl;
   private Integer seq;
   private Date createTime;
   private Date updateTime;
   private Long createId;
   private Long updateId;
   private Integer isDeleted;

   public Long getId() {
/*  29 */     return this.id;
   }

   public Long getCompanyId() {
/*  33 */     return this.companyId;
   }

   public Long getBrandId() {
/*  37 */     return this.brandId;
   }
/*     */   
/*     */   public Long getStoreId() {
/*  41 */     return this.storeId;
/*     */   }
/*     */   
/*     */   public Integer getPosCode() {
/*  45 */     return this.posCode;
/*     */   }
/*     */   
/*     */   public String getPosStoreCode() {
/*  49 */     return this.posStoreCode;
/*     */   }
/*     */   
/*     */   public String getPosNotifyUrl() {
/*  53 */     return this.posNotifyUrl;
/*     */   }
/*     */   
/*     */   public Integer getSeq() {
/*  57 */     return this.seq;
/*     */   }
/*     */   
/*     */   public Date getCreateTime() {
/*  61 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public Date getUpdateTime() {
/*  65 */     return this.updateTime;
/*     */   }
/*     */   
/*     */   public Long getCreateId() {
/*  69 */     return this.createId;
/*     */   }
/*     */   
/*     */   public Long getUpdateId() {
/*  73 */     return this.updateId;
/*     */   }
/*     */   
/*     */   public Integer getIsDeleted() {
/*  77 */     return this.isDeleted;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  81 */     this.id = id;
/*     */   }
/*     */   
/*     */   public void setCompanyId(Long companyId) {
/*  85 */     this.companyId = companyId;
/*     */   }
/*     */   
/*     */   public void setBrandId(Long brandId) {
/*  89 */     this.brandId = brandId;
/*     */   }
/*     */   
/*     */   public void setStoreId(Long storeId) {
/*  93 */     this.storeId = storeId;
/*     */   }
/*     */   
/*     */   public void setPosCode(Integer posCode) {
/*  97 */     this.posCode = posCode;
/*     */   }
/*     */   
/*     */   public void setPosStoreCode(String posStoreCode) {
/* 101 */     this.posStoreCode = posStoreCode;
/*     */   }
/*     */   
/*     */   public void setPosNotifyUrl(String posNotifyUrl) {
/* 105 */     this.posNotifyUrl = posNotifyUrl;
/*     */   }
/*     */   
/*     */   public void setSeq(Integer seq) {
/* 109 */     this.seq = seq;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Date createTime) {
/* 113 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public void setUpdateTime(Date updateTime) {
/* 117 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */   public void setCreateId(Long createId) {
/* 121 */     this.createId = createId;
/*     */   }
/*     */   
/*     */   public void setUpdateId(Long updateId) {
/* 125 */     this.updateId = updateId;
/*     */   }
/*     */   
/*     */   public void setIsDeleted(Integer isDeleted) {
/* 129 */     this.isDeleted = isDeleted;
/*     */   }
/*     */ }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\StorePosConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */