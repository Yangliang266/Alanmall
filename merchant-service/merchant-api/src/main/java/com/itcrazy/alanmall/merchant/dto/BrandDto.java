 package com.itcrazy.alanmall.merchant.dto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;

 public class BrandDto
   extends BaseDto
 {
   private static final long serialVersionUID = 1603889853712211139L;
   private Long companyId;
   private Long brandId;
   private String name;
   private Integer status;
   private Integer source;
   private String sourceCode;
   private String searchBrandName;
   private String brandIds;
   private Long createId;

   public Long getCompanyId() {
/* 21 */     return this.companyId;
   }

   public void setCompanyId(Long companyId) {
/* 25 */     this.companyId = companyId;
   }

   public String getName() {
/* 29 */     return this.name;
   }

   public void setName(String name) {
/* 33 */     this.name = name;
   }

   public Integer getStatus() {
/* 37 */     return this.status;
   }

   public void setStatus(Integer status) {
/* 41 */     this.status = status;
   }

   public Integer getSource() {
/* 45 */     return this.source;
   }

   public void setSource(Integer source) {
/* 49 */     this.source = source;
   }

   public String getSourceCode() {
/* 53 */     return this.sourceCode;
   }

   public void setSourceCode(String sourceCode) {
/* 57 */     this.sourceCode = sourceCode;
   }

   public String getSearchBrandName() {
/* 61 */     return this.searchBrandName;
   }

   public void setSearchBrandName(String searchBrandName) {
/* 65 */     this.searchBrandName = searchBrandName;
   }

   public Long getBrandId() {
/* 69 */     return this.brandId;
   }

   public void setBrandId(Long brandId) {
/* 73 */     this.brandId = brandId;
   }

   public String getBrandIds() {
/* 77 */     return this.brandIds;
   }

   public void setBrandIds(String brandIds) {
/* 81 */     this.brandIds = brandIds;
   }

   public Long getCreateId() {
/* 85 */     return this.createId;
   }

   public void setCreateId(Long createId) {
/* 89 */     this.createId = createId;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\dto\BrandDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */