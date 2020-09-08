 package com.itcrazy.alanmall.user.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;

 public class Business
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 8963913785724738169L;
   private Long id;
   private String name;
   private Integer status;
   private String remark;

   public Long getId() {
/* 20 */     return this.id;
   }
   public void setId(Long id) {
/* 23 */     this.id = id;
   }
   public String getName() {
/* 26 */     return this.name;
   }
   public void setName(String name) {
/* 29 */     this.name = name;
   }
   public Integer getStatus() {
/* 32 */     return this.status;
   }
   public void setStatus(Integer status) {
/* 35 */     this.status = status;
   }
   public String getRemark() {
/* 38 */     return this.remark;
   }
   public void setRemark(String remark) {
/* 41 */     this.remark = remark;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\model\Business.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */