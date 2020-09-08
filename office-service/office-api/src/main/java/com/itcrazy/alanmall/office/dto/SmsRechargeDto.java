 package com.itcrazy.alanmall.office.dto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;
 import java.util.Date;




 public class SmsRechargeDto
   extends BaseDto
 {
   private static final long serialVersionUID = 4257617217328652959L;
   private Long id;
   private Long companyId;
   private Long brandId;
   private Integer amount;
   private String RechargeTimeStart;
   private String RechargeTimeEnd;
   private Date createTimeStart;
   private Date createTimeEnd;
   private String companyIds;

   public Long getId() {
/* 24 */     return this.id;
   }
   public void setId(Long id) {
/* 27 */     this.id = id;
   }
   public Long getCompanyId() {
/* 30 */     return this.companyId;
   }
   public void setCompanyId(Long companyId) {
/* 33 */     this.companyId = companyId;
   }
   public Long getBrandId() {
/* 36 */     return this.brandId;
   }
   public void setBrandId(Long brandId) {
/* 39 */     this.brandId = brandId;
   }
   public Integer getAmount() {
/* 42 */     return this.amount;
   }
   public void setAmount(Integer amount) {
/* 45 */     this.amount = amount;
   }
   public String getRechargeTimeStart() {
/* 48 */     return this.RechargeTimeStart;
   }
   public void setRechargeTimeStart(String rechargeTimeStart) {
/* 51 */     this.RechargeTimeStart = rechargeTimeStart;
   }
   public String getRechargeTimeEnd() {
/* 54 */     return this.RechargeTimeEnd;
   }
   public void setRechargeTimeEnd(String rechargeTimeEnd) {
/* 57 */     this.RechargeTimeEnd = rechargeTimeEnd;
   }
   public Date getCreateTimeStart() {
/* 60 */     return this.createTimeStart;
   }
   public void setCreateTimeStart(Date createTimeStart) {
/* 63 */     this.createTimeStart = createTimeStart;
   }
   public Date getCreateTimeEnd() {
/* 66 */     return this.createTimeEnd;
   }
   public void setCreateTimeEnd(Date createTimeEnd) {
/* 69 */     this.createTimeEnd = createTimeEnd;
   }
   public String getCompanyIds() {
/* 72 */     return this.companyIds;
   }
   public void setCompanyIds(String companyIds) {
/* 75 */     this.companyIds = companyIds;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\dto\SmsRechargeDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */