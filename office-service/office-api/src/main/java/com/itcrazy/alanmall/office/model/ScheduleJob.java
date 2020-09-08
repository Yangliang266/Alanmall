 package com.itcrazy.alanmall.office.model;

 import java.util.Date;



































 public class ScheduleJob
 {
   public static final String STATUS_RUNNING = "1";
   public static final String STATUS_NOT_RUNNING = "0";
   public static final String CONCURRENT_IS = "1";
   public static final String CONCURRENT_NOT = "0";
   private Long jobId;
   private Date createTime;
   private Date updateTime;
   private String jobName;
   private String jobGroup;
   private String jobStatus;
   private String cronExpression;
   private String description;
   private String beanClass;
   private String isConcurrent;
   private String springId;
   private String methodName;

   public Long getJobId() {
/*  59 */     return this.jobId;
   }

   public void setJobId(Long jobId) {
/*  63 */     this.jobId = jobId;
   }

   public Date getCreateTime() {
/*  67 */     return this.createTime;
   }

   public void setCreateTime(Date createTime) {
/*  71 */     this.createTime = createTime;
   }

   public Date getUpdateTime() {
/*  75 */     return this.updateTime;
   }

   public void setUpdateTime(Date updateTime) {
/*  79 */     this.updateTime = updateTime;
   }

   public String getJobName() {
/*  83 */     return this.jobName;
   }

   public void setJobName(String jobName) {
/*  87 */     this.jobName = jobName;
   }

   public String getJobGroup() {
/*  91 */     return this.jobGroup;
   }

   public void setJobGroup(String jobGroup) {
/*  95 */     this.jobGroup = jobGroup;
   }

   public String getJobStatus() {
/*  99 */     return this.jobStatus;
   }

   public void setJobStatus(String jobStatus) {
/* 103 */     this.jobStatus = jobStatus;
   }

   public String getCronExpression() {
/* 107 */     return this.cronExpression;
   }

   public void setCronExpression(String cronExpression) {
/* 111 */     this.cronExpression = cronExpression;
   }

   public String getDescription() {
/* 115 */     return this.description;
   }

   public void setDescription(String description) {
/* 119 */     this.description = description;
   }

   public String getBeanClass() {
/* 123 */     return this.beanClass;
   }

   public void setBeanClass(String beanClass) {
/* 127 */     this.beanClass = beanClass;
   }

   public String getIsConcurrent() {
/* 131 */     return this.isConcurrent;
   }

   public void setIsConcurrent(String isConcurrent) {
/* 135 */     this.isConcurrent = isConcurrent;
   }

   public String getSpringId() {
/* 139 */     return this.springId;
   }

   public void setSpringId(String springId) {
/* 143 */     this.springId = springId;
   }

   public String getMethodName() {
/* 147 */     return this.methodName;
   }

   public void setMethodName(String methodName) {
/* 151 */     this.methodName = methodName;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\model\ScheduleJob.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */