 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;





 public class AppPosConfig
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 7395523920415959969L;
   public static final int CONSU_WAY_AUTO = 1;
   public static final int CONSU_WAY_MANUAL = 2;
   public static final int CONSU_WAY_SWITCH_MANUAL = 3;
   public static final int CONSU_WAY_SWITCH_AUTO = 4;
   public static final int WECHAT_PAY_WAY_NOT_5I = 0;
   public static final int WECHAT_PAY_WAY_5I = 1;
   public static final int ALI_PAY_WAY_NOT_5I = 0;
   public static final int ALI_PAY_WAY_5I = 1;
   private Long id;
   private Long companyId;
   private Long brandId;
   private Long storeId;
   private Integer consuWay;
   private Integer wechatPayWay;
   private Integer aliPayWay;
   private Date createTime;
   private Long createId;
   private Date updateTime;
   private Long updateId;
   private Integer isDeleted;

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
   public Integer getConsuWay() {
/*  60 */     return this.consuWay;
   }
   public void setConsuWay(Integer consuWay) {
/*  63 */     this.consuWay = consuWay;
   }
   public Integer getWechatPayWay() {
/*  66 */     return this.wechatPayWay;
   }
   public void setWechatPayWay(Integer wechatPayWay) {
/*  69 */     this.wechatPayWay = wechatPayWay;
   }
   public Integer getAliPayWay() {
/*  72 */     return this.aliPayWay;
   }
   public void setAliPayWay(Integer aliPayWay) {
/*  75 */     this.aliPayWay = aliPayWay;
   }
   public Date getCreateTime() {
/*  78 */     return this.createTime;
   }
   public void setCreateTime(Date createTime) {
/*  81 */     this.createTime = createTime;
   }
   public Long getCreateId() {
/*  84 */     return this.createId;
   }
   public void setCreateId(Long createId) {
/*  87 */     this.createId = createId;
   }
   public Date getUpdateTime() {
/*  90 */     return this.updateTime;
   }
   public void setUpdateTime(Date updateTime) {
/*  93 */     this.updateTime = updateTime;
   }
   public Long getUpdateId() {
/*  96 */     return this.updateId;
   }
   public void setUpdateId(Long updateId) {
/*  99 */     this.updateId = updateId;
   }
/*     */   public Integer getIsDeleted() {
/* 102 */     return this.isDeleted;
/*     */   }
/*     */   public void setIsDeleted(Integer isDeleted) {
/* 105 */     this.isDeleted = isDeleted;
/*     */   }
/*     */ }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\AppPosConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */