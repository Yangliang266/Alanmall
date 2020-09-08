 package com.itcrazy.alanmall.merchant.dto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;
 import java.util.Date;

 public class ProvinceDto
   extends BaseDto
 {
   private static final long serialVersionUID = 3523290408748994546L;
   private Long id;
   private Long brandId;
   private Long wechatConfigId;
   private Date orderDate;
   private Integer storeTimeId;

   public Long getId() {
/* 21 */     return this.id;
   }

   public void setId(Long id) {
/* 25 */     this.id = id;
   }

   public Long getWechatConfigId() {
/* 29 */     return this.wechatConfigId;
   }

   public void setWechatConfigId(Long wechatConfigId) {
/* 33 */     this.wechatConfigId = wechatConfigId;
   }

   public Long getBrandId() {
/* 37 */     return this.brandId;
   }

   public void setBrandId(Long brandId) {
/* 41 */     this.brandId = brandId;
   }

   public Date getOrderDate() {
/* 45 */     return this.orderDate;
   }

   public void setOrderDate(Date orderDate) {
/* 49 */     this.orderDate = orderDate;
   }

   public Integer getStoreTimeId() {
/* 53 */     return this.storeTimeId;
   }

   public void setStoreTimeId(Integer storeTimeId) {
/* 57 */     this.storeTimeId = storeTimeId;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\dto\ProvinceDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */