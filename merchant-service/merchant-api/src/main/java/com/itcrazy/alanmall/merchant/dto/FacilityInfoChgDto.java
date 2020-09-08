 package com.itcrazy.alanmall.merchant.dto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;
 import java.util.Date;

 public class FacilityInfoChgDto
   extends BaseDto
 {
   private static final long serialVersionUID = 2849917831198252404L;
   private Long id;
   private Integer facilityInfoId;
   private String oldDeviceNo;
   private String newDeviceNo;
   private String oldPollCods;
   private String newPollCods;
   private Integer companyId;
   private Integer storeId;
   private Integer source;
   private Integer createId;
   private Date createTime;
   private Integer isDelete;

   public Long getId() {
/* 26 */     return this.id;
   }
   public Integer getFacilityInfoId() {
/* 29 */     return this.facilityInfoId;
   }
   public String getNewDeviceNo() {
/* 32 */     return this.newDeviceNo;
   }
   public String getOldPollCods() {
/* 35 */     return this.oldPollCods;
   }
   public String getNewPollCods() {
/* 38 */     return this.newPollCods;
   }
   public Integer getCompanyId() {
/* 41 */     return this.companyId;
   }
   public Integer getStoreId() {
/* 44 */     return this.storeId;
   }
   public Integer getSource() {
/* 47 */     return this.source;
   }
   public Integer getCreateId() {
/* 50 */     return this.createId;
   }
   public Date getCreateTime() {
/* 53 */     return this.createTime;
   }
   public Integer getIsDelete() {
/* 56 */     return this.isDelete;
   }
   public void setId(Long id) {
/* 59 */     this.id = id;
   }
   public String getOldDeviceNo() {
/* 62 */     return this.oldDeviceNo;
   }
   public void setOldDeviceNo(String oldDeviceNo) {
/* 65 */     this.oldDeviceNo = oldDeviceNo;
   }
   public void setFacilityInfoId(Integer facilityInfoId) {
/* 68 */     this.facilityInfoId = facilityInfoId;
   }
   public void setNewDeviceNo(String newDeviceNo) {
/* 71 */     this.newDeviceNo = newDeviceNo;
   }
   public void setOldPollCods(String oldPollCods) {
/* 74 */     this.oldPollCods = oldPollCods;
   }
   public void setNewPollCods(String newPollCods) {
/* 77 */     this.newPollCods = newPollCods;
   }
   public void setCompanyId(Integer companyId) {
/* 80 */     this.companyId = companyId;
   }
   public void setStoreId(Integer storeId) {
/* 83 */     this.storeId = storeId;
   }
   public void setSource(Integer source) {
/* 86 */     this.source = source;
   }
   public void setCreateId(Integer createId) {
/* 89 */     this.createId = createId;
   }
   public void setCreateTime(Date createTime) {
/* 92 */     this.createTime = createTime;
   }
   public void setIsDelete(Integer isDelete) {
/* 95 */     this.isDelete = isDelete;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\dto\FacilityInfoChgDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */