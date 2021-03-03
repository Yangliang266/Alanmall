 package com.itcrazy.alanmall.office.dto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;
 import java.util.Date;



 public class WeekYearDto
   extends BaseDto
 {
   private static final long serialVersionUID = 2908300409497813684L;
   private Long id;
   private Date targetDate;
   private Date targetDateStart;
   private Date targetDateEnd;

   public Long getId() {
/* 18 */     return this.id;
   }
   public void setId(Long id) {
/* 21 */     this.id = id;
   }
   public Date getTargetDate() {
/* 24 */     return this.targetDate;
   }
   public void setTargetDate(Date targetDate) {
/* 27 */     this.targetDate = targetDate;
   }
   public Date getTargetDateStart() {
/* 30 */     return this.targetDateStart;
   }
   public void setTargetDateStart(Date targetDateStart) {
/* 33 */     this.targetDateStart = targetDateStart;
   }
   public Date getTargetDateEnd() {
/* 36 */     return this.targetDateEnd;
   }
   public void setTargetDateEnd(Date targetDateEnd) {
/* 39 */     this.targetDateEnd = targetDateEnd;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\dto\WeekYearDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */