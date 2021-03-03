 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.client.util.DateFormat;
 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;

































 public class Brand
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 8194225701335009053L;
   public static final int STATUS_NEED_CHECK = 1;
   public static final int STATUS_NOT_PASS = 2;
   public static final int STATUS_OVERDUE = 11;
   public static final int STATUS_DISABLE = 21;
   public static final int BUSINESS_TYPE_EAT = 1;
   public static final int BUSINESS_TYPE_DRESS = 2;
   public static final int BUSINESS_TYPE_HOTEL = 3;
   public static final int BUSINESS_TYPE_TRAVEL = 4;
   public static final int BUSINESS_TYPE_ENTERTAINMENT = 5;
   public static final int PAY_CHANNEL_5I = 1;
   public static final int PAY_CHANNEL_SAND = 2;
   public static final int PAY_CHANNEL_FUBA = 3;
   public static final int PAY_CHANNEL_ZNYOO = 4;
   public static final int PAY_CHANNEL_SEMOOR = 5;
   public static final int IS_SEND_IIDINGYUN_TRUE = 1;
   public static final int IS_SEND_IIDINGYUN_FALSE = 0;
   private Long id;
   private Long companyId;
   private String name;
   private Integer status;
   private Long createId;
   private Long updateId;
   private String companyName;
   private String receiveMsgMobile;
   private String brandCuisine;
/*     */   private Integer isDeleted;
/*     */   private Integer source;
/*     */   private String sourceCode;
/*     */   private Date createTime;
/*     */   private String linkMan;
/*     */   private String telephone;
/*     */   private Date serviceTime;
/*     */   private String serviceTimeName;
/*     */   private String address;
/*     */   private Integer businessType;
/*     */   private Integer applyGender;
/*     */   private Integer avgConsumption;
/*     */   private Integer subAccount;
/*     */   private Integer payChannelType;
/*     */   private String channelMchNo;
/*     */   private String privateKey;
/*     */   private String subMerchantId;
/*     */   private String liquidatorName;
/*     */   private String encryptId;
/*     */   private Integer isSendiidingyun;
/*     */   private Integer isSendDFire;
/*     */   private Integer isExtractTypeSend;
/*     */   private Integer isExtractTypeZiti;
/*     */   
/*     */   public Integer getIsSendiidingyun() {
/*  93 */     return this.isSendiidingyun;
/*     */   }
/*     */   
/*     */   public void setIsSendiidingyun(Integer isSendiidingyun) {
/*  97 */     this.isSendiidingyun = isSendiidingyun;
/*     */   }
/*     */   
/*     */   public Long getId() {
/* 101 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/* 105 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Long getCompanyId() {
/* 109 */     return this.companyId;
/*     */   }
/*     */   
/*     */   public void setCompanyId(Long companyId) {
/* 113 */     this.companyId = companyId;
/*     */   }
/*     */   
/*     */   public Integer getStatus() {
/* 117 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 121 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Long getCreateId() {
/* 125 */     return this.createId;
/*     */   }
/*     */   
/*     */   public void setCreateId(Long createId) {
/* 129 */     this.createId = createId;
/*     */   }
/*     */   
/*     */   public Long getUpdateId() {
/* 133 */     return this.updateId;
/*     */   }
/*     */   
/*     */   public void setUpdateId(Long updateId) {
/* 137 */     this.updateId = updateId;
/*     */   }
/*     */   
/*     */   public String getCompanyName() {
/* 141 */     return this.companyName;
/*     */   }
/*     */   
/*     */   public void setCompanyName(String companyName) {
/* 145 */     this.companyName = companyName;
/*     */   }
/*     */   
/*     */   public String getBrandCuisine() {
/* 149 */     return this.brandCuisine;
/*     */   }
/*     */   
/*     */   public void setBrandCuisine(String brandCuisine) {
/* 153 */     this.brandCuisine = brandCuisine;
/*     */   }
/*     */   
/*     */   public Integer getIsDeleted() {
/* 157 */     return this.isDeleted;
/*     */   }
/*     */   
/*     */   public void setIsDeleted(Integer isDeleted) {
/* 161 */     this.isDeleted = isDeleted;
/*     */   }
/*     */   
/*     */   public String getReceiveMsgMobile() {
/* 165 */     return this.receiveMsgMobile;
/*     */   }
/*     */   
/*     */   public void setReceiveMsgMobile(String receiveMsgMobile) {
/* 169 */     this.receiveMsgMobile = receiveMsgMobile;
/*     */   }
/*     */   
/*     */   public Integer getSource() {
/* 173 */     return this.source;
/*     */   }
/*     */   
/*     */   public void setSource(Integer source) {
/* 177 */     this.source = source;
/*     */   }
/*     */   
/*     */   public String getSourceCode() {
/* 181 */     return this.sourceCode;
/*     */   }
/*     */   
/*     */   public void setSourceCode(String sourceCode) {
/* 185 */     this.sourceCode = sourceCode;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 189 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 193 */     this.name = name;
/*     */   }
/*     */   
/*     */   public Date getCreateTime() {
/* 197 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Date createTime) {
/* 201 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public String getLinkMan() {
/* 205 */     return this.linkMan;
/*     */   }
/*     */   
/*     */   public void setLinkMan(String linkMan) {
/* 209 */     this.linkMan = linkMan;
/*     */   }
/*     */   
/*     */   public String getTelephone() {
/* 213 */     return this.telephone;
/*     */   }
/*     */   
/*     */   public void setTelephone(String telephone) {
/* 217 */     this.telephone = telephone;
/*     */   }
/*     */   
/*     */   public Date getServiceTime() {
/* 221 */     return this.serviceTime;
/*     */   }
/*     */   
/*     */   public void setServiceTime(Date serviceTime) {
/* 225 */     this.serviceTime = serviceTime;
/*     */   }
/*     */   
/*     */   public String getAddress() {
/* 229 */     return this.address;
/*     */   }
/*     */   
/*     */   public void setAddress(String address) {
/* 233 */     this.address = address;
/*     */   }
/*     */   
/*     */   public String getStatusName() {
/* 237 */     if (this.status == null)
/* 238 */       return "未知"; 
/* 239 */     if (this.status.intValue() == 0)
/* 240 */       return "已开通"; 
/* 241 */     if (this.status.intValue() == 1)
/* 242 */       return "待审核"; 
/* 243 */     if (this.status.intValue() == 2)
/* 244 */       return "未通过"; 
/* 245 */     if (this.status.intValue() == 11) {
/* 246 */       return "过期";
/*     */     }
/* 248 */     return "未通过";
/*     */   }
/*     */ 
/*     */   
/*     */   public void setServiceTimeName(String serviceTimeName) {
/* 253 */     this.serviceTimeName = serviceTimeName;
/*     */   }
/*     */   
/*     */   public String getServiceTimeName() {
/* 257 */     if (this.serviceTime == null) {
/* 258 */       this.serviceTimeName = "";
/*     */     } else {
/* 260 */       this.serviceTimeName = DateFormat.dateTimeToDateString(this.serviceTime);
/*     */     } 
/*     */     
/* 263 */     return this.serviceTimeName;
/*     */   }
/*     */   
/*     */   public Integer getBusinessType() {
/* 267 */     return this.businessType;
/*     */   }
/*     */   
/*     */   public void setBusinessType(Integer businessType) {
/* 271 */     this.businessType = businessType;
/*     */   }
/*     */   
/*     */   public Integer getApplyGender() {
/* 275 */     return this.applyGender;
/*     */   }
/*     */   
/*     */   public void setApplyGender(Integer applyGender) {
/* 279 */     this.applyGender = applyGender;
/*     */   }
/*     */   
/*     */   public Integer getAvgConsumption() {
/* 283 */     return this.avgConsumption;
/*     */   }
/*     */   
/*     */   public void setAvgConsumption(Integer avgConsumption) {
/* 287 */     this.avgConsumption = avgConsumption;
/*     */   }
/*     */   
/*     */   public Integer getSubAccount() {
/* 291 */     return this.subAccount;
/*     */   }
/*     */   
/*     */   public void setSubAccount(Integer subAccount) {
/* 295 */     this.subAccount = subAccount;
/*     */   }
/*     */   
/*     */   public Integer getPayChannelType() {
/* 299 */     return this.payChannelType;
/*     */   }
/*     */   
/*     */   public void setPayChannelType(Integer payChannelType) {
/* 303 */     this.payChannelType = payChannelType;
/*     */   }
/*     */   
/*     */   public String getPrivateKey() {
/* 307 */     return this.privateKey;
/*     */   }
/*     */   
/*     */   public void setPrivateKey(String privateKey) {
/* 311 */     this.privateKey = privateKey;
/*     */   }
/*     */   
/*     */   public String getSubMerchantId() {
/* 315 */     return this.subMerchantId;
/*     */   }
/*     */   
/*     */   public String getLiquidatorName() {
/* 319 */     return this.liquidatorName;
/*     */   }
/*     */   
/*     */   public void setSubMerchantId(String subMerchantId) {
/* 323 */     this.subMerchantId = subMerchantId;
/*     */   }
/*     */   
/*     */   public void setLiquidatorName(String liquidatorName) {
/* 327 */     this.liquidatorName = liquidatorName;
/*     */   }
/*     */   
/*     */   public String getChannelMchNo() {
/* 331 */     return this.channelMchNo;
/*     */   }
/*     */   
/*     */   public void setChannelMchNo(String channelMchNo) {
/* 335 */     this.channelMchNo = channelMchNo;
/*     */   }
/*     */   
/*     */   public String getEncryptId() {
/* 339 */     return this.encryptId;
/*     */   }
/*     */   
/*     */   public void setEncryptId(String encryptId) {
/* 343 */     this.encryptId = encryptId;
/*     */   }
/*     */   
/*     */   public Integer getIsSendDFire() {
/* 347 */     return this.isSendDFire;
/*     */   }
/*     */   
/*     */   public void setIsSendDFire(Integer isSendDFire) {
/* 351 */     this.isSendDFire = isSendDFire;
/*     */   }
/*     */   
/*     */   public Integer getIsExtractTypeSend() {
/* 355 */     return this.isExtractTypeSend;
/*     */   }
/*     */   
/*     */   public Integer getIsExtractTypeZiti() {
/* 359 */     return this.isExtractTypeZiti;
/*     */   }
/*     */   
/*     */   public void setIsExtractTypeSend(Integer isExtractTypeSend) {
/* 363 */     this.isExtractTypeSend = isExtractTypeSend;
/*     */   }
/*     */   
/*     */   public void setIsExtractTypeZiti(Integer isExtractTypeZiti) {
/* 367 */     this.isExtractTypeZiti = isExtractTypeZiti;
/*     */   }
/*     */ }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\Brand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */