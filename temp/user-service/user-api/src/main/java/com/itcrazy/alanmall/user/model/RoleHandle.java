 package com.itcrazy.alanmall.user.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;

 public class RoleHandle
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -7336488607775965043L;
   private Long id;
   private Long roleId;
   private Long handleId;
   private Long createId;
   private Long updateId;

   public Long getId() {
/* 17 */     return this.id;
   }
   public void setId(Long id) {
/* 20 */     this.id = id;
   }
   public Long getRoleId() {
/* 23 */     return this.roleId;
   }
   public void setRoleId(Long roleId) {
/* 26 */     this.roleId = roleId;
   }
   public Long getCreateId() {
/* 29 */     return this.createId;
   }
   public void setCreateId(Long createId) {
/* 32 */     this.createId = createId;
   }
   public Long getUpdateId() {
/* 35 */     return this.updateId;
   }
   public void setUpdateId(Long updateId) {
/* 38 */     this.updateId = updateId;
   }
   public Long getHandleId() {
/* 41 */     return this.handleId;
   }
   public void setHandleId(Long handleId) {
/* 44 */     this.handleId = handleId;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\model\RoleHandle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */