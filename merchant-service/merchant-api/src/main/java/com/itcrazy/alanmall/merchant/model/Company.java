 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.client.util.DateFormat;
 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.Map;













 public class Company
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 8085052201851413335L;
   public static final int STATUS_NEED_CHECK = 1;
   public static final int STATUS_NOT_PASS = 2;
   public static final int STATUS_OVERDUE = 11;
   public static final int STATUS_DISABLE = 21;
   private Long id;
   private String name;
   private Long provinceId;
   private Long cityId;
   private Long countyId;
   private String address;
   private String telephone;
   private String fax;
   private String zip;
   private String linkMan;
   private Integer status;
   private Integer source;
   private String sourceCode;
   private Integer isUsePwd;
   private Date serviceTime;
   private String serviceTimeName;
   private Integer isCloseMessage;
   private Integer isBirthdayQequired;
   private Integer isCredentialsQequired;
   private Long createId;
   private Long updateId;
   private Date createTime;

   public Long getId() {
/*  53 */     return this.id;
   }

   public void setId(Long id) {
/*  57 */     this.id = id;
   }

   public String getName() {
/*  61 */     return this.name;
   }

   public void setName(String name) {
/*  65 */     this.name = name;
   }

   public String getTelephone() {
/*  69 */     return this.telephone;
   }

   public void setTelephone(String telephone) {
/*  73 */     this.telephone = telephone;
   }

   public String getFax() {
/*  77 */     return this.fax;
   }

   public void setFax(String fax) {
/*  81 */     this.fax = fax;
/*     */   }
/*     */   
/*     */   public String getAddress() {
/*  85 */     return this.address;
/*     */   }
/*     */   
/*     */   public void setAddress(String address) {
/*  89 */     this.address = address;
/*     */   }
/*     */   
/*     */   public String getZip() {
/*  93 */     return this.zip;
/*     */   }
/*     */   
/*     */   public void setZip(String zip) {
/*  97 */     this.zip = zip;
/*     */   }
/*     */   
/*     */   public String getLinkMan() {
/* 101 */     return this.linkMan;
/*     */   }
/*     */   
/*     */   public void setLinkMan(String linkMan) {
/* 105 */     this.linkMan = linkMan;
/*     */   }
/*     */   
/*     */   public Integer getStatus() {
/* 109 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 113 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Long getCreateId() {
/* 117 */     return this.createId;
/*     */   }
/*     */   
/*     */   public void setCreateId(Long createId) {
/* 121 */     this.createId = createId;
/*     */   }
/*     */   
/*     */   public Long getUpdateId() {
/* 125 */     return this.updateId;
/*     */   }
/*     */   
/*     */   public void setUpdateId(Long updateId) {
/* 129 */     this.updateId = updateId;
/*     */   }
/*     */   
/*     */   public Long getProvinceId() {
/* 133 */     return this.provinceId;
/*     */   }
/*     */   
/*     */   public void setProvinceId(Long provinceId) {
/* 137 */     this.provinceId = provinceId;
/*     */   }
/*     */   
/*     */   public Long getCityId() {
/* 141 */     return this.cityId;
/*     */   }
/*     */   
/*     */   public void setCityId(Long cityId) {
/* 145 */     this.cityId = cityId;
/*     */   }
/*     */   
/*     */   public Long getCountyId() {
/* 149 */     return this.countyId;
/*     */   }
/*     */   
/*     */   public void setCountyId(Long countyId) {
/* 153 */     this.countyId = countyId;
/*     */   }
/*     */   
/*     */   public Integer getIsUsePwd() {
/* 157 */     return this.isUsePwd;
/*     */   }
/*     */   
/*     */   public void setIsUsePwd(Integer isUsePwd) {
/* 161 */     this.isUsePwd = isUsePwd;
/*     */   }
/*     */   
/*     */   public Integer getSource() {
/* 165 */     return this.source;
/*     */   }
/*     */   
/*     */   public void setSource(Integer source) {
/* 169 */     this.source = source;
/*     */   }
/*     */   
/*     */   public String getSourceCode() {
/* 173 */     return this.sourceCode;
/*     */   }
/*     */   
/*     */   public void setSourceCode(String sourceCode) {
/* 177 */     this.sourceCode = sourceCode;
/*     */   }
/*     */   
/*     */   public Date getCreateTime() {
/* 181 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Date createTime) {
/* 185 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public Date getServiceTime() {
/* 189 */     return this.serviceTime;
/*     */   }
/*     */   
/*     */   public void setServiceTime(Date serviceTime) {
/* 193 */     this.serviceTime = serviceTime;
/*     */   }
/*     */   
/*     */   public Integer getIsCloseMessage() {
/* 197 */     return this.isCloseMessage;
/*     */   }
/*     */   
/*     */   public void setIsCloseMessage(Integer isCloseMessage) {
/* 201 */     this.isCloseMessage = isCloseMessage;
/*     */   }
/*     */   
/*     */   public String getStatusName() {
/* 205 */     Map<Integer, String> m = new HashMap<Integer, String>()
/*     */       {
/*     */         private static final long serialVersionUID = -5891466277294420476L;
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 219 */     return m.get(this.status);
/*     */   }
/*     */   
/*     */   public void setServiceTimeName(String serviceTimeName) {
/* 223 */     this.serviceTimeName = serviceTimeName;
/*     */   }
/*     */   
/*     */   public String getServiceTimeName() {
/* 227 */     if (this.serviceTime == null) {
/* 228 */       this.serviceTimeName = "";
/*     */     } else {
/* 230 */       this.serviceTimeName = DateFormat.dateTimeToDateString(this.serviceTime);
/*     */     } 
/*     */     
/* 233 */     return this.serviceTimeName;
/*     */   }
/*     */   
/*     */   public Integer getIsBirthdayQequired() {
/* 237 */     return this.isBirthdayQequired;
/*     */   }
/*     */   
/*     */   public void setIsBirthdayQequired(Integer isBirthdayQequired) {
/* 241 */     this.isBirthdayQequired = isBirthdayQequired;
/*     */   }
/*     */   
/*     */   public Integer getIsCredentialsQequired() {
/* 245 */     return this.isCredentialsQequired;
/*     */   }
/*     */   
/*     */   public void setIsCredentialsQequired(Integer isCredentialsQequired) {
/* 249 */     this.isCredentialsQequired = isCredentialsQequired;
/*     */   }
/*     */ }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\Company.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */