 package com.itcrazy.alanmall.user.carddto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;

 public class CompanyBusinessDto extends BaseDto {
   private static final long serialVersionUID = 7069178158347922785L;
   private Long companyId;
   private Long businessId;

   public Long getCompanyId() {
/* 14 */     return this.companyId;
   }
   public void setCompanyId(Long companyId) {
/* 17 */     this.companyId = companyId;
   }
   public Long getBusinessId() {
/* 20 */     return this.businessId;
   }
   public void setBusinessId(Long businessId) {
/* 23 */     this.businessId = businessId;
   }
 }


