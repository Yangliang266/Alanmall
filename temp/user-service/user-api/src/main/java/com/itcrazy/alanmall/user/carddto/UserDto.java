 package com.itcrazy.alanmall.user.carddto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;

 public class UserDto
   extends BaseDto
 {
   private static final long serialVersionUID = 1136120053547744583L;
   private String userName;
   private String searchKey;
   private Long companyId;
   private Long brandId;
   private String loginName;
   private String mobile;
   private String email;
   private Integer source;
   private String sourceCode;
   private Long roleId;
   private Long isMemberUnlock;
   private Long storeId;
   private Long wechatUserId;
   private Long rewardWechatUserId;
   private Integer isReceiveBookTableNotice;

   public String getUserName() {
/*  31 */     return this.userName;
   }
   public void setUserName(String userName) {
/*  34 */     this.userName = userName;
   }

   public Long getCompanyId() {
/*  38 */     return this.companyId;
   }
   public void setCompanyId(Long companyId) {
/*  41 */     this.companyId = companyId;
   }

   public Long getBrandId() {
/*  45 */     return this.brandId;
   }
   public void setBrandId(Long brandId) {
/*  48 */     this.brandId = brandId;
   }
   public String getLoginName() {
/*  51 */     return this.loginName;
   }
   public void setLoginName(String loginName) {
/*  54 */     this.loginName = loginName;
   }
   public String getMobile() {
/*  57 */     return this.mobile;
   }
   public void setMobile(String mobile) {
/*  60 */     this.mobile = mobile;
   }
   public String getEmail() {
/*  63 */     return this.email;
   }
   public void setEmail(String email) {
/*  66 */     this.email = email;
   }
   public String getSearchKey() {
/*  69 */     return this.searchKey;
   }
   public void setSearchKey(String searchKey) {
/*  72 */     this.searchKey = searchKey;
   }
   public Integer getSource() {
/*  75 */     return this.source;
   }
   public void setSource(Integer source) {
/*  78 */     this.source = source;
   }
   public String getSourceCode() {
/*  81 */     return this.sourceCode;
   }
   public void setSourceCode(String sourceCode) {
/*  84 */     this.sourceCode = sourceCode;
   }
   public Long getRoleId() {
/*  87 */     return this.roleId;
   }
   public void setRoleId(Long roleId) {
/*  90 */     this.roleId = roleId;
   }
   public Long getIsMemberUnlock() {
/*  93 */     return this.isMemberUnlock;
   }
   public void setIsMemberUnlock(Long isMemberUnlock) {
/*  96 */     this.isMemberUnlock = isMemberUnlock;
   }
   public Long getStoreId() {
/*  99 */     return this.storeId;
   }
   public void setStoreId(Long storeId) {
/* 102 */     this.storeId = storeId;
   }



   public Integer getIsReceiveBookTableNotice() {
/* 108 */     return this.isReceiveBookTableNotice;
   }



   public void setIsReceiveBookTableNotice(Integer isReceiveBookTableNotice) {
/* 114 */     this.isReceiveBookTableNotice = isReceiveBookTableNotice;
   }



   public Long getWechatUserId() {
/* 120 */     return this.wechatUserId;
   }



   public void setWechatUserId(Long wechatUserId) {
/* 126 */     this.wechatUserId = wechatUserId;
   }
   public Long getRewardWechatUserId() {
/* 129 */     return this.rewardWechatUserId;
   }
   public void setRewardWechatUserId(Long rewardWechatUserId) {
/* 132 */     this.rewardWechatUserId = rewardWechatUserId;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\dto\UserDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */