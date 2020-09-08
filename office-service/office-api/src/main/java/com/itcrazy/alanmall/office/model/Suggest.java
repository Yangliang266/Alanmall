 package com.itcrazy.alanmall.office.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;





 public class Suggest
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 1375767921283096721L;
   private Long id;
   private String name;
   private String mobile;
   private String email;
   private String content;
   private Date createTime;

   public Long getId() {
/* 22 */     return this.id;
   }
   public void setId(Long id) {
/* 25 */     this.id = id;
   }
   public String getName() {
/* 28 */     return this.name;
   }
   public void setName(String name) {
/* 31 */     this.name = name;
   }
   public String getMobile() {
/* 34 */     return this.mobile;
   }
   public void setMobile(String mobile) {
/* 37 */     this.mobile = mobile;
   }
   public String getEmail() {
/* 40 */     return this.email;
   }
   public void setEmail(String email) {
/* 43 */     this.email = email;
   }
   public String getContent() {
/* 46 */     return this.content;
   }
   public void setContent(String content) {
/* 49 */     this.content = content;
   }
   public Date getCreateTime() {
/* 52 */     return this.createTime;
   }
   public void setCreateTime(Date createTime) {
/* 55 */     this.createTime = createTime;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\model\Suggest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */