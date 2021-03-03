 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;


























 public class Banner
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -5270570434188775939L;
   public static final int MALL_TYPE_SCORE = 1;
   public static final int MALL_TYPE_ONLINE = 2;
   private Long id;
   private Long companyId;
   private Long brandId;
   private Long provinceId;
   private Long cityId;
   private Long countyId;
   private Long wechatConfigId;
   private String name;
   private Integer showOrder;
   private String url;
   private Integer status;
   private Integer mallType;
   private Long createId;
   private Date createTime;
   private Long updateId;
   private Date updateTime;
   private Integer isDeleted;

   public Long getId() {
/*  56 */     return this.id;
   }

   public void setId(Long id) {
/*  60 */     this.id = id;
   }
/*     */   
/*     */   public Long getCompanyId() {
/*  64 */     return this.companyId;
/*     */   }
/*     */   
/*     */   public void setCompanyId(Long companyId) {
/*  68 */     this.companyId = companyId;
/*     */   }
/*     */   
/*     */   public Long getBrandId() {
/*  72 */     return this.brandId;
/*     */   }
/*     */   
/*     */   public void setBrandId(Long brandId) {
/*  76 */     this.brandId = brandId;
/*     */   }
/*     */   
/*     */   public Long getProvinceId() {
/*  80 */     return this.provinceId;
/*     */   }
/*     */   
/*     */   public void setProvinceId(Long provinceId) {
/*  84 */     this.provinceId = provinceId;
/*     */   }
/*     */   
/*     */   public Long getCityId() {
/*  88 */     return this.cityId;
/*     */   }
/*     */   
/*     */   public void setCityId(Long cityId) {
/*  92 */     this.cityId = cityId;
/*     */   }
/*     */   
/*     */   public Long getCountyId() {
/*  96 */     return this.countyId;
/*     */   }
/*     */   
/*     */   public void setCountyId(Long countyId) {
/* 100 */     this.countyId = countyId;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 104 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 108 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getUrl() {
/* 112 */     return this.url;
/*     */   }
/*     */   
/*     */   public void setUrl(String url) {
/* 116 */     this.url = url;
/*     */   }
/*     */   
/*     */   public Integer getStatus() {
/* 120 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 124 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Long getCreateId() {
/* 128 */     return this.createId;
/*     */   }
/*     */   
/*     */   public void setCreateId(Long createId) {
/* 132 */     this.createId = createId;
/*     */   }
/*     */   
/*     */   public Date getCreateTime() {
/* 136 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Date createTime) {
/* 140 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public Date getUpdateTime() {
/* 144 */     return this.updateTime;
/*     */   }
/*     */   
/*     */   public void setUpdateTime(Date updateTime) {
/* 148 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */   public Integer getIsDeleted() {
/* 152 */     return this.isDeleted;
/*     */   }
/*     */   
/*     */   public void setIsDeleted(Integer isDeleted) {
/* 156 */     this.isDeleted = isDeleted;
/*     */   }
/*     */   
/*     */   public Long getUpdateId() {
/* 160 */     return this.updateId;
/*     */   }
/*     */   
/*     */   public void setUpdateId(Long updateId) {
/* 164 */     this.updateId = updateId;
/*     */   }
/*     */   
/*     */   public Long getWechatConfigId() {
/* 168 */     return this.wechatConfigId;
/*     */   }
/*     */   
/*     */   public Integer getShowOrder() {
/* 172 */     return this.showOrder;
/*     */   }
/*     */   
/*     */   public void setWechatConfigId(Long wechatConfigId) {
/* 176 */     this.wechatConfigId = wechatConfigId;
/*     */   }
/*     */   
/*     */   public void setShowOrder(Integer showOrder) {
/* 180 */     this.showOrder = showOrder;
/*     */   }
/*     */   
/*     */   public String getStatusName() {
/* 184 */     if (this.status != null && this.status.intValue() == 1) {
/* 185 */       return "是";
/*     */     }
/* 187 */     return "否";
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getMallType() {
/* 192 */     return this.mallType;
/*     */   }
/*     */   
/*     */   public void setMallType(Integer mallType) {
/* 196 */     this.mallType = mallType;
/*     */   }
/*     */   
/*     */   public String getMallTypeName() {
/* 200 */     if (this.mallType == null)
/* 201 */       return "未知"; 
/* 202 */     if (this.mallType.intValue() == 1)
/* 203 */       return "积分商城"; 
/* 204 */     if (this.mallType.intValue() == 2) {
/* 205 */       return "在线商城";
/*     */     }
/* 207 */     return "未知";
/*     */   }
/*     */ }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\Banner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */