 package com.itcrazy.alanmall.merchant.dto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;
 import java.math.BigDecimal;
 import java.util.Date;

 public class StoreDto
   extends BaseDto
 {
   private static final long serialVersionUID = 2280033766288746938L;
   private String name;
   private Long provinceId;
   private Long cityId;
   private Long countyId;
   private Long companyId;
   private Long brandId;
   private String brandIds;
   private Integer status;
   private Integer dishStatus;
   private Date updateStartTime;
   private String keyWord;
   private String[] keyWordList;
   private Long businessCircleId;
   private Long cuisineId;
   private Long cuisineClassId;
   private Long eatObjectId;
   private String hotDesc;
   private String distinceAsc;
   private String avgAmountAsc;
   private String avgAmountDesc;
   private BigDecimal latitude;
   private BigDecimal longitude;
   private Integer source;
   private String sourceCode;
   private Long wechatConfigId;
   private String orderDate;
   private Long storeTimeType;
   private Integer isWechatActivityBrand;
   private Integer isVirtual;
   private Long createId;
   private Integer orderWay;
   private Integer wxAvailableState;
   private Integer wxUpdateStatus;
   private Long poiId;

   public String getName() {
/*  61 */     return this.name;
   }

   public void setName(String name) {
/*  65 */     this.name = name;
   }

   public Long getProvinceId() {
/*  69 */     return this.provinceId;
   }

   public void setProvinceId(Long provinceId) {
/*  73 */     this.provinceId = provinceId;
   }

   public Long getCityId() {
/*  77 */     return this.cityId;
   }

   public void setCityId(Long cityId) {
/*  81 */     this.cityId = cityId;
   }

   public Long getCountyId() {
/*  85 */     return this.countyId;
   }

/*     */   public void setCountyId(Long countyId) {
/*  89 */     this.countyId = countyId;
/*     */   }
/*     */   
/*     */   public Long getCompanyId() {
/*  93 */     return this.companyId;
/*     */   }
/*     */   
/*     */   public void setCompanyId(Long companyId) {
/*  97 */     this.companyId = companyId;
/*     */   }
/*     */   
/*     */   public Long getBrandId() {
/* 101 */     return this.brandId;
/*     */   }
/*     */   
/*     */   public void setBrandId(Long brandId) {
/* 105 */     this.brandId = brandId;
/*     */   }
/*     */   
/*     */   public Integer getStatus() {
/* 109 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 113 */     this.status = status;
/*     */   }
/*     */   
/*     */   public String getKeyWord() {
/* 117 */     return this.keyWord;
/*     */   }
/*     */   
/*     */   public void setKeyWord(String keyWord) {
/* 121 */     this.keyWord = keyWord;
/*     */   }
/*     */   
/*     */   public String[] getKeyWordList() {
/* 125 */     return this.keyWordList;
/*     */   }
/*     */   
/*     */   public void setKeyWordList(String[] keyWordList) {
/* 129 */     this.keyWordList = keyWordList;
/*     */   }
/*     */   
/*     */   public Long getBusinessCircleId() {
/* 133 */     return this.businessCircleId;
/*     */   }
/*     */   
/*     */   public void setBusinessCircleId(Long businessCircleId) {
/* 137 */     this.businessCircleId = businessCircleId;
/*     */   }
/*     */   
/*     */   public Long getCuisineId() {
/* 141 */     return this.cuisineId;
/*     */   }
/*     */   
/*     */   public void setCuisineId(Long cuisineId) {
/* 145 */     this.cuisineId = cuisineId;
/*     */   }
/*     */   
/*     */   public Long getEatObjectId() {
/* 149 */     return this.eatObjectId;
/*     */   }
/*     */   
/*     */   public void setEatObjectId(Long eatObjectId) {
/* 153 */     this.eatObjectId = eatObjectId;
/*     */   }
/*     */   
/*     */   public Date getUpdateStartTime() {
/* 157 */     return this.updateStartTime;
/*     */   }
/*     */   
/*     */   public void setUpdateStartTime(Date updateStartTime) {
/* 161 */     this.updateStartTime = updateStartTime;
/*     */   }
/*     */   
/*     */   public Long getCuisineClassId() {
/* 165 */     return this.cuisineClassId;
/*     */   }
/*     */   
/*     */   public void setCuisineClassId(Long cuisineClassId) {
/* 169 */     this.cuisineClassId = cuisineClassId;
/*     */   }
/*     */   
/*     */   public void setInterfaceSearch(Integer searchSort) {
/* 173 */     if (searchSort == null) {
/*     */       return;
/*     */     }
/* 176 */     if (searchSort.intValue() == 1) {
/* 177 */       this.distinceAsc = "true";
/*     */     }
/* 179 */     if (searchSort.intValue() == 2) {
/* 180 */       this.hotDesc = "true";
/*     */     }
/* 182 */     if (searchSort.intValue() == 3) {
/* 183 */       this.avgAmountDesc = "true";
/*     */     }
/* 185 */     if (searchSort.intValue() == 4) {
/* 186 */       this.avgAmountAsc = "true";
/*     */     }
/*     */   }
/*     */   
/*     */   public String getHotDesc() {
/* 191 */     return this.hotDesc;
/*     */   }
/*     */   
/*     */   public void setHotDesc(String hotDesc) {
/* 195 */     this.hotDesc = hotDesc;
/*     */   }
/*     */   
/*     */   public String getDistinceAsc() {
/* 199 */     return this.distinceAsc;
/*     */   }
/*     */   
/*     */   public void setDistinceAsc(String distinceAsc) {
/* 203 */     this.distinceAsc = distinceAsc;
/*     */   }
/*     */   
/*     */   public BigDecimal getLatitude() {
/* 207 */     return this.latitude;
/*     */   }
/*     */   
/*     */   public void setLatitude(BigDecimal latitude) {
/* 211 */     this.latitude = latitude;
/*     */   }
/*     */   
/*     */   public BigDecimal getLongitude() {
/* 215 */     return this.longitude;
/*     */   }
/*     */   
/*     */   public void setLongitude(BigDecimal longitude) {
/* 219 */     this.longitude = longitude;
/*     */   }
/*     */   
/*     */   public String getAvgAmountAsc() {
/* 223 */     return this.avgAmountAsc;
/*     */   }
/*     */   
/*     */   public void setAvgAmountAsc(String avgAmountAsc) {
/* 227 */     this.avgAmountAsc = avgAmountAsc;
/*     */   }
/*     */   
/*     */   public String getAvgAmountDesc() {
/* 231 */     return this.avgAmountDesc;
/*     */   }
/*     */   
/*     */   public void setAvgAmountDesc(String avgAmountDesc) {
/* 235 */     this.avgAmountDesc = avgAmountDesc;
/*     */   }
/*     */   
/*     */   public Integer getDishStatus() {
/* 239 */     return this.dishStatus;
/*     */   }
/*     */   
/*     */   public void setDishStatus(Integer dishStatus) {
/* 243 */     this.dishStatus = dishStatus;
/*     */   }
/*     */   
/*     */   public Integer getSource() {
/* 247 */     return this.source;
/*     */   }
/*     */   
/*     */   public void setSource(Integer source) {
/* 251 */     this.source = source;
/*     */   }
/*     */   
/*     */   public String getSourceCode() {
/* 255 */     return this.sourceCode;
/*     */   }
/*     */   
/*     */   public void setSourceCode(String sourceCode) {
/* 259 */     this.sourceCode = sourceCode;
/*     */   }
/*     */   
/*     */   public Long getWechatConfigId() {
/* 263 */     return this.wechatConfigId;
/*     */   }
/*     */   
/*     */   public void setWechatConfigId(Long wechatConfigId) {
/* 267 */     this.wechatConfigId = wechatConfigId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getStoreTimeType() {
/* 279 */     return this.storeTimeType;
/*     */   }
/*     */   
/*     */   public String getOrderDate() {
/* 283 */     return this.orderDate;
/*     */   }
/*     */   
/*     */   public void setOrderDate(String orderDate) {
/* 287 */     this.orderDate = orderDate;
/*     */   }
/*     */   
/*     */   public void setStoreTimeType(Long storeTimeType) {
/* 291 */     this.storeTimeType = storeTimeType;
/*     */   }
/*     */   
/*     */   public Integer getIsWechatActivityBrand() {
/* 295 */     return this.isWechatActivityBrand;
/*     */   }
/*     */   
/*     */   public void setIsWechatActivityBrand(Integer isWechatActivityBrand) {
/* 299 */     this.isWechatActivityBrand = isWechatActivityBrand;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getBrandIds() {
/* 304 */     return this.brandIds;
/*     */   }
/*     */   
/*     */   public void setBrandIds(String brandIds) {
/* 308 */     this.brandIds = brandIds;
/*     */   }
/*     */   
/*     */   public Long getCreateId() {
/* 312 */     return this.createId;
/*     */   }
/*     */   
/*     */   public void setCreateId(Long createId) {
/* 316 */     this.createId = createId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getIsVirtual() {
/* 323 */     return this.isVirtual;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIsVirtual(Integer isVirtual) {
/* 330 */     this.isVirtual = isVirtual;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getWxAvailableState() {
/* 337 */     return this.wxAvailableState;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWxAvailableState(Integer wxAvailableState) {
/* 344 */     this.wxAvailableState = wxAvailableState;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getWxUpdateStatus() {
/* 351 */     return this.wxUpdateStatus;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWxUpdateStatus(Integer wxUpdateStatus) {
/* 358 */     this.wxUpdateStatus = wxUpdateStatus;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getPoiId() {
/* 365 */     return this.poiId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPoiId(Long poiId) {
/* 372 */     this.poiId = poiId;
/*     */   }
/*     */   
/*     */   public Integer getOrderWay() {
/* 376 */     return this.orderWay;
/*     */   }
/*     */   
/*     */   public void setOrderWay(Integer orderWay) {
/* 380 */     this.orderWay = orderWay;
/*     */   }
/*     */ }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\dto\StoreDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */