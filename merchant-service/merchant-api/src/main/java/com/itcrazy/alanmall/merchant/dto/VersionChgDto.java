 package com.itcrazy.alanmall.merchant.dto;

 import com.itcrazy.alanmall.common.framework.dto.BaseDto;

 public class VersionChgDto
   extends BaseDto
 {
   private static final long serialVersionUID = 4359210223095090136L;
   private Long id;
   private String name;
   private String url;
   private Integer isVisual;
   private Integer isDelete;

   public Long getId() {
/* 18 */     return this.id;
   }
   public String getName() {
/* 21 */     return this.name;
   }
   public String getUrl() {
/* 24 */     return this.url;
   }
   public Integer getIsVisual() {
/* 27 */     return this.isVisual;
   }
   public Integer getIsDelete() {
/* 30 */     return this.isDelete;
   }
   public void setId(Long id) {
/* 33 */     this.id = id;
   }
   public void setName(String name) {
/* 36 */     this.name = name;
   }
   public void setUrl(String url) {
/* 39 */     this.url = url;
   }
   public void setIsVisual(Integer isVisual) {
/* 42 */     this.isVisual = isVisual;
   }
   public void setIsDelete(Integer isDelete) {
/* 45 */     this.isDelete = isDelete;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\dto\VersionChgDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */