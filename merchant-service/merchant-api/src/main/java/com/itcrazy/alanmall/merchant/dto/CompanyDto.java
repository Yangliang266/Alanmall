 package com.itcrazy.alanmall.merchant.dto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;
 import java.util.Date;

 public class CompanyDto
   extends BaseDto
 {
   private static final long serialVersionUID = -4049415282590229056L;
   private Date startTime;
   private Date endTime;
   private String name;
   private Integer status;
   private Integer source;
   private String sourceCode;
   private Long createId;

   public Date getStartTime() {
/* 22 */     return this.startTime;
   }

   public void setStartTime(Date startTime) {
/* 26 */     this.startTime = startTime;
   }

   public Date getEndTime() {
/* 30 */     return this.endTime;
   }

   public void setEndTime(Date endTime) {
/* 34 */     this.endTime = endTime;
   }

   public String getName() {
/* 38 */     return this.name;
   }

   public void setName(String name) {
/* 42 */     this.name = name;
   }

   public Integer getStatus() {
/* 46 */     return this.status;
   }

   public void setStatus(Integer status) {
/* 50 */     this.status = status;
   }

   public Integer getSource() {
/* 54 */     return this.source;
   }

   public void setSource(Integer source) {
/* 58 */     this.source = source;
   }

   public String getSourceCode() {
/* 62 */     return this.sourceCode;
   }

   public void setSourceCode(String sourceCode) {
/* 66 */     this.sourceCode = sourceCode;
   }

   public Long getCreateId() {
/* 70 */     return this.createId;
   }

   public void setCreateId(Long createId) {
/* 74 */     this.createId = createId;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\dto\CompanyDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */