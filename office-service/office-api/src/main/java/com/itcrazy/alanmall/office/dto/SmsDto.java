 package com.itcrazy.alanmall.office.dto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;
 import java.util.Date;





 public class SmsDto
   extends BaseDto
 {
   private static final long serialVersionUID = 4257617217328652959L;
   private Long id;
   private Long companyId;
   private Long brandId;
   private Long storeId;
   private Long smsTypeId;
   private Integer status;
   private Date sendTimeStart;
   private Date sendTimeEnd;
   private Date planTimeStart;
   private Date planTimeEnd;
   private String mobile;
   private Date createTimeStart;
   private Date createTimeEnd;
   private Long sourceId;

   public Long getId() {
/*  30 */     return this.id;
   }
   public void setId(Long id) {
/*  33 */     this.id = id;
   }
   public Long getCompanyId() {
/*  36 */     return this.companyId;
   }
   public void setCompanyId(Long companyId) {
/*  39 */     this.companyId = companyId;
   }
   public Long getBrandId() {
/*  42 */     return this.brandId;
   }
   public void setBrandId(Long brandId) {
/*  45 */     this.brandId = brandId;
   }
   public Long getStoreId() {
/*  48 */     return this.storeId;
   }
   public void setStoreId(Long storeId) {
/*  51 */     this.storeId = storeId;
   }
   public Long getSmsTypeId() {
/*  54 */     return this.smsTypeId;
   }
   public void setSmsTypeId(Long smsTypeId) {
/*  57 */     this.smsTypeId = smsTypeId;
   }
   public Integer getStatus() {
/*  60 */     return this.status;
   }
   public void setStatus(Integer status) {
/*  63 */     this.status = status;
   }
   public Date getSendTimeStart() {
/*  66 */     return this.sendTimeStart;
   }
   public void setSendTimeStart(Date sendTimeStart) {
/*  69 */     this.sendTimeStart = sendTimeStart;
   }
   public Date getSendTimeEnd() {
/*  72 */     return this.sendTimeEnd;
   }
   public void setSendTimeEnd(Date sendTimeEnd) {
/*  75 */     this.sendTimeEnd = sendTimeEnd;
   }
   public String getMobile() {
/*  78 */     return this.mobile;
   }
   public void setMobile(String mobile) {
/*  81 */     this.mobile = mobile;
   }
   public Date getCreateTimeStart() {
/*  84 */     return this.createTimeStart;
   }
   public void setCreateTimeStart(Date createTimeStart) {
/*  87 */     this.createTimeStart = createTimeStart;
   }
   public Date getCreateTimeEnd() {
/*  90 */     return this.createTimeEnd;
   }
   public void setCreateTimeEnd(Date createTimeEnd) {
/*  93 */     this.createTimeEnd = createTimeEnd;
   }
   public Date getPlanTimeStart() {
/*  96 */     return this.planTimeStart;
   }
   public void setPlanTimeStart(Date planTimeStart) {
/*  99 */     this.planTimeStart = planTimeStart;
   }
   public Date getPlanTimeEnd() {
/* 102 */     return this.planTimeEnd;
   }
   public void setPlanTimeEnd(Date planTimeEnd) {
/* 105 */     this.planTimeEnd = planTimeEnd;
   }



   public Long getSourceId() {
/* 111 */     return this.sourceId;
   }



   public void setSourceId(Long sourceId) {
/* 117 */     this.sourceId = sourceId;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\dto\SmsDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */