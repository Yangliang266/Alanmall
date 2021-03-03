 package com.itcrazy.alanmall.office.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.Map;






 public class Sms
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -4459869379949977020L;
   public static final int STATUS_NEED_SEND = 1;
   public static final int STATUS_SEND_SUCCESS = 0;
   public static final int STATUS_SEND_FAILURE = 2;
   public static final int STATUS_SEND_PROCESS = 3;
   public static final int STATUS_SMS_COMMIT = 4;
   public static final int STATUS_WAIT_CHECK = 5;
   public static final int SEND_LEVEL_HIGH = 1;
   public static final int SEND_LEVEL_MIDDLE = 5;
   public static final int SEND_LEVEL_LOW = 10;
   public static final int PLATFORM_33E9 = 1;
   public static final int PLATFORM_MONGATE = 2;
   public static final int PLATFORM_EMAY = 3;
   public static final int PLATFORM_EMAY_9SDK = 4;
   public static final int PLATFORM_MANDAO = 5;
   public static final int PLATFORM_JUTONGDA = 6;
   public static final int PLATFORM_SMSBAO = 7;
   public static final int PLATFORM_YITD = 8;
   public static final int SEND_TYPE_MSG = 1;
   public static final int SEND_TYPE_VOICE = 2;
   private Long id;
   private Long customerId;
   private String mobile;
   private Long smsTypeId;
   private String smsContent;
   private Date planTime;
   private Date sendTime;
   private Integer status;
   private String createTime;
   private Date updateTime;
   private Long createId;
   private Long updateId;
   private Integer sendLevel;
   private Integer source;
   private Long storeId;
   private Long brandId;
   private Long companyId;
   private String failureReason;
   private Integer smsSendFlag;
   private String reportSequence;
   private Integer platform;
   private Long sourceId;
   private Integer sendType;
   private String validCode;

   public Long getId() {
/*  62 */     return this.id;
   }

   public void setId(Long id) {
/*  66 */     this.id = id;
   }

   public Long getCustomerId() {
/*  70 */     return this.customerId;
   }

   public void setCustomerId(Long customerId) {
/*  74 */     this.customerId = customerId;
   }

   public String getMobile() {
/*  78 */     return this.mobile;
   }

   public void setMobile(String mobile) {
/*  82 */     this.mobile = mobile;
   }

   public Long getSmsTypeId() {
/*  86 */     return this.smsTypeId;
   }

   public void setSmsTypeId(Long smsTypeId) {
/*  90 */     this.smsTypeId = smsTypeId;
   }

   public String getSmsContent() {
/*  94 */     return this.smsContent;
   }

   public void setSmsContent(String smsContent) {
/*  98 */     this.smsContent = smsContent;
   }

   public Date getPlanTime() {
/* 102 */     return this.planTime;
   }

   public void setPlanTime(Date planTime) {
/* 106 */     this.planTime = planTime;
   }

   public Date getSendTime() {
/* 110 */     return this.sendTime;
   }

   public void setSendTime(Date sendTime) {
/* 114 */     this.sendTime = sendTime;
   }

   public void setStatus(Integer status) {
/* 118 */     this.status = status;
   }

   public Integer getStatus() {
/* 122 */     return this.status;
   }

   public String getCreateTime() {
/* 126 */     return this.createTime;
   }

   public void setCreateTime(String createTime) {
/* 130 */     this.createTime = createTime;
   }

   public Date getUpdateTime() {
/* 134 */     return this.updateTime;
   }

   public void setUpdateTime(Date updateTime) {
/* 138 */     this.updateTime = updateTime;
   }

   public Long getCreateId() {
/* 142 */     return this.createId;
   }

   public void setCreateId(Long createId) {
/* 146 */     this.createId = createId;
   }

   public Long getUpdateId() {
/* 150 */     return this.updateId;
   }

   public void setUpdateId(Long updateId) {
/* 154 */     this.updateId = updateId;
   }

   public Integer getSendLevel() {
/* 158 */     return this.sendLevel;
   }

   public void setSendLevel(Integer sendLevel) {
/* 162 */     this.sendLevel = sendLevel;
   }

   public Integer getSource() {
/* 166 */     return this.source;
   }

   public void setSource(Integer source) {
/* 170 */     this.source = source;
   }

   public String getFailureReason() {
/* 174 */     return this.failureReason;
   }

   public void setFailureReason(String failureReason) {
/* 178 */     this.failureReason = failureReason;
   }

   public Integer getSmsSendFlag() {
/* 182 */     return this.smsSendFlag;
   }

   public void setSmsSendFlag(Integer smsSendFlag) {
/* 186 */     this.smsSendFlag = smsSendFlag;
   }

   public String getReportSequence() {
/* 190 */     return this.reportSequence;
   }

   public void setReportSequence(String reportSequence) {
/* 194 */     this.reportSequence = reportSequence;
   }

   public Long getStoreId() {
/* 198 */     return this.storeId;
   }

   public void setStoreId(Long storeId) {
/* 202 */     this.storeId = storeId;
   }

   public Long getBrandId() {
/* 206 */     return this.brandId;
   }

   public void setBrandId(Long brandId) {
/* 210 */     this.brandId = brandId;
   }

   public Long getCompanyId() {
/* 214 */     return this.companyId;
   }

   public void setCompanyId(Long companyId) {
/* 218 */     this.companyId = companyId;
   }

   public Integer getPlatform() {
/* 222 */     return this.platform;
   }

   public void setPlatform(Integer platform) {
/* 226 */     this.platform = platform;
   }

   public String getStatusName() {
/* 230 */     if (this.status == null) {
/* 231 */       return "未知";
     }
/* 233 */     Map<Integer, String> m = new HashMap<>();
/* 234 */     m.put(Integer.valueOf(0), "发送成功");
/* 235 */     m.put(Integer.valueOf(1), "待发送");
/* 236 */     m.put(Integer.valueOf(2), "发送失败");
/* 237 */     m.put(Integer.valueOf(3), "发送中");
/* 238 */     m.put(Integer.valueOf(4), "平台成功提交");
/* 239 */     m.put(Integer.valueOf(5), "待审核");
/* 240 */     return m.get(this.status);
   }

   public Long getSourceId() {
/* 244 */     return this.sourceId;
   }

   public void setSourceId(Long sourceId) {
/* 248 */     this.sourceId = sourceId;
   }

   public Integer getSendType() {
/* 252 */     return this.sendType;
   }

   public void setSendType(Integer sendType) {
/* 256 */     this.sendType = sendType;
   }

   public String getValidCode() {
/* 260 */     return this.validCode;
   }

   public void setValidCode(String validCode) {
/* 264 */     this.validCode = validCode;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\model\Sms.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */