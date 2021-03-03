 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.client.util.DateFormat;
 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.math.BigDecimal;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.Map;



















 public class Store
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -2899533546887175546L;
   public static final int STATUS_NEED_CHECK = 1;
   public static final int STATUS_NOT_PASS = 2;
   public static final int STATUS_OVERDUE = 11;
   public static final int STATUS_DISABLE = 21;
   public static final int WX_STATUS_SYSTEM_ERROR = 1;
   public static final int WX_STATUS_CHECKING = 2;
   public static final int WX_STATUS_CHECK_SUCC = 3;
/*     */   public static final int WX_STATUS_CHECK_FAIL = 4;
/*     */   public static final int IS_DELETED = 1;
/*     */   private Long id;
/*     */   private Long companyId;
/*     */   private Long brandId;
/*     */   private Long provinceId;
/*     */   private Long cityId;
/*     */   private Long countyId;
/*     */   private String address;
/*     */   private String name;
/*     */   private Long businessCircleId;
/*     */   private Long landMarkId;
/*     */   private Integer avgAmount;
/*     */   private String trafficRoutes;
/*     */   private String zip;
/*     */   private String linkMan;
/*     */   private String telephone;
/*     */   private String mobile;
/*     */   private String description;
/*     */   private Integer status;
/*     */   private Integer isSlotcard;
/*     */   private String landmark;
/*     */   private String picture;
/*     */   private Integer businessStatus;
/*     */   private BigDecimal longitude;
/*     */   private BigDecimal latitude;
/*     */   private String supportCard;
/*     */   private String parkInfo;
/*     */   private String businessTime;
/*     */   private String businessTimeWeekend;
/*     */   private Date serviceTime;
/*     */   private String serviceTimeName;
/*     */   private Integer source;
/*     */   private String sourceCode;
/*     */   private String takeOutCode;
/*     */   private Integer promSubsidy;
/*     */   private String promSubsidyKey;
/*     */   private Date createTime;
/*     */   private Long createId;
/*     */   private Long updateId;
/*     */   private String idKey;
/*     */   private String storeType;
/*     */   private String brandName;
/*     */   private Integer isVirtual;
/*     */   private String macAddress;
/*     */   private Long iidingyunShopId;
/*     */   private String xpushDid;
/*     */   private Long poiId;
/*     */   private Integer wxAvailableState;
/*     */   private Integer wxUpdateStatus;
/*     */   private String wxMsg;
/*     */   
/*     */   public Long getId() {
/*  92 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  96 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Long getCompanyId() {
/* 100 */     return this.companyId;
/*     */   }
/*     */   
/*     */   public void setCompanyId(Long companyId) {
/* 104 */     this.companyId = companyId;
/*     */   }
/*     */   
/*     */   public Long getBrandId() {
/* 108 */     return this.brandId;
/*     */   }
/*     */   
/*     */   public void setBrandId(Long brandId) {
/* 112 */     this.brandId = brandId;
/*     */   }
/*     */   
/*     */   public Long getCityId() {
/* 116 */     return this.cityId;
/*     */   }
/*     */   
/*     */   public void setCityId(Long cityId) {
/* 120 */     this.cityId = cityId;
/*     */   }
/*     */   
/*     */   public Long getProvinceId() {
/* 124 */     return this.provinceId;
/*     */   }
/*     */   
/*     */   public void setProvinceId(Long provinceId) {
/* 128 */     this.provinceId = provinceId;
/*     */   }
/*     */   
/*     */   public Long getCountyId() {
/* 132 */     return this.countyId;
/*     */   }
/*     */   
/*     */   public void setCountyId(Long countyId) {
/* 136 */     this.countyId = countyId;
/*     */   }
/*     */   
/*     */   public Long getBusinessCircleId() {
/* 140 */     return this.businessCircleId;
/*     */   }
/*     */   
/*     */   public void setBusinessCircleId(Long businessCircleId) {
/* 144 */     this.businessCircleId = businessCircleId;
/*     */   }
/*     */   
/*     */   public Long getLandMarkId() {
/* 148 */     return this.landMarkId;
/*     */   }
/*     */   
/*     */   public void setLandMarkId(Long landMarkId) {
/* 152 */     this.landMarkId = landMarkId;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 156 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 160 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getAddress() {
/* 164 */     return this.address;
/*     */   }
/*     */   
/*     */   public void setAddress(String address) {
/* 168 */     this.address = address;
/*     */   }
/*     */   
/*     */   public String getZip() {
/* 172 */     return this.zip;
/*     */   }
/*     */   
/*     */   public void setZip(String zip) {
/* 176 */     this.zip = zip;
/*     */   }
/*     */   
/*     */   public String getLinkMan() {
/* 180 */     return this.linkMan;
/*     */   }
/*     */   
/*     */   public void setLinkMan(String linkMan) {
/* 184 */     this.linkMan = linkMan;
/*     */   }
/*     */   
/*     */   public String getTelephone() {
/* 188 */     return this.telephone;
/*     */   }
/*     */   
/*     */   public void setTelephone(String telephone) {
/* 192 */     this.telephone = telephone;
/*     */   }
/*     */   
/*     */   public String getMobile() {
/* 196 */     return this.mobile;
/*     */   }
/*     */   
/*     */   public void setMobile(String mobile) {
/* 200 */     this.mobile = mobile;
/*     */   }
/*     */   
/*     */   public Integer getStatus() {
/* 204 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 208 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Long getCreateId() {
/* 212 */     return this.createId;
/*     */   }
/*     */   
/*     */   public void setCreateId(Long createId) {
/* 216 */     this.createId = createId;
/*     */   }
/*     */   
/*     */   public Long getUpdateId() {
/* 220 */     return this.updateId;
/*     */   }
/*     */   
/*     */   public void setUpdateId(Long updateId) {
/* 224 */     this.updateId = updateId;
/*     */   }
/*     */   
/*     */   public String getTrafficRoutes() {
/* 228 */     return this.trafficRoutes;
/*     */   }
/*     */   
/*     */   public void setTrafficRoutes(String trafficRoutes) {
/* 232 */     this.trafficRoutes = trafficRoutes;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 236 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/* 240 */     this.description = description;
/*     */   }
/*     */   
/*     */   public String getLandmark() {
/* 244 */     return this.landmark;
/*     */   }
/*     */   
/*     */   public void setLandmark(String landmark) {
/* 248 */     this.landmark = landmark;
/*     */   }
/*     */   
/*     */   public String getPicture() {
/* 252 */     return this.picture;
/*     */   }
/*     */   
/*     */   public void setPicture(String picture) {
/* 256 */     this.picture = picture;
/*     */   }
/*     */   
/*     */   public Integer getBusinessStatus() {
/* 260 */     return this.businessStatus;
/*     */   }
/*     */   
/*     */   public void setBusinessStatus(Integer businessStatus) {
/* 264 */     this.businessStatus = businessStatus;
/*     */   }
/*     */   
/*     */   public Integer getAvgAmount() {
/* 268 */     return this.avgAmount;
/*     */   }
/*     */   
/*     */   public void setAvgAmount(Integer avgAmount) {
/* 272 */     this.avgAmount = avgAmount;
/*     */   }
/*     */   
/*     */   public BigDecimal getLongitude() {
/* 276 */     return this.longitude;
/*     */   }
/*     */   
/*     */   public void setLongitude(BigDecimal longitude) {
/* 280 */     this.longitude = longitude;
/*     */   }
/*     */   
/*     */   public BigDecimal getLatitude() {
/* 284 */     return this.latitude;
/*     */   }
/*     */   
/*     */   public void setLatitude(BigDecimal latitude) {
/* 288 */     this.latitude = latitude;
/*     */   }
/*     */   
/*     */   public Date getCreateTime() {
/* 292 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Date createTime) {
/* 296 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public Date getServiceTime() {
/* 300 */     return this.serviceTime;
/*     */   }
/*     */   
/*     */   public void setServiceTime(Date serviceTime) {
/* 304 */     this.serviceTime = serviceTime;
/*     */   }
/*     */   
/*     */   public String getBrandName() {
/* 308 */     return this.brandName;
/*     */   }
/*     */   
/*     */   public void setBrandName(String brandName) {
/* 312 */     this.brandName = brandName;
/*     */   }
/*     */   
/*     */   public Integer getSource() {
/* 316 */     return this.source;
/*     */   }
/*     */   
/*     */   public void setSource(Integer source) {
/* 320 */     this.source = source;
/*     */   }
/*     */   
/*     */   public String getSourceCode() {
/* 324 */     return this.sourceCode;
/*     */   }
/*     */   
/*     */   public void setSourceCode(String sourceCode) {
/* 328 */     this.sourceCode = sourceCode;
/*     */   }
/*     */   
/*     */   public String getIdKey() {
/* 332 */     return this.idKey;
/*     */   }
/*     */   
/*     */   public void setIdKey(String idKey) {
/* 336 */     this.idKey = idKey;
/*     */   }
/*     */   
/*     */   public String getStatusName() {
/* 340 */     Map<Integer, String> m = new HashMap<Integer, String>()
/*     */       {
/*     */         private static final long serialVersionUID = 6462988597984217040L;
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 354 */     return m.get(this.status);
/*     */   }
/*     */   
/*     */   public String getBusinessStatusName() {
/* 358 */     if (this.businessStatus == null) {
/* 359 */       return "未知";
/*     */     }
/* 361 */     if (this.businessStatus.intValue() == 0) {
/* 362 */       return "营业中";
/*     */     }
/* 364 */     return "停止";
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getIsSlotcard() {
/* 369 */     return this.isSlotcard;
/*     */   }
/*     */   
/*     */   public void setIsSlotcard(Integer isSlotcard) {
/* 373 */     this.isSlotcard = isSlotcard;
/*     */   }
/*     */   
/*     */   public String getSupportCard() {
/* 377 */     return this.supportCard;
/*     */   }
/*     */   
/*     */   public void setSupportCard(String supportCard) {
/* 381 */     this.supportCard = supportCard;
/*     */   }
/*     */   
/*     */   public String getParkInfo() {
/* 385 */     return this.parkInfo;
/*     */   }
/*     */   
/*     */   public void setParkInfo(String parkInfo) {
/* 389 */     this.parkInfo = parkInfo;
/*     */   }
/*     */   
/*     */   public String getBusinessTime() {
/* 393 */     return this.businessTime;
/*     */   }
/*     */   
/*     */   public void setBusinessTime(String businessTime) {
/* 397 */     this.businessTime = businessTime;
/*     */   }
/*     */   
/*     */   public void setServiceTimeName(String serviceTimeName) {
/* 401 */     this.serviceTimeName = serviceTimeName;
/*     */   }
/*     */   
/*     */   public String getServiceTimeName() {
/* 405 */     if (this.serviceTime == null) {
/* 406 */       this.serviceTimeName = "";
/*     */     } else {
/* 408 */       this.serviceTimeName = DateFormat.dateTimeToDateString(this.serviceTime);
/*     */     } 
/*     */     
/* 411 */     return this.serviceTimeName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getIsVirtual() {
/* 418 */     return this.isVirtual;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIsVirtual(Integer isVirtual) {
/* 425 */     this.isVirtual = isVirtual;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMacAddress() {
/* 432 */     return this.macAddress;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMacAddress(String macAddress) {
/* 439 */     this.macAddress = macAddress;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getPoiId() {
/* 446 */     return this.poiId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPoiId(Long poiId) {
/* 453 */     this.poiId = poiId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getWxAvailableState() {
/* 460 */     return this.wxAvailableState;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWxAvailableState(Integer wxAvailableState) {
/* 467 */     this.wxAvailableState = wxAvailableState;
/*     */   }
/*     */   
/*     */   public String getWxAvailableStateName() {
/* 471 */     if (this.wxAvailableState == null) {
/* 472 */       return "未创建微信门店";
/*     */     }
/*     */     
/* 475 */     String state = "";
/* 476 */     switch (this.wxAvailableState.intValue()) {
/*     */       case 1:
/* 478 */         state = "系统错误";
/*     */         break;
/*     */       
/*     */       case 2:
/* 482 */         state = "审核中";
/*     */         break;
/*     */       
/*     */       case 3:
/* 486 */         state = "审核通过";
/*     */         break;
/*     */       
/*     */       case 4:
/* 490 */         state = "审核驳回";
/*     */         break;
/*     */     } 
/*     */     
/* 494 */     return state;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getWxUpdateStatus() {
/* 501 */     return this.wxUpdateStatus;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWxUpdateStatus(Integer wxUpdateStatus) {
/* 508 */     this.wxUpdateStatus = wxUpdateStatus;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWxMsg() {
/* 515 */     return this.wxMsg;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWxMsg(String wxMsg) {
/* 522 */     this.wxMsg = wxMsg;
/*     */   }
/*     */   
/*     */   public String getTakeOutCode() {
/* 526 */     return this.takeOutCode;
/*     */   }
/*     */   
/*     */   public void setTakeOutCode(String takeOutCode) {
/* 530 */     this.takeOutCode = takeOutCode;
/*     */   }
/*     */   
/*     */   public Integer getPromSubsidy() {
/* 534 */     return this.promSubsidy;
/*     */   }
/*     */   
/*     */   public String getPromSubsidyKey() {
/* 538 */     return this.promSubsidyKey;
/*     */   }
/*     */   
/*     */   public void setPromSubsidy(Integer promSubsidy) {
/* 542 */     this.promSubsidy = promSubsidy;
/*     */   }
/*     */   
/*     */   public void setPromSubsidyKey(String promSubsidyKey) {
/* 546 */     this.promSubsidyKey = promSubsidyKey;
/*     */   }
/*     */   
/*     */   public Long getIidingyunShopId() {
/* 550 */     return this.iidingyunShopId;
/*     */   }
/*     */   
/*     */   public void setIidingyunShopId(Long iidingyunShopId) {
/* 554 */     this.iidingyunShopId = iidingyunShopId;
/*     */   }
/*     */   
/*     */   public String getXpushDid() {
/* 558 */     return this.xpushDid;
/*     */   }
/*     */   
/*     */   public void setXpushDid(String xpushDid) {
/* 562 */     this.xpushDid = xpushDid;
/*     */   }
/*     */   
/*     */   public String getStoreType() {
/* 566 */     return this.storeType;
/*     */   }
/*     */   
/*     */   public void setStoreType(String storeType) {
/* 570 */     this.storeType = storeType;
/*     */   }
/*     */   
/*     */   public String getBusinessTimeWeekend() {
/* 574 */     return this.businessTimeWeekend;
/*     */   }
/*     */   
/*     */   public void setBusinessTimeWeekend(String businessTimeWeekend) {
/* 578 */     this.businessTimeWeekend = businessTimeWeekend;
/*     */   }
/*     */ }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\Store.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */