 package com.itcrazy.alanmall.merchant.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;







 public class StoreTag
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 5683953069408433452L;
   private Long id;
   private Long storeId;
   private String tagName;
   private Integer hits;

   public Long getId() {
/* 21 */     return this.id;
   }

   public void setId(Long id) {
/* 25 */     this.id = id;
   }

   public Long getStoreId() {
/* 29 */     return this.storeId;
   }

   public void setStoreId(Long storeId) {
/* 33 */     this.storeId = storeId;
   }

   public String getTagName() {
/* 37 */     return this.tagName;
   }

   public void setTagName(String tagName) {
/* 41 */     this.tagName = tagName;
   }

   public Integer getHits() {
/* 45 */     return this.hits;
   }

   public void setHits(Integer hits) {
/* 49 */     this.hits = hits;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-api\merchant-api-1.180906.7-RELEASE.jar!\com\meishi\merchant\model\StoreTag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */