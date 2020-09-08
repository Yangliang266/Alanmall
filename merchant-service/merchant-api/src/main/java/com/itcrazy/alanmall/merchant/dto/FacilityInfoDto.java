 package com.itcrazy.alanmall.merchant.dto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;
 import java.util.Date;

 public class FacilityInfoDto
   extends BaseDto
 {
   private static final long serialVersionUID = -7403537482174789675L;
   private Long id;
   private String deviceNo;
   private String pollCods;
   private Long companyId;
   private Long storeId;
   private Integer status;
   private Date createTime;
   private Date lastAlternately;
   private Integer isDeleted;
   private String storeName;
   private String companyName;

   public Long getId() {
/* 28 */     return this.id;
   }
   public String getDeviceNo() {
/* 31 */     return this.deviceNo;
   }
   public String getPollCods() {
/* 34 */     return this.pollCods;
   }
   public Long getCompanyId() {
/* 37 */     return this.companyId;
   }
   public Long getStoreId() {
/* 40 */     return this.storeId;
   }
   public Integer getStatus() {
/* 43 */     return this.status;
   }
   public Date getCreateTime() {
/* 46 */     return this.createTime;
   }
   public Integer getIsDeleted() {
/* 49 */     return this.isDeleted;
   }
   public void setId(Long id) {
/* 52 */     this.id = id;
   }
   public String getStoreName() {
/* 55 */     return this.storeName;
   }
   public String getCompanyName() {
/* 58 */     return this.companyName;
   }
   public void setStoreName(String storeName) {
/* 61 */     this.storeName = storeName;
   }
   public void setCompanyName(String companyName) {
/* 64 */     this.companyName = companyName;
   }
   public void setDeviceNo(String deviceNo) {
/* 67 */     this.deviceNo = deviceNo;
   }
   public void setPollCods(String pollCods) {
/* 70 */     this.pollCods = pollCods;
   }
   public void setCompanyId(Long companyId) {
/* 73 */     this.companyId = companyId;
   }
   public void setStoreId(Long storeId) {
/* 76 */     this.storeId = storeId;
   }
   public void setStatus(Integer status) {
/* 79 */     this.status = status;
   }
   public void setCreateTime(Date createTime) {
/* 82 */     this.createTime = createTime;
   }
   public void setIsDeleted(Integer isDeleted) {
/* 85 */     this.isDeleted = isDeleted;
   }
   public Date getLastAlternately() {
/* 88 */     return this.lastAlternately;
   }
   public void setLastAlternately(Date lastAlternately) {
/* 91 */     this.lastAlternately = lastAlternately;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\dto\FacilityInfoDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */