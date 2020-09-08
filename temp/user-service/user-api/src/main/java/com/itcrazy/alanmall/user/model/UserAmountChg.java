 package com.itcrazy.alanmall.user.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;

 public class UserAmountChg
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -1038400820866130592L;
   private Long id;
   private Long companyId;
   private Long brandId;
   private Long storeId;
   private Long userId;
   private String payUserId;
   private Long changeId;
   private Double amount;
   private Double leftAmount;
   private String mobile;
   private Long createId;
   private Date createTime;
   private Long updateId;
   private Date updateTime;
   private Integer source;
   private String payCode;
   private Integer status;
   private Integer userNum;
   private Double rAmount;

   public Long getId() {
/*  36 */     return this.id;
   }
   public void setId(Long id) {
/*  39 */     this.id = id;
   }
   public Long getCompanyId() {
/*  42 */     return this.companyId;
   }
   public void setCompanyId(Long companyId) {
/*  45 */     this.companyId = companyId;
   }
   public Long getBrandId() {
/*  48 */     return this.brandId;
   }
   public void setBrandId(Long brandId) {
/*  51 */     this.brandId = brandId;
   }
   public Long getStoreId() {
/*  54 */     return this.storeId;
   }
   public void setStoreId(Long storeId) {
/*  57 */     this.storeId = storeId;
   }
   public Long getUserId() {
/*  60 */     return this.userId;
   }
   public String getPayUserId() {
/*  63 */     return this.payUserId;
   }
   public void setPayUserId(String payUserId) {
/*  66 */     this.payUserId = payUserId;
   }
   public void setUserId(Long userId) {
/*  69 */     this.userId = userId;
   }
   public Long getChangeId() {
/*  72 */     return this.changeId;
   }
   public void setChangeId(Long changeId) {
/*  75 */     this.changeId = changeId;
   }
   public Double getAmount() {
/*  78 */     return this.amount;
   }
   public void setAmount(Double amount) {
/*  81 */     this.amount = amount;
   }
   public Double getLeftAmount() {
/*  84 */     return this.leftAmount;
   }
   public void setLeftAmount(Double leftAmount) {
/*  87 */     this.leftAmount = leftAmount;
   }
   public String getMobile() {
/*  90 */     return this.mobile;
   }
   public void setMobile(String mobile) {
/*  93 */     this.mobile = mobile;
   }
   public Long getCreateId() {
/*  96 */     return this.createId;
   }
   public void setCreateId(Long createId) {
/*  99 */     this.createId = createId;
   }
   public Date getCreateTime() {
/* 102 */     return this.createTime;
   }
   public void setCreateTime(Date createTime) {
/* 105 */     this.createTime = createTime;
   }
   public Long getUpdateId() {
/* 108 */     return this.updateId;
   }
   public Date getUpdateTime() {
/* 111 */     return this.updateTime;
   }
   public void setUpdateId(Long updateId) {
/* 114 */     this.updateId = updateId;
   }
   public void setUpdateTime(Date updateTime) {
/* 117 */     this.updateTime = updateTime;
   }
   public Integer getSource() {
/* 120 */     return this.source;
   }
   public void setSource(Integer source) {
/* 123 */     this.source = source;
   }
   public String getPayCode() {
/* 126 */     return this.payCode;
   }
   public void setPayCode(String payCode) {
/* 129 */     this.payCode = payCode;
   }
   public Integer getStatus() {
/* 132 */     return this.status;
   }
   public void setStatus(Integer status) {
/* 135 */     this.status = status;
   }
   public Integer getUserNum() {
/* 138 */     return this.userNum;
   }
   public Double getrAmount() {
/* 141 */     return this.rAmount;
   }
   public void setUserNum(Integer userNum) {
/* 144 */     this.userNum = userNum;
   }
   public void setrAmount(Double rAmount) {
/* 147 */     this.rAmount = rAmount;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\model\UserAmountChg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */