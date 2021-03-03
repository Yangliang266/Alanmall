 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;


 public class VersionChg
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = -6852791281938304760L;
   private Long id;
   private String name;
   private String url;
   private Integer isVisual;
   private Integer isDelete;

   public Long getId() {
/* 17 */     return this.id;
   }
   public String getName() {
/* 20 */     return this.name;
   }
   public String getUrl() {
/* 23 */     return this.url;
   }
   public Integer getIsVisual() {
/* 26 */     return this.isVisual;
   }
   public Integer getIsDelete() {
/* 29 */     return this.isDelete;
   }
   public void setId(Long id) {
/* 32 */     this.id = id;
   }
   public void setName(String name) {
/* 35 */     this.name = name;
   }
   public void setUrl(String url) {
/* 38 */     this.url = url;
   }
   public void setIsVisual(Integer isVisual) {
/* 41 */     this.isVisual = isVisual;
   }
   public void setIsDelete(Integer isDelete) {
/* 44 */     this.isDelete = isDelete;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\VersionChg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */