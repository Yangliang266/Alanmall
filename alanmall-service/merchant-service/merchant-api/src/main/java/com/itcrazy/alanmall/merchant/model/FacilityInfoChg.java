 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;





 public class FacilityInfoChg
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -5389315438692705490L;
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
/* 28 */     return this.id;
   }
   public Integer getFacilityInfoId() {
/* 31 */     return this.facilityInfoId;
   }
   public String getNewDeviceNo() {
/* 34 */     return this.newDeviceNo;
   }
   public String getOldPollCods() {
/* 37 */     return this.oldPollCods;
   }
   public String getNewPollCods() {
/* 40 */     return this.newPollCods;
   }
   public Integer getCompanyId() {
/* 43 */     return this.companyId;
   }
   public Integer getStoreId() {
/* 46 */     return this.storeId;
   }
   public Integer getSource() {
/* 49 */     return this.source;
   }
   public Integer getCreateId() {
/* 52 */     return this.createId;
   }
   public Date getCreateTime() {
/* 55 */     return this.createTime;
   }
   public Integer getIsDelete() {
/* 58 */     return this.isDelete;
   }
   public void setId(Long id) {
/* 61 */     this.id = id;
   }
   public String getOldDeviceNo() {
/* 64 */     return this.oldDeviceNo;
   }
   public void setOldDeviceNo(String oldDeviceNo) {
/* 67 */     this.oldDeviceNo = oldDeviceNo;
   }
   public void setFacilityInfoId(Integer facilityInfoId) {
/* 70 */     this.facilityInfoId = facilityInfoId;
   }
   public void setNewDeviceNo(String newDeviceNo) {
/* 73 */     this.newDeviceNo = newDeviceNo;
   }
   public void setOldPollCods(String oldPollCods) {
/* 76 */     this.oldPollCods = oldPollCods;
   }
   public void setNewPollCods(String newPollCods) {
/* 79 */     this.newPollCods = newPollCods;
   }
   public void setCompanyId(Integer companyId) {
/* 82 */     this.companyId = companyId;
   }
   public void setStoreId(Integer storeId) {
/* 85 */     this.storeId = storeId;
   }
   public void setSource(Integer source) {
/* 88 */     this.source = source;
   }
   public void setCreateId(Integer createId) {
/* 91 */     this.createId = createId;
   }
   public void setCreateTime(Date createTime) {
/* 94 */     this.createTime = createTime;
   }
   public void setIsDelete(Integer isDelete) {
/* 97 */     this.isDelete = isDelete;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\FacilityInfoChg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */