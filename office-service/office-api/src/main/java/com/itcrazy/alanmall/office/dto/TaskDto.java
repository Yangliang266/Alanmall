 package com.itcrazy.alanmall.office.dto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;
 import java.util.Date;






 public class TaskDto
   extends BaseDto
 {
   private static final long serialVersionUID = 9051595851562263927L;
   private Long taskTypeId;
   private Integer syncStatus;
   private Integer isNeedDeal;
   private Date createTimeStart;
   private Date createTimeEnd;

   public Integer getIsNeedDeal() {
/* 22 */     return this.isNeedDeal;
   }
   public void setIsNeedDeal(Integer isNeedDeal) {
/* 25 */     this.isNeedDeal = isNeedDeal;
   }
   public Long getTaskTypeId() {
/* 28 */     return this.taskTypeId;
   }
   public void setTaskTypeId(Long taskTypeId) {
/* 31 */     this.taskTypeId = taskTypeId;
   }
   public Integer getSyncStatus() {
/* 34 */     return this.syncStatus;
   }
   public void setSyncStatus(Integer syncStatus) {
/* 37 */     this.syncStatus = syncStatus;
   }
   public Date getCreateTimeStart() {
/* 40 */     return this.createTimeStart;
   }
   public void setCreateTimeStart(Date createTimeStart) {
/* 43 */     this.createTimeStart = createTimeStart;
   }
   public Date getCreateTimeEnd() {
/* 46 */     return this.createTimeEnd;
   }
   public void setCreateTimeEnd(Date createTimeEnd) {
/* 49 */     this.createTimeEnd = createTimeEnd;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\dto\TaskDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */