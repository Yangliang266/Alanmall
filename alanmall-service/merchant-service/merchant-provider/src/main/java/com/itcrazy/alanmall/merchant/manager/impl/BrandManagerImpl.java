 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.common.framework.model.BaseModel;
 import com.itcrazy.alanmall.merchant.dao.BrandCuisineDao;
 import com.itcrazy.alanmall.merchant.dao.BrandDao;
 import com.itcrazy.alanmall.merchant.dao.StoreDao;
 import com.itcrazy.alanmall.merchant.dto.BrandDto;
 import com.itcrazy.alanmall.merchant.manager.BrandManager;
 import com.itcrazy.alanmall.merchant.model.Brand;
 import com.itcrazy.alanmall.merchant.model.BrandCuisine;
 import com.itcrazy.alanmall.merchant.model.Store;
 import java.util.List;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.Cacheable;

 @Slf4j
 @Service
 public class BrandManagerImpl implements BrandManager {
   @Autowired
   private BrandDao brandDao;
   @Autowired
   private StoreDao storeDao;
   @Autowired
   private BrandCuisineDao brandCuisineDao;

   @Cacheable(value = {"dataCache"}, key = "(\"brandManager\").concat(#id)", condition = "#id>0L")
   public Brand getBrandById(Long id) {
/*  27 */     return (Brand)this.brandDao.get(id);
   }

   public Brand getBrandBySourceCode(Integer source, String sourceCode) {
/*  31 */     BrandDto dto = new BrandDto();
/*  32 */     dto.setSource(source);
/*  33 */     dto.setSourceCode(sourceCode);
/*  34 */     return this.brandDao.getBrandByDto(dto);
   }

   public Brand addBrand(Brand brand) {
/*  38 */     this.brandDao.save(brand);
/*  39 */     return brand;
   }


   public void passBrand(Long brandId, Long managerId) {
/*  44 */     Brand brand = new Brand();
/*  45 */     brand.setId(brandId);
/*  46 */     brand.setUpdateId(managerId);
/*  47 */     brand.setStatus(Integer.valueOf(0));

/*  49 */     updateBrand(brand);
   }


   public void disableBrand(Long brandId, Long managerId) {
/*  54 */     Brand brand = new Brand();
/*  55 */     brand.setId(brandId);
/*  56 */     brand.setUpdateId(managerId);
/*  57 */     brand.setStatus(Integer.valueOf(21));

/*  59 */     updateBrand(brand);

/*  61 */     Store store = new Store();
/*  62 */     store.setBrandId(brandId);
/*  63 */     store.setUpdateId(managerId);
/*  64 */     store.setStatus(Integer.valueOf(21));
/*  65 */     this.storeDao.update(store);
   }



   public List<Brand> getPageList(BrandDto brandDto) {
/*  71 */     List<Brand> brandList = this.brandDao.getPageList(brandDto);
/*  72 */     if (brandList != null && brandList.size() > 0) {
/*  73 */       for (Brand brand : brandList) {
/*  74 */         BrandCuisine brandCuisine = new BrandCuisine();
/*  75 */         brandCuisine.setBrandId(brand.getId());
/*  76 */         brandCuisine.setType(brand.getBusinessType());

/*  78 */         List<BrandCuisine> bcList = this.brandCuisineDao.getCuisineClassListByBrandId(brandCuisine);
/*  79 */         StringBuilder sb = new StringBuilder();
/*  80 */         for (BrandCuisine bc : bcList) {
/*  81 */           sb.append(bc.getCuisineClassName());
/*  82 */           sb.append(bc.getCuisineName());
/*  83 */           sb.append("&nbsp;&nbsp;");
         }
/*  85 */         brand.setBrandCuisine(sb.toString());
       }
     }

/*  89 */     return brandList;
   }


   public List<Brand> getBrandListBasic(BrandDto brandDto) {
/*  94 */     List<Brand> brandList = this.brandDao.getPageList(brandDto);
/*  95 */     return brandList;
   }

   public Integer getPageTotal(BrandDto brandDto) {
/*  99 */     return this.brandDao.getPageTotal(brandDto);
   }

   @CacheEvict(value = {"dataCache"}, key = "(\"brandManager\").concat(#brand.getId())")
   public int removeBrand(Brand brand) {
/* 104 */     return this.brandDao.remove(brand);
   }


   @CacheEvict(value = {"dataCache"}, key = "(\"brandManager\").concat(#brand.getId())")
   public int updateBrand(Brand brand) {
/* 110 */     return this.brandDao.update(brand);
   }





   public List<Brand> getAdminBrandList(BrandDto brandDto) {
/* 118 */     return this.brandDao.getAdminBrandList(brandDto);
   }

   public void setBrandDao(BrandDao brandDao) {
/* 122 */     this.brandDao = brandDao;
   }

   public void setStoreDao(StoreDao storeDao) {
/* 126 */     this.storeDao = storeDao;
   }

   public void setBrandCuisineDao(BrandCuisineDao brandCuisineDao) {
/* 130 */     this.brandCuisineDao = brandCuisineDao;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\BrandManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */