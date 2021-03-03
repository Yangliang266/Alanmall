 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;



 public class FacilityInfo
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -4661195638817752764L;
   private Long id;
   private String deviceNo;
   private String pollCods;
   private Long companyId;
   private Long storeId;
   private Integer status;
   private Date createTime;
   private Date lastAlternately;
   private Integer isDeleted;

   public Long getId() {
/* 23 */     return this.id;
   }
   public String getDeviceNo() {
/* 26 */     return this.deviceNo;
   }
   public String getPollCods() {
/* 29 */     return this.pollCods;
   }
   public Long getCompanyId() {
/* 32 */     return this.companyId;
   }
   public Long getStoreId() {
/* 35 */     return this.storeId;
   }
   public Integer getStatus() {
/* 38 */     return this.status;
   }
   public Date getCreateTime() {
/* 41 */     return this.createTime;
   }
   public Integer getIsDeleted() {
/* 44 */     return this.isDeleted;
   }
   public void setId(Long id) {
/* 47 */     this.id = id;
   }
   public void setDeviceNo(String deviceNo) {
/* 50 */     this.deviceNo = deviceNo;
   }
   public void setPollCods(String pollCods) {
/* 53 */     this.pollCods = pollCods;
   }
   public void setCompanyId(Long companyId) {
/* 56 */     this.companyId = companyId;
   }
   public void setStoreId(Long storeId) {
/* 59 */     this.storeId = storeId;
   }
   public void setStatus(Integer status) {
/* 62 */     this.status = status;
   }
   public void setCreateTime(Date createTime) {
/* 65 */     this.createTime = createTime;
   }
   public void setIsDeleted(Integer isDeleted) {
/* 68 */     this.isDeleted = isDeleted;
   }
   public Date getLastAlternately() {
/* 71 */     return this.lastAlternately;
   }
   public void setLastAlternately(Date lastAlternately) {
/* 74 */     this.lastAlternately = lastAlternately;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\FacilityInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */