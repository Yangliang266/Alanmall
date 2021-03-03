 package com.itcrazy.alanmall.merchant.dto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;

 import java.util.Date;

 public class AppPosConfigDto
   extends BaseDto
 {
   private static final long serialVersionUID = 2873591205286521140L;
   private Long id;
   private Long companyId;
   private Long brandId;
   private Long storeId;
   private Integer consuWay;
   private Integer wechatPayWay;
   private Integer aliPayWay;
   private Date createTimeStart;
   private Date createTimeEnd;

   public Long getId() {
/* 25 */     return this.id;
   }
   public void setId(Long id) {
/* 28 */     this.id = id;
   }
   public Long getCompanyId() {
/* 31 */     return this.companyId;
   }
   public void setCompanyId(Long companyId) {
/* 34 */     this.companyId = companyId;
   }
   public Long getBrandId() {
/* 37 */     return this.brandId;
   }
   public void setBrandId(Long brandId) {
/* 40 */     this.brandId = brandId;
   }
   public Long getStoreId() {
/* 43 */     return this.storeId;
   }
   public void setStoreId(Long storeId) {
/* 46 */     this.storeId = storeId;
   }
   public Integer getConsuWay() {
/* 49 */     return this.consuWay;
   }
   public Integer getWechatPayWay() {
/* 52 */     return this.wechatPayWay;
   }
   public Integer getAliPayWay() {
/* 55 */     return this.aliPayWay;
   }
   public Date getCreateTimeStart() {
/* 58 */     return this.createTimeStart;
   }
   public Date getCreateTimeEnd() {
/* 61 */     return this.createTimeEnd;
   }
   public void setConsuWay(Integer consuWay) {
/* 64 */     this.consuWay = consuWay;
   }
   public void setWechatPayWay(Integer wechatPayWay) {
/* 67 */     this.wechatPayWay = wechatPayWay;
   }
   public void setAliPayWay(Integer aliPayWay) {
/* 70 */     this.aliPayWay = aliPayWay;
   }
   public void setCreateTimeStart(Date createTimeStart) {
/* 73 */     this.createTimeStart = createTimeStart;
   }
   public void setCreateTimeEnd(Date createTimeEnd) {
/* 76 */     this.createTimeEnd = createTimeEnd;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\dto\AppPosConfigDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */