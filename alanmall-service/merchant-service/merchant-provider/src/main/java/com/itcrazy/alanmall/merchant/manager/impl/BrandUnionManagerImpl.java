 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.merchant.dao.BrandUnionDao;
 import com.itcrazy.alanmall.merchant.dto.BrandUnionDto;
 import com.itcrazy.alanmall.merchant.manager.BrandUnionManager;
 import com.itcrazy.alanmall.merchant.model.BrandUnion;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.Cacheable;





 @Slf4j
 @Service
 public class BrandUnionManagerImpl
   implements BrandUnionManager
 {
   @Autowired
   private BrandUnionDao brandUnionDao;

   public BrandUnion addBrandUnion(BrandUnion brandUnion) {
/*  25 */     BrandUnion bu = this.brandUnionDao.getBySrcDstId(brandUnion);
/*  26 */     if (bu == null) {
/*  27 */       this.brandUnionDao.save(brandUnion);
     } else {
/*  29 */       brandUnion.setId(bu.getId());
/*  30 */       updateBrandUnion(brandUnion);
     }
/*  32 */     return brandUnion;
   }


   @Cacheable(value = {"dataCache"}, key = "(\"BrandUnionManager.getBrandUnionById\").concat(#id)", condition = "#id>0L")
   public BrandUnion getBrandUnionById(Long id) {
/*  38 */     return (BrandUnion)this.brandUnionDao.get(id);
   }


   @CacheEvict(value = {"dataCache"}, key = "(\"BrandUnionManager.getBrandUnionById\").concat(#brandUnion.getId())", condition = "#brandUnion.getId()>0L")
   public int updateBrandUnion(BrandUnion brandUnion) {
/*  44 */     return this.brandUnionDao.update(brandUnion);
   }


   @CacheEvict(value = {"dataCache"}, key = "(\"BrandUnionManager.getBrandUnionById\").concat(#brandUnion.getId())", condition = "#brandUnion.getId()>0L")
   public int deleteBrandUnion(BrandUnion brandUnion) {
/*  50 */     return this.brandUnionDao.remove(brandUnion);
   }


   public List<BrandUnion> getPageList(BrandUnionDto dto) {
/*  55 */     return this.brandUnionDao.getPageList(dto);
   }


   public Integer getPageTotal(BrandUnionDto dto) {
/*  60 */     return this.brandUnionDao.getPageTotal(dto);
   }


   public List<BrandUnion> getPageListBySrcId(BrandUnionDto dto) {
/*  65 */     return this.brandUnionDao.getPageListBySrcId(dto);
   }


   public Integer getPageTotalBySrcId(BrandUnionDto dto) {
/*  70 */     return this.brandUnionDao.getPageTotalBySrcId(dto);
   }


   public List<BrandUnion> getBrandUnionList(BrandUnion brandUnion) {
/*  75 */     return this.brandUnionDao.getBrandUnionList(brandUnion);
   }


   public BrandUnion getBrandUnionBySrcAndDst(BrandUnion brandUnion) {
/*  80 */     return this.brandUnionDao.getBrandUnionBySrcAndDst(brandUnion);
   }


   public Integer getUnionTotal(BrandUnionDto brandUnionDto) {
/*  85 */     return this.brandUnionDao.getUnionTotal(brandUnionDto);
   }


   public Integer getBindTotal(BrandUnionDto brandUnionDto) {
/*  90 */     return this.brandUnionDao.getBindTotal(brandUnionDto);
   }


   public List<BrandUnion> getRecmdBrandUnionList(BrandUnion brandUnion) {
/*  95 */     return this.brandUnionDao.getRecmdBrandUnionList(brandUnion);
   }


   public List<BrandUnion> getNextRecmdBrandUnionList(BrandUnion brandUnion) {
/* 100 */     return this.brandUnionDao.getNextRecmdBrandUnionList(brandUnion);
   }

   public void setbrandUnionDao(BrandUnionDao brandUnionDao) {
/* 104 */     this.brandUnionDao = brandUnionDao;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\BrandUnionManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */