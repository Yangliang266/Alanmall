 package com.itcrazy.alanmall.office.dto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;





 public class SuggestDto
   extends BaseDto
 {
   private static final long serialVersionUID = 4257617217328652959L;
   private String name;
   private String mobile;
   private String email;
   private String content;
   private String createTimeStart;
   private String createTimeEnd;

   public String getName() {
/* 21 */     return this.name;
   }
   public void setName(String name) {
/* 24 */     this.name = name;
   }
   public String getMobile() {
/* 27 */     return this.mobile;
   }
   public void setMobile(String mobile) {
/* 30 */     this.mobile = mobile;
   }
   public String getEmail() {
/* 33 */     return this.email;
   }
   public void setEmail(String email) {
/* 36 */     this.email = email;
   }
   public String getContent() {
/* 39 */     return this.content;
   }
   public void setContent(String content) {
/* 42 */     this.content = content;
   }
   public String getCreateTimeStart() {
/* 45 */     return this.createTimeStart;
   }
   public void setCreateTimeStart(String createTimeStart) {
/* 48 */     this.createTimeStart = createTimeStart;
   }
   public String getCreateTimeEnd() {
/* 51 */     return this.createTimeEnd;
   }
   public void setCreateTimeEnd(String createTimeEnd) {
/* 54 */     this.createTimeEnd = createTimeEnd;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\dto\SuggestDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */