 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;


 public class BrandCall
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 1L;
/* 11 */   public static final Integer STATUS_CALLING = Integer.valueOf(1);
/* 12 */   public static final Integer STATUS_CALL_END = Integer.valueOf(2);

   private Long id;
   private Long companyId;
   private Long brandId;
   private Integer status;
   private String callPhone;
   private String seatCode;
   private String mobile;
   private Date createTime;
   private Date responseTime;

   public Long getId() {
/* 25 */     return this.id;
   }

   public void setId(Long id) {
/* 29 */     this.id = id;
   }

   public Long getCompanyId() {
/* 33 */     return this.companyId;
   }

   public void setCompanyId(Long companyId) {
/* 37 */     this.companyId = companyId;
   }

   public Long getBrandId() {
/* 41 */     return this.brandId;
   }

   public void setBrandId(Long brandId) {
/* 45 */     this.brandId = brandId;
   }

   public Integer getStatus() {
/* 49 */     return this.status;
   }

   public void setStatus(Integer status) {
/* 53 */     this.status = status;
   }

   public String getCallPhone() {
/* 57 */     return this.callPhone;
   }

   public void setCallPhone(String callPhone) {
/* 61 */     this.callPhone = callPhone;
   }

   public String getMobile() {
/* 65 */     return this.mobile;
   }

   public void setMobile(String mobile) {
/* 69 */     this.mobile = mobile;
   }

   public String getSeatCode() {
/* 73 */     return this.seatCode;
   }

   public void setSeatCode(String seatCode) {
/* 77 */     this.seatCode = seatCode;
   }

   public Date getCreateTime() {
/* 81 */     return this.createTime;
   }

   public void setCreateTime(Date createTime) {
/* 85 */     this.createTime = createTime;
   }

   public Date getResponseTime() {
/* 89 */     return this.responseTime;
   }

   public void setResponseTime(Date responseTime) {
/* 93 */     this.responseTime = responseTime;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\BrandCall.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */