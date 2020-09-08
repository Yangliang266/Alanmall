 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;
 import java.util.Date;

























 public class UnionRecmdRecord
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -1240499887985040683L;
   public static final int TYPE_CARD = 1;
   public static final int TYPE_AD = 2;
   private Long id;
   private Long consuBrandId;
   private Long wechatUserId;
   private Long recmdBrandId;
   private Integer type;
   private Long recmdResourceId;
   private Date createTime;

   public Long getId() {
/* 45 */     return this.id;
   }

   public void setId(Long id) {
/* 49 */     this.id = id;
   }

   public Long getConsuBrandId() {
/* 53 */     return this.consuBrandId;
   }

   public void setConsuBrandId(Long consuBrandId) {
/* 57 */     this.consuBrandId = consuBrandId;
   }

   public Long getWechatUserId() {
/* 61 */     return this.wechatUserId;
   }

   public void setWechatUserId(Long wechatUserId) {
/* 65 */     this.wechatUserId = wechatUserId;
   }

   public Long getRecmdBrandId() {
/* 69 */     return this.recmdBrandId;
   }

   public void setRecmdBrandId(Long recmdBrandId) {
/* 73 */     this.recmdBrandId = recmdBrandId;
   }

   public Integer getType() {
/* 77 */     return this.type;
   }

   public void setType(Integer type) {
/* 81 */     this.type = type;
   }

   public Long getRecmdResourceId() {
/* 85 */     return this.recmdResourceId;
   }

   public void setRecmdResourceId(Long recmdResourceId) {
/* 89 */     this.recmdResourceId = recmdResourceId;
   }

   public Date getCreateTime() {
/* 93 */     return this.createTime;
   }

   public void setCreateTime(Date createTime) {
/* 97 */     this.createTime = createTime;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\UnionRecmdRecord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */