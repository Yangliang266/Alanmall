 package com.itcrazy.alanmall.user.carddto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;

 public class UserAmountChgDto
   extends BaseDto
 {
   private static final long serialVersionUID = 1136120053547744583L;
   public static final int TIME_TYPE_DAY = 1;
   public static final int TIME_TYPE_MONTH = 2;
   private Long companyId;
   private Long brandId;
   private Long storeId;
   private Long userId;
   private String createTimeStart;
   private String createTimeEnd;
   private String month;
   private Integer timeType;

   public Long getCompanyId() {
/* 26 */     return this.companyId;
   }
   public void setCompanyId(Long companyId) {
/* 29 */     this.companyId = companyId;
   }
   public Long getBrandId() {
/* 32 */     return this.brandId;
   }
   public void setBrandId(Long brandId) {
/* 35 */     this.brandId = brandId;
   }
   public Long getStoreId() {
/* 38 */     return this.storeId;
   }
   public void setStoreId(Long storeId) {
/* 41 */     this.storeId = storeId;
   }
   public Long getUserId() {
/* 44 */     return this.userId;
   }
   public void setUserId(Long userId) {
/* 47 */     this.userId = userId;
   }
   public String getCreateTimeStart() {
/* 50 */     return this.createTimeStart;
   }
   public void setCreateTimeStart(String createTimeStart) {
/* 53 */     this.createTimeStart = createTimeStart;
   }
   public String getCreateTimeEnd() {
/* 56 */     return this.createTimeEnd;
   }
   public void setCreateTimeEnd(String createTimeEnd) {
/* 59 */     this.createTimeEnd = createTimeEnd;
   }
   public String getMonth() {
/* 62 */     return this.month;
   }
   public void setMonth(String month) {
/* 65 */     this.month = month;
   }
   public Integer getTimeType() {
/* 68 */     return this.timeType;
   }
   public void setTimeType(Integer timeType) {
/* 71 */     this.timeType = timeType;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\dto\UserAmountChgDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */