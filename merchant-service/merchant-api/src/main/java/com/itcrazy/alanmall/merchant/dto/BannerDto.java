 package com.itcrazy.alanmall.merchant.dto;


 import com.itcrazy.alanmall.common.framework.dto.BaseDto;

 public class BannerDto
   extends BaseDto
 {
   private static final long serialVersionUID = 245936556168457059L;
   private Long companyId;
   private Long brandId;
   private Long provinceId;
   private Long cityId;
   private Long countyId;
   private Integer status;
   private String name;
   private Long wechatConfigId;
   private Integer mallType;

   public Long getProvinceId() {
/*  33 */     return this.provinceId;
   }

   public void setProvinceId(Long provinceId) {
/*  37 */     this.provinceId = provinceId;
   }

   public Long getCityId() {
/*  41 */     return this.cityId;
   }

   public void setCityId(Long cityId) {
/*  45 */     this.cityId = cityId;
   }

   public Long getCountyId() {
/*  49 */     return this.countyId;
   }

   public void setCountyId(Long countyId) {
/*  53 */     this.countyId = countyId;
   }

   public String getName() {
/*  57 */     return this.name;
   }

   public void setName(String name) {
/*  61 */     this.name = name;
   }

   public Integer getStatus() {
/*  65 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/*  69 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Long getCompanyId() {
/*  73 */     return this.companyId;
/*     */   }
/*     */   
/*     */   public void setCompanyId(Long companyId) {
/*  77 */     this.companyId = companyId;
/*     */   }
/*     */   
/*     */   public Long getBrandId() {
/*  81 */     return this.brandId;
/*     */   }
/*     */   
/*     */   public void setBrandId(Long brandId) {
/*  85 */     this.brandId = brandId;
/*     */   }
/*     */   
/*     */   public Long getWechatConfigId() {
/*  89 */     return this.wechatConfigId;
/*     */   }
/*     */   
/*     */   public void setWechatConfigId(Long wechatConfigId) {
/*  93 */     this.wechatConfigId = wechatConfigId;
/*     */   }
/*     */   
/*     */   public Integer getMallType() {
/*  97 */     return this.mallType;
/*     */   }
/*     */   
/*     */   public void setMallType(Integer mallType) {
/* 101 */     this.mallType = mallType;
/*     */   }
/*     */ }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\dto\BannerDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */