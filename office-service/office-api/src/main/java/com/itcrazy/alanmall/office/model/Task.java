 package com.itcrazy.alanmall.office.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;


 public class Task
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 4174057126115751020L;
   public static final int SYNC_STATUS_NEED_DEAL = 1;
   public static final int SYNC_STATUS_COMPLETE = 0;
   private Long id;
   private Long taskTypeId;
   private String data;
   private Integer syncStatus;
   private Integer resultCode;
   private String resultMsg;
   private Integer source;

   public Long getId() {
/* 21 */     return this.id;
   }
   public void setId(Long id) {
/* 24 */     this.id = id;
   }
   public Long getTaskTypeId() {
/* 27 */     return this.taskTypeId;
   }
   public void setTaskTypeId(Long taskTypeId) {
/* 30 */     this.taskTypeId = taskTypeId;
   }
   public String getData() {
/* 33 */     return this.data;
   }
   public void setData(String data) {
/* 36 */     this.data = data;
   }
   public Integer getSyncStatus() {
/* 39 */     return this.syncStatus;
   }
   public void setSyncStatus(Integer syncStatus) {
/* 42 */     this.syncStatus = syncStatus;
   }
   public Integer getResultCode() {
/* 45 */     return this.resultCode;
   }
   public void setResultCode(Integer resultCode) {
/* 48 */     this.resultCode = resultCode;
   }
   public String getResultMsg() {
/* 51 */     return this.resultMsg;
   }
   public void setResultMsg(String resultMsg) {
/* 54 */     this.resultMsg = resultMsg;
   }
   public Integer getSource() {
/* 57 */     return this.source;
   }
   public void setSource(Integer source) {
/* 60 */     this.source = source;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\model\Task.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */