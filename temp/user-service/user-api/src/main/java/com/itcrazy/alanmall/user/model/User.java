 package com.itcrazy.alanmall.user.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;

 public class User
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -4661427851812251316L;
   public static final long UNLOCK_YES = 1L;
   public static final long UNLOCK_NO = 0L;
   public static final int SEX_UNKNOWN = 0;
   public static final int SEX_MAN = 1;
   public static final int SEX_WOMEN = 2;
   private Long id;
   private String userName;
   private String realName;
   private String password;
   private String mobile;
   private Integer status;
   private String email;
   private Long roleId;
   private Long roleLevelId;
   private Long createId;
   private Long updateId;
   private Integer isAllScope;
   private Long wechatUserId;
   private Long rewardWechatUserId;
   private Integer isMemberUnlock;
   private Integer isReceiveBookTableNotice;
   private String openId;
   private Long companyId;
   private String companyIds;
   private String companyName;
   private Long brandId;
   private String brandIds;
   private Long storeId;
   private String storeIds;
   private String storeIdsWithoutHQ;
   private Integer isTakeOutRemind;
   private String seatCode;
   private Integer source;
   private String sourceCode;
   private Double amount;
   private Integer gender;
   private Date birthday;
   private String storeName;
   private boolean includeHQ;

   public Long getId() {
/*  56 */     return this.id;
   }

   public void setId(Long id) {
/*  60 */     this.id = id;
   }

   public Long getCompanyId() {
/*  64 */     return this.companyId;
   }

   public void setCompanyId(Long companyId) {
/*  68 */     this.companyId = companyId;
   }

   public String getCompanyIds() {
/*  72 */     return this.companyIds;
   }

   public void setCompanyIds(String companyIds) {
/*  76 */     this.companyIds = companyIds;
   }

   public String getUserName() {
/*  80 */     return this.userName;
   }

   public void setUserName(String userName) {
/*  84 */     this.userName = userName;
   }

   public String getRealName() {
/*  88 */     return this.realName;
   }

   public void setRealName(String realName) {
/*  92 */     this.realName = realName;
   }

   public String getPassword() {
/*  96 */     return this.password;
   }

   public void setPassword(String password) {
/* 100 */     this.password = password;
   }

   public String getMobile() {
/* 104 */     return this.mobile;
   }

   public void setMobile(String mobile) {
/* 108 */     this.mobile = mobile;
   }

   public Integer getStatus() {
/* 112 */     return this.status;
   }

   public void setStatus(Integer status) {
/* 116 */     this.status = status;
   }

   public String getEmail() {
/* 120 */     return this.email;
   }

   public void setEmail(String email) {
/* 124 */     this.email = email;
   }

   public Long getRoleId() {
/* 128 */     return this.roleId;
   }

   public void setRoleId(Long roleId) {
/* 132 */     this.roleId = roleId;
   }

   public Long getCreateId() {
/* 136 */     return this.createId;
   }

   public void setCreateId(Long createId) {
/* 140 */     this.createId = createId;
   }

   public Long getUpdateId() {
/* 144 */     return this.updateId;
   }

   public void setUpdateId(Long updateId) {
/* 148 */     this.updateId = updateId;
   }

   public Integer getIsTakeOutRemind() {
/* 152 */     return this.isTakeOutRemind;
   }

   public void setIsTakeOutRemind(Integer isTakeOutRemind) {
/* 156 */     this.isTakeOutRemind = isTakeOutRemind;
   }



   public String getStoreIds() {
/* 162 */     return this.storeIds;
   }

   public void setStoreIds(String storeIds) {
/* 166 */     this.storeIds = storeIds;
   }

   public Long getStoreId() {
/* 170 */     return this.storeId;
   }

   public void setStoreId(Long storeId) {
/* 174 */     this.storeId = storeId;
   }

   public Long getBrandId() {
/* 178 */     return this.brandId;
   }

   public void setBrandId(Long brandId) {
/* 182 */     this.brandId = brandId;
   }

   public String getStatusName() {
/* 186 */     if (this.status.intValue() == 0) {
/* 187 */       return "启用";
     }
/* 189 */     return "停用";
   }


   public String getBrandIds() {
/* 194 */     return this.brandIds;
   }

   public void setBrandIds(String brandIds) {
/* 198 */     this.brandIds = brandIds;
   }

   public Long getRoleLevelId() {
/* 202 */     return this.roleLevelId;
   }

   public void setRoleLevelId(Long roleLevelId) {
/* 206 */     this.roleLevelId = roleLevelId;
   }

   public Integer getSource() {
/* 210 */     return this.source;
   }

   public void setSource(Integer source) {
/* 214 */     this.source = source;
   }

   public String getSourceCode() {
/* 218 */     return this.sourceCode;
   }

   public void setSourceCode(String sourceCode) {
/* 222 */     this.sourceCode = sourceCode;
   }

   public String getSeatCode() {
/* 226 */     return this.seatCode;
   }

   public void setSeatCode(String seatCode) {
/* 230 */     this.seatCode = seatCode;
   }

   public Integer getIsAllScope() {
/* 234 */     return this.isAllScope;
   }

   public void setIsAllScope(Integer isAllScope) {
/* 238 */     this.isAllScope = isAllScope;
   }
   public String getIsAllScopeName() {
/* 241 */     if (this.isAllScope == null) {
/* 242 */       return "未知";
     }
/* 244 */     if (this.isAllScope.intValue() == 0) {
/* 245 */       return "部分";
     }
/* 247 */     return "全部";
   }



   public Long getWechatUserId() {
/* 253 */     return this.wechatUserId;
   }

   public void setWechatUserId(Long wechatUserId) {
/* 257 */     this.wechatUserId = wechatUserId;
   }

   public Long getRewardWechatUserId() {
/* 261 */     return this.rewardWechatUserId;
   }

   public void setRewardWechatUserId(Long rewardWechatUserId) {
/* 265 */     this.rewardWechatUserId = rewardWechatUserId;
   }

   public Integer getIsMemberUnlock() {
/* 269 */     return this.isMemberUnlock;
   }

   public void setIsMemberUnlock(Integer isMemberUnlock) {
/* 273 */     this.isMemberUnlock = isMemberUnlock;
   }




   public Integer getIsReceiveBookTableNotice() {
/* 280 */     return this.isReceiveBookTableNotice;
   }




   public void setIsReceiveBookTableNotice(Integer isReceiveBookTableNotice) {
/* 287 */     this.isReceiveBookTableNotice = isReceiveBookTableNotice;
   }




   public String getOpenId() {
/* 294 */     return this.openId;
   }




   public void setOpenId(String openId) {
/* 301 */     this.openId = openId;
   }

   public Double getAmount() {
/* 305 */     return this.amount;
   }

   public void setAmount(Double amount) {
/* 309 */     this.amount = amount;
   }

   public Integer getGender() {
/* 313 */     return this.gender;
   }

   public void setGender(Integer gender) {
/* 317 */     this.gender = gender;
   }

   public Date getBirthday() {
/* 321 */     return this.birthday;
   }

   public void setBirthday(Date birthday) {
/* 325 */     this.birthday = birthday;
   }

   public String getCompanyName() {
/* 329 */     return this.companyName;
   }

   public void setCompanyName(String companyName) {
/* 333 */     this.companyName = companyName;
   }

   public String getGenderName() {
/* 337 */     if (this.gender == null) {
/* 338 */       return "未知";
     }
/* 340 */     if (this.gender.intValue() == 1)
/* 341 */       return "男"; 
/* 342 */     if (this.gender.intValue() == 2) {
/* 343 */       return "女";
     }
/* 345 */     return "未知";
   }


   public String getStoreName() {
/* 350 */     return this.storeName;
   }

   public void setStoreName(String storeName) {
/* 354 */     this.storeName = storeName;
   }

   public String getStoreIdsWithoutHQ() {
/* 358 */     return this.storeIdsWithoutHQ;
   }

   public void setStoreIdsWithoutHQ(String storeIdsWithoutHQ) {
/* 362 */     this.storeIdsWithoutHQ = storeIdsWithoutHQ;
   }

   public boolean isIncludeHQ() {
/* 366 */     return this.includeHQ;
   }

   public void setIncludeHQ(boolean includeHQ) {
/* 370 */     this.includeHQ = includeHQ;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\model\User.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */