 package com.itcrazy.alanmall.merchant.manager.impl;

 import com.itcrazy.alanmall.merchant.co.CityCo;
 import com.itcrazy.alanmall.merchant.co.ProvinceCityCo;
 import com.itcrazy.alanmall.merchant.co.StoreCityCo;
 import com.itcrazy.alanmall.merchant.dao.CityDao;
 import com.itcrazy.alanmall.merchant.manager.CityManager;
 import com.itcrazy.alanmall.merchant.model.City;
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.commons.lang.StringUtils;
 import org.apache.dubbo.config.annotation.Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.cache.annotation.Cacheable;

 @Slf4j
 @Service
 public class CityManagerImpl
   implements CityManager
 {
   @Autowired
   private CityDao cityDao;

   @Cacheable(value = {"dataCache"}, key = "(\"CityManager.getCityListById\").concat(#provinceId)", condition = "#provinceId>0L")
   public List<City> getCityListById(Long provinceId) {
/*  25 */     return this.cityDao.getCityListById(provinceId);
   }


   public List<City> getCityList() {
/*  30 */     return this.cityDao.getCityList();
   }

   @Cacheable(value = {"dataCache"}, key = "(\"CityManager.getCityName\").concat(#cityId)", condition = "#cityId>0L")
   public String getCityName(Long cityId) {
/*  35 */     City city = (City)this.cityDao.get(cityId);
/*  36 */     if (city != null) {
/*  37 */       return city.getCityCname();
     }
/*  39 */     return "";
   }

   @Cacheable(value = {"dataCache"}, key = "(\"CityManager.getCityByCode\").concat(#cityCode)")
   public City getCityByCode(String cityCode) {
/*  44 */     return this.cityDao.getCityByCode(cityCode);
   }

   @Cacheable(value = {"dataCache"}, key = "(\"CityManager.getCityByName\").concat(#name)")
   public City getCityByName(String name) {
/*  49 */     return this.cityDao.getCityByName(name);
   }

   public void setCityDao(CityDao cityDao) {
/*  53 */     this.cityDao = cityDao;
   }


   public void updateCityByName(City city) {
/*  58 */     this.cityDao.updateCityByName(city);
   }


   @Cacheable(value = {"dataCache"}, key = "(\"CityManager.getProvinceIdById\").concat(#cityId)", condition = "#cityId>0L")
   public Long getProvinceIdById(Long cityId) {
/*  64 */     City city = (City)this.cityDao.get(cityId);
/*  65 */     if (city != null) {
/*  66 */       return city.getProvinceId();
     }
/*  68 */     return null;
   }


   @Cacheable(value = {"dataCache"}, key = "(\"CityManager.getCityListByStore\").concat(#companyId).concat(#brandId)")
   public List<StoreCityCo> getCityListByStore(Long companyId, Long brandId) {
/*  74 */     List<StoreCityCo> rs = new ArrayList<>();
/*  75 */     if (companyId == null && brandId == null) {
/*  76 */       return rs;
     }
/*  78 */     Map<String, Object> param = new HashMap<>();
/*  79 */     param.put("companyId", companyId);
/*  80 */     param.put("brandId", brandId);
/*  81 */     List<City> list = this.cityDao.getCityListByStore(param);
/*  82 */     for (City city : list) {
/*  83 */       StoreCityCo sc = new StoreCityCo();
/*  84 */       sc.setPinyin(city.getFirstPinyin());
/*  85 */       String[] nameIds = city.getCityCname().split(",");
/*  86 */       for (String nameId : nameIds) {
/*  87 */         CityCo cityCo = new CityCo();
/*  88 */         String[] arr = nameId.split("-");
/*  89 */         cityCo.setName(arr[0]);
/*  90 */         cityCo.setId(arr[1]);
/*  91 */         if (arr.length > 2) {
/*  92 */           cityCo.setAdcode(arr[2]);
         }
/*  94 */         sc.addCity(cityCo);
       }
/*  96 */       rs.add(sc);
     }
/*  98 */     return rs;
   }

   @Cacheable(value = {"dataCache"}, key = "(\"CityManager.getCityListByStore4Combox\").concat(#companyId).concat(#brandId)")
   public List<CityCo> getCityListByStore4Combox(Long companyId, Long brandId) {
/* 103 */     List<CityCo> rs = new ArrayList<>();
/* 104 */     if (companyId == null && brandId == null) {
/* 105 */       return rs;
     }

/* 108 */     Map<String, Object> param = new HashMap<>();
/* 109 */     param.put("companyId", companyId);
/* 110 */     param.put("brandId", brandId);
/* 111 */     List<City> list = this.cityDao.getCityListByStore(param);
/* 112 */     for (City city : list) {
/* 113 */       String[] nameIds = city.getCityCname().split(",");
/* 114 */       for (String nameId : nameIds) {
/* 115 */         CityCo cityCo = new CityCo();
/* 116 */         String[] arr = nameId.split("-");
/* 117 */         cityCo.setName(arr[0]);
/* 118 */         cityCo.setId(arr[1]);
/* 119 */         if (arr.length > 2) {
/* 120 */           cityCo.setAdcode(arr[2]);
         }
/* 122 */         rs.add(cityCo);
       }
     }

/* 126 */     return rs;
   }

   public List<ProvinceCityCo> getProvinceCityList(Long companyId, Long brandId) {
/* 130 */     List<ProvinceCityCo> rs = new ArrayList<>();
/* 131 */     if (companyId == null && brandId == null) {
/* 132 */       return rs;
     }

/* 135 */     Map<String, Object> param = new HashMap<>();
/* 136 */     param.put("companyId", companyId);
/* 137 */     param.put("brandId", brandId);
/* 138 */     List<City> list = this.cityDao.getProvinceCityList(param);
/* 139 */     for (City city : list) {
/* 140 */       ProvinceCityCo provinceCo = new ProvinceCityCo();
/* 141 */       String[] pArr = city.getFirstPinyin().split("-");
/* 142 */       provinceCo.setName(pArr[0]);
/* 143 */       provinceCo.setId(pArr[1]);
/* 144 */       if (pArr.length > 2) {
/* 145 */         provinceCo.setAdcode(pArr[2]);
       }

/* 148 */       if (StringUtils.isNotBlank(city.getCityCname())) {
/* 149 */         String[] citiesArr = city.getCityCname().split(",");
/* 150 */         for (String strCity : citiesArr) {
/* 151 */           CityCo cityCo = new CityCo();
/* 152 */           String[] cArr = strCity.split("-");
/* 153 */           cityCo.setName(cArr[0]);
/* 154 */           cityCo.setId(cArr[1]);
/* 155 */           if (cArr.length > 2) {
/* 156 */             cityCo.setAdcode(cArr[2]);
           }
/* 158 */           provinceCo.addCity(cityCo);
         }
       }

/* 162 */       rs.add(provinceCo);
     }

/* 165 */     return rs;
   }
 }


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\CityManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */