 package com.itcrazy.alanmall.office.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;







 public class SmsTypeCompany
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -8587897308016521244L;
   public static final int TYPE_SYSTEM = 1;
   public static final int TYPE_COMPANY = 2;
   private Long id;
   private String name;
   private String content;
   private Long companyId;
   private Long brandId;
   private Long createId;
   private Long updateId;
   private Date createTime;
   private Date updateTime;
   private Integer status;
   private Long smsTypeId;
   private Integer platform;
   private Integer isDeleted;

   public Long getId() {
/*  33 */     return this.id;
   }
   public void setId(Long id) {
/*  36 */     this.id = id;
   }
   public String getName() {
/*  39 */     return this.name;
   }
   public void setName(String name) {
/*  42 */     this.name = name;
   }
   public String getContent() {
/*  45 */     return this.content;
   }
   public void setContent(String content) {
/*  48 */     this.content = content;
   }
   public Long getCompanyId() {
/*  51 */     return this.companyId;
   }
   public void setCompanyId(Long companyId) {
/*  54 */     this.companyId = companyId;
   }
   public Long getBrandId() {
/*  57 */     return this.brandId;
   }
   public void setBrandId(Long brandId) {
/*  60 */     this.brandId = brandId;
   }
   public Long getCreateId() {
/*  63 */     return this.createId;
   }
   public void setCreateId(Long createId) {
/*  66 */     this.createId = createId;
   }
   public Long getUpdateId() {
/*  69 */     return this.updateId;
   }
   public void setUpdateId(Long updateId) {
/*  72 */     this.updateId = updateId;
   }
   public Date getCreateTime() {
/*  75 */     return this.createTime;
   }
   public void setCreateTime(Date createTime) {
/*  78 */     this.createTime = createTime;
   }
   public Date getUpdateTime() {
/*  81 */     return this.updateTime;
   }
   public void setUpdateTime(Date updateTime) {
/*  84 */     this.updateTime = updateTime;
   }
   public Integer getStatus() {
/*  87 */     return this.status;
   }
   public void setStatus(Integer status) {
/*  90 */     this.status = status;
   }
   public Long getSmsTypeId() {
/*  93 */     return this.smsTypeId;
   }
   public void setSmsTypeId(Long smsTypeId) {
/*  96 */     this.smsTypeId = smsTypeId;
   }
   public Integer getIsDeleted() {
/*  99 */     return this.isDeleted;
   }
   public void setIsDeleted(Integer isDeleted) {
/* 102 */     this.isDeleted = isDeleted;
   }
   public Integer getPlatform() {
/* 105 */     return this.platform;
   }
   public void setPlatform(Integer platform) {
/* 108 */     this.platform = platform;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\model\SmsTypeCompany.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */