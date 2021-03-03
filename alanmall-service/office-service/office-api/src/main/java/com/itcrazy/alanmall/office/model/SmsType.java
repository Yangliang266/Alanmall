 package com.itcrazy.alanmall.office.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;















 public class SmsType
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 5585601435467772425L;
   public static final long ID_CUSTOMER_REG = 1L;
   public static final long ID_CUSTOMER_FORGETPASS = 2L;
   public static final long ID_CUSTOMER_CHANGEMOBILE = 3L;
   public static final long ID_MERCHANT_TAKE_NUM = 4L;
   public static final long ID_MERCHANT_WECHAT_MOBILE = 5L;
   public static final long ID_TABLE_BOOK = 6L;
   public static final long ID_SEND_PASSWORD = 7L;
   public static final long ID_WAIT_PROMPT_NOON = 11L;
   public static final long ID_WAIT_PROMPT_EVENING = 12L;
   public static final long ID_WECHAT_COUPON = 21L;
   public static final long ID_MEMBER_CARD_CONSU = 31L;
   public static final long ID_MEMBER_PROM_NEW = 101L;
   public static final long ID_MEMBER_PROM_SMS = 102L;
   public static final long ID_MERCHANT_NOTIFY = 38L;
   public static final long ID_WECHAT_TAKEOUT = 43L;
   public static final long ID_WECHAT_TAKEOUT_TIMEOUT = 44L;
   public static final long ID_WECHAT_TAKEOUT_CONFIRM = 45L;
   public static final long ID_WECHAT_USER_APPLY = 51L;
   public static final long ID_WECHAT_CODE = 52L;
   private Long id;
   private String smsTemplate;
   private String smsName;
   private String smsCode;
   private Integer type;
   private Integer isConfig;
   private Integer configDefaultStatus;
   private Integer platform;

   public Long getId() {
/*  52 */     return this.id;
   }

   public void setId(Long id) {
/*  56 */     this.id = id;
   }

   public String getSmsTemplate() {
/*  60 */     return this.smsTemplate;
   }

   public void setSmsTemplate(String smsTemplate) {
/*  64 */     this.smsTemplate = smsTemplate;
   }

   public String getSmsName() {
/*  68 */     return this.smsName;
   }

   public void setSmsName(String smsName) {
/*  72 */     this.smsName = smsName;
   }

   public String getSmsCode() {
/*  76 */     return this.smsCode;
   }

   public void setSmsCode(String smsCode) {
/*  80 */     this.smsCode = smsCode;
   }

   public Integer getType() {
/*  84 */     return this.type;
   }

   public void setType(Integer type) {
/*  88 */     this.type = type;
   }

   public Integer getIsConfig() {
/*  92 */     return this.isConfig;
   }

   public void setIsConfig(Integer isConfig) {
/*  96 */     this.isConfig = isConfig;
   }

   public Integer getConfigDefaultStatus() {
/* 100 */     return this.configDefaultStatus;
   }

   public void setConfigDefaultStatus(Integer configDefaultStatus) {
/* 104 */     this.configDefaultStatus = configDefaultStatus;
   }

   public String getStatusName() {
/* 108 */     String str = "";
/* 109 */     if (this.configDefaultStatus == null) {
/* 110 */       return "";
     }

/* 113 */     if (this.configDefaultStatus.intValue() == 0) {
/* 114 */       str = "开启";
     } else {
/* 116 */       str = "关闭";
     }

/* 119 */     return str;
   }
   public Integer getPlatform() {
/* 122 */     return this.platform;
   }
   public void setPlatform(Integer platform) {
/* 125 */     this.platform = platform;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\model\SmsType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */