 package com.itcrazy.alanmall.office.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;





 public class PlatformAccount
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -347083859000617809L;
   private Long id;
   private String username;
   private String password;
   private String description;
   private Integer code;
   private Date createTime;
   private Date updateTime;
   private Long createId;
   private Long updateId;
   private Integer isDeleted;

   public Long getId() {
/*  26 */     return this.id;
   }

   public void setId(Long id) {
/*  30 */     this.id = id;
   }

   public String getUsername() {
/*  34 */     return this.username;
   }

   public void setUsername(String username) {
/*  38 */     this.username = username;
   }

   public String getPassword() {
/*  42 */     return this.password;
   }

   public void setPassword(String password) {
/*  46 */     this.password = password;
   }

   public String getDescription() {
/*  50 */     return this.description;
   }

   public void setDescription(String description) {
/*  54 */     this.description = description;
   }

   public Integer getCode() {
/*  58 */     return this.code;
   }

   public void setCode(Integer code) {
/*  62 */     this.code = code;
   }

   public Date getCreateTime() {
/*  66 */     return this.createTime;
   }

   public Date getUpdateTime() {
/*  70 */     return this.updateTime;
   }

   public Long getCreateId() {
/*  74 */     return this.createId;
   }

   public Long getUpdateId() {
/*  78 */     return this.updateId;
   }

   public Integer getIsDeleted() {
/*  82 */     return this.isDeleted;
   }

   public void setCreateTime(Date createTime) {
/*  86 */     this.createTime = createTime;
   }

   public void setUpdateTime(Date updateTime) {
/*  90 */     this.updateTime = updateTime;
   }

   public void setCreateId(Long createId) {
/*  94 */     this.createId = createId;
   }

   public void setUpdateId(Long updateId) {
/*  98 */     this.updateId = updateId;
   }

   public void setIsDeleted(Integer isDeleted) {
/* 102 */     this.isDeleted = isDeleted;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\model\PlatformAccount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */