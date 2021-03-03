 package com.itcrazy.alanmall.office.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;





 public class PlatformSms
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -347083859000617809L;
   public static final int TYPE_MANDAO = 5;
   public static final int TYPE_JUTONGDA = 6;
   public static final int TYPE_SMSBAO = 7;
   public static final int TYPE_YITD = 8;
   private Long id;
   private String name;
   private Integer type;
   private Integer isUse;

   public Long getId() {
/* 23 */     return this.id;
   }
   public String getName() {
/* 26 */     return this.name;
   }
   public Integer getType() {
/* 29 */     return this.type;
   }
   public Integer getIsUse() {
/* 32 */     return this.isUse;
   }
   public void setId(Long id) {
/* 35 */     this.id = id;
   }
   public void setName(String name) {
/* 38 */     this.name = name;
   }
   public void setType(Integer type) {
/* 41 */     this.type = type;
   }
   public void setIsUse(Integer isUse) {
/* 44 */     this.isUse = isUse;
   }

   public String getIsUseName() {
/* 48 */     if (this.isUse != null && this.isUse.intValue() == 1) {
/* 49 */       return "是";
     }

/* 52 */     return "否";
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\model\PlatformSms.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */