 package com.itcrazy.alanmall.office.model;

 import com.itcrazy.alanmall.common.framework.model.BaseModelAdapter;





 public class Festival
   extends BaseModelAdapter
 {
   private static final long serialVersionUID = 4400057298420298275L;
   private Long id;
   private String name;
   private Integer status;
   private Integer showOrder;

   public Long getId() {
/* 19 */     return this.id;
   }
   public void setId(Long id) {
/* 22 */     this.id = id;
   }
   public String getName() {
/* 25 */     return this.name;
   }
   public void setName(String name) {
/* 28 */     this.name = name;
   }
   public Integer getStatus() {
/* 31 */     return this.status;
   }
   public void setStatus(Integer status) {
/* 34 */     this.status = status;
   }
   public Integer getShowOrder() {
/* 37 */     return this.showOrder;
   }
   public void setShowOrder(Integer showOrder) {
/* 40 */     this.showOrder = showOrder;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\office-api\office-api-1.180622.0-RELEASE.jar!\com\meishi\office\model\Festival.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */