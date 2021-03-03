 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;







































 public class BrandAdvertisement
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -7482732075124820094L;
   public static final int SHOW_ORDER_DEFAULT = 99;
   private Long id;
   private Long companyId;
   private Long brandId;
   private String title;
   private String articalUrl;
   private String remark;
   private Integer isActive;
   private Date createTime;
   private Date updateTime;
   private Long createId;
   private Long updateId;
   private Integer isDeleted;
   private Integer showOrder;
   private String serverUrl;
   private String originalUrl;

   public Long getId() {
/*  66 */     return this.id;
   }

   public void setId(Long id) {
/*  70 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Long getBrandId() {
/*  74 */     return this.brandId;
/*     */   }
/*     */   
/*     */   public void setBrandId(Long brandId) {
/*  78 */     this.brandId = brandId;
/*     */   }
/*     */   
/*     */   public String getTitle() {
/*  82 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(String title) {
/*  86 */     this.title = title;
/*     */   }
/*     */   
/*     */   public String getArticalUrl() {
/*  90 */     return this.articalUrl;
/*     */   }
/*     */   
/*     */   public void setArticalUrl(String articalUrl) {
/*  94 */     this.articalUrl = articalUrl;
/*     */   }
/*     */   
/*     */   public String getRemark() {
/*  98 */     return this.remark;
/*     */   }
/*     */   
/*     */   public void setRemark(String remark) {
/* 102 */     this.remark = remark;
/*     */   }
/*     */   
/*     */   public Integer getIsActive() {
/* 106 */     return this.isActive;
/*     */   }
/*     */   
/*     */   public void setIsActive(Integer isActive) {
/* 110 */     this.isActive = isActive;
/*     */   }
/*     */   
/*     */   public Date getCreateTime() {
/* 114 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Date createTime) {
/* 118 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public Date getUpdateTime() {
/* 122 */     return this.updateTime;
/*     */   }
/*     */   
/*     */   public void setUpdateTime(Date updateTime) {
/* 126 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */   public Long getCreateId() {
/* 130 */     return this.createId;
/*     */   }
/*     */   
/*     */   public void setCreateId(Long createId) {
/* 134 */     this.createId = createId;
/*     */   }
/*     */   
/*     */   public Long getUpdateId() {
/* 138 */     return this.updateId;
/*     */   }
/*     */   
/*     */   public void setUpdateId(Long updateId) {
/* 142 */     this.updateId = updateId;
/*     */   }
/*     */   
/*     */   public Integer getIsDeleted() {
/* 146 */     return this.isDeleted;
/*     */   }
/*     */   
/*     */   public void setIsDeleted(Integer isDeleted) {
/* 150 */     this.isDeleted = isDeleted;
/*     */   }
/*     */   
/*     */   public String getActiveStatus() {
/* 154 */     if (this.isActive.intValue() == 1)
/* 155 */       return "启用"; 
/* 156 */     if (this.isActive.intValue() == 0) {
/* 157 */       return "未启用";
/*     */     }
/* 159 */     return "未知";
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getShowOrder() {
/* 164 */     return this.showOrder;
/*     */   }
/*     */   
/*     */   public void setShowOrder(Integer showOrder) {
/* 168 */     this.showOrder = showOrder;
/*     */   }
/*     */   
/*     */   public Long getCompanyId() {
/* 172 */     return this.companyId;
/*     */   }
/*     */   
/*     */   public void setCompanyId(Long companyId) {
/* 176 */     this.companyId = companyId;
/*     */   }
/*     */   
/*     */   public String getServerUrl() {
/* 180 */     return this.serverUrl;
/*     */   }
/*     */   
/*     */   public void setServerUrl(String serverUrl) {
/* 184 */     this.serverUrl = serverUrl;
/*     */   }
/*     */   
/*     */   public String getOriginalUrl() {
/* 188 */     return this.originalUrl;
/*     */   }
/*     */   
/*     */   public void setOriginalUrl(String originalUrl) {
/* 192 */     this.originalUrl = originalUrl;
/*     */   }
/*     */ }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\BrandAdvertisement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */