 package com.itcrazy.alanmall.user.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;

 public class Module
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 5614192929199640950L;
   public static final long ID_TOP_PARENT = 0L;
   public static final long ID_CRM_MEMBER = 1001L;
   public static final long ID_CRM_TRADE = 1101L;
   public static final long ID_CRM_PROM = 1115L;
   public static final long ID_CRM_ANAY = 1139L;
   public static final long ID_CRM_WECHAT = 1146L;
   public static final long ID_CRM_CONFIG = 1179L;
   private Long id;
   private Long parentId;
   private String name;
   private Integer status;
   private Long businessId;
   private Integer system;
   private Integer showOrder;

   public Long getId() {
/* 30 */     return this.id;
   }
   public void setId(Long id) {
/* 33 */     this.id = id;
   }
   public Long getParentId() {
/* 36 */     return this.parentId;
   }
   public void setParentId(Long parentId) {
/* 39 */     this.parentId = parentId;
   }
   public String getName() {
/* 42 */     return this.name;
   }
   public void setName(String name) {
/* 45 */     this.name = name;
   }
   public Integer getStatus() {
/* 48 */     return this.status;
   }
   public void setStatus(Integer status) {
/* 51 */     this.status = status;
   }
   public Long getBusinessId() {
/* 54 */     return this.businessId;
   }
   public void setBusinessId(Long businessId) {
/* 57 */     this.businessId = businessId;
   }
   public Integer getSystem() {
/* 60 */     return this.system;
   }
   public void setSystem(Integer system) {
/* 63 */     this.system = system;
   }
   public Integer getShowOrder() {
/* 66 */     return this.showOrder;
   }
   public void setShowOrder(Integer showOrder) {
/* 69 */     this.showOrder = showOrder;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\tem\\user-ap\\user-api-1.180516.0-RELEASE.jar!\com\meish\\user\model\Module.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */