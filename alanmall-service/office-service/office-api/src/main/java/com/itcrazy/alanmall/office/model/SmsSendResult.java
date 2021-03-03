 package com.itcrazy.alanmall.office.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;











 public class SmsSendResult
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 3942337170781622575L;
   private Long id;
   private String reportSequence;
   private String mobile;
   private Integer status;
   private String smsContent;

   public Long getId() {
/* 26 */     return this.id;
   }
   public void setId(Long id) {
/* 29 */     this.id = id;
   }

   public String getReportSequence() {
/* 33 */     return this.reportSequence;
   }
   public void setReportSequence(String reportSequence) {
/* 36 */     this.reportSequence = reportSequence;
   }
   public String getMobile() {
/* 39 */     return this.mobile;
   }
   public void setMobile(String mobile) {
/* 42 */     this.mobile = mobile;
   }
   public Integer getStatus() {
/* 45 */     return this.status;
   }
   public void setStatus(Integer status) {
/* 48 */     this.status = status;
   }
   public String getSmsContent() {
/* 51 */     return this.smsContent;
   }
   public void setSmsContent(String smsContent) {
/* 54 */     this.smsContent = smsContent;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\model\SmsSendResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */