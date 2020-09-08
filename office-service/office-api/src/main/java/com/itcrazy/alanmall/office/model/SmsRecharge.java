 package com.itcrazy.alanmall.office.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;




 public class SmsRecharge
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 1972247508080193373L;
   private Long id;
   private Long companyId;
   private Long brandId;
   private Integer amount;
   private Date rechargeTime;
   private Date createTime;
   private Long createId;

   public Long getId() {
/* 22 */     return this.id;
   }
   public void setId(Long id) {
/* 25 */     this.id = id;
   }
   public Long getCompanyId() {
/* 28 */     return this.companyId;
   }
   public void setCompanyId(Long companyId) {
/* 31 */     this.companyId = companyId;
   }
   public Long getBrandId() {
/* 34 */     return this.brandId;
   }
   public void setBrandId(Long brandId) {
/* 37 */     this.brandId = brandId;
   }
   public Integer getAmount() {
/* 40 */     return this.amount;
   }
   public void setAmount(Integer amount) {
/* 43 */     this.amount = amount;
   }
   public Date getCreateTime() {
/* 46 */     return this.createTime;
   }
   public void setCreateTime(Date createTime) {
/* 49 */     this.createTime = createTime;
   }
   public Date getRechargeTime() {
/* 52 */     return this.rechargeTime;
   }
   public void setRechargeTime(Date rechargeTime) {
/* 55 */     this.rechargeTime = rechargeTime;
   }
   public Long getCreateId() {
/* 58 */     return this.createId;
   }
   public void setCreateId(Long createId) {
/* 61 */     this.createId = createId;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\model\SmsRecharge.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */