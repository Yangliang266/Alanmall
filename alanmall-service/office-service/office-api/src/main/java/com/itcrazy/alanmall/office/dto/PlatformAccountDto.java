 package com.itcrazy.alanmall.office.dto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;




 public class PlatformAccountDto
   extends BaseDto
 {
   private static final long serialVersionUID = 4287558109974333997L;
   private String username;
   private Integer code;

   public String getUsername() {
/* 16 */     return this.username;
   }

   public Integer getCode() {
/* 20 */     return this.code;
   }

   public void setUsername(String username) {
/* 24 */     this.username = username;
   }

   public void setCode(Integer code) {
/* 28 */     this.code = code;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\dto\PlatformAccountDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */