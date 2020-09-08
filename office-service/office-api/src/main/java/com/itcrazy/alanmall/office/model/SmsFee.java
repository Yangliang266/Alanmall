 package com.itcrazy.alanmall.office.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.math.BigDecimal;
 import java.util.Date;







 public class SmsFee
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 4140321878071880650L;
   private Long id;
   private BigDecimal leftAmount;
   private Date createTime;
   private Integer platform;

   public Long getId() {
/* 23 */     return this.id;
   }
   public void setId(Long id) {
/* 26 */     this.id = id;
   }
   public BigDecimal getLeftAmount() {
/* 29 */     return this.leftAmount;
   }
   public void setLeftAmount(BigDecimal leftAmount) {
/* 32 */     this.leftAmount = leftAmount;
   }
   public Date getCreateTime() {
/* 35 */     return this.createTime;
   }
   public void setCreateTime(Date createTime) {
/* 38 */     this.createTime = createTime;
   }
   public Integer getPlatform() {
/* 41 */     return this.platform;
   }
   public void setPlatform(Integer platform) {
/* 44 */     this.platform = platform;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\model\SmsFee.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */