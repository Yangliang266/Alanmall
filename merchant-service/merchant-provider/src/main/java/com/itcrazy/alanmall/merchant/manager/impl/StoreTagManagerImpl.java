package com.itcrazy.alanmall.merchant.manager.impl;

import com.itcrazy.alanmall.common.framework.model.BaseModel;
import com.itcrazy.alanmall.merchant.dao.BrandCuisineDao;
import com.itcrazy.alanmall.merchant.dao.BrandDao;
import com.itcrazy.alanmall.merchant.dao.BusinessCircleDao;
import com.itcrazy.alanmall.merchant.dao.CompanyDao;
import com.itcrazy.alanmall.merchant.dao.LandMarkDao;
import com.itcrazy.alanmall.merchant.dao.StoreDao;
import com.itcrazy.alanmall.merchant.dao.StoreTagDao;
import com.itcrazy.alanmall.merchant.dto.StoreDto;
import com.itcrazy.alanmall.merchant.manager.StoreTagManager;
import com.itcrazy.alanmall.merchant.model.Brand;
import com.itcrazy.alanmall.merchant.model.BrandCuisine;
import com.itcrazy.alanmall.merchant.model.BusinessCircle;
import com.itcrazy.alanmall.merchant.model.Company;
import com.itcrazy.alanmall.merchant.model.LandMark;
import com.itcrazy.alanmall.merchant.model.Store;
import com.itcrazy.alanmall.merchant.model.StoreTag;

import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@Slf4j
@Service
public class StoreTagManagerImpl
        implements StoreTagManager {
    @Autowired
    private StoreDao storeDao;
    @Autowired
    private BrandDao brandDao;
    @Autowired
    private StoreTagDao storeTagDao;
    @Autowired
    private LandMarkDao landMarkDao;
    @Autowired
    private BusinessCircleDao businessCircleDao;
    @Autowired
    private BrandCuisineDao brandCuisineDao;
    @Autowired
    private CompanyDao companyDao;

    public int updateStoreTagByTime(Date updateTime) throws Exception {
        /*  44 */
        StoreDto storeDto = new StoreDto();
        /*  45 */
        storeDto.setUpdateStartTime(updateTime);
        /*  46 */
        storeDto.setStatus(Integer.valueOf(0));
        /*  47 */
        storeDto.setLimit(1000);
        /*  48 */
        List<Store> storeList = this.storeDao.getPageList(storeDto);
        /*  49 */
        for (Store s : storeList) {
            /*  50 */
            StringBuilder tag = new StringBuilder();

            /*  52 */
            Company company = (Company) this.companyDao.get(s.getCompanyId());
            /*  53 */
            if (company != null) {
                /*  54 */
                tag.append(company.getName());
            }
            /*  56 */
            Brand brand = (Brand) this.brandDao.get(s.getBrandId());
            /*  57 */
            if (brand != null) {
                /*  58 */
                tag.append(brand.getName());
            }
            /*  60 */
            tag.append(s.getName());
            /*  61 */
            tag.append(s.getAddress());
            /*  62 */
            if (s.getLandMarkId() != null) {
                /*  63 */
                LandMark lm = (LandMark) this.landMarkDao.get(s.getLandMarkId());
                /*  64 */
                tag.append(lm.getName());
            }
            /*  66 */
            if (s.getBusinessCircleId() != null) {
                /*  67 */
                BusinessCircle bc = (BusinessCircle) this.businessCircleDao.get(s
/*  68 */.getBusinessCircleId());
                /*  69 */
                if (bc != null) {
                    /*  70 */
                    tag.append(bc.getName());
                }
            }

            /*  74 */
            BrandCuisine brandCuisine = new BrandCuisine();
            /*  75 */
            brandCuisine.setBrandId(brand.getId());
            /*  76 */
            brandCuisine.setType(brand.getBusinessType());
            /*  77 */
            List<BrandCuisine> bcList = this.brandCuisineDao.getCuisineClassListByBrandId(brandCuisine);
            /*  78 */
            if (bcList != null && bcList.size() > 0) {
                /*  79 */
                for (BrandCuisine bc : bcList) {
                    /*  80 */
                    tag.append(bc.getCuisineClassName());
                    /*  81 */
                    tag.append(bc.getCuisineName());
                }
            }
            /*  84 */
            StoreTag st = this.storeTagDao.getStoreTagByStoreId(s.getId());
            /*  85 */
            if (st == null) {
                /*  86 */
                st = new StoreTag();
                /*  87 */
                st.setStoreId(s.getId());
                /*  88 */
                st.setTagName(tag.toString());
                /*  89 */
                this.storeTagDao.save(st);
                continue;
            }
            /*  91 */
            st.setHits(null);
            /*  92 */
            st.setTagName(tag.toString());

            /*  94 */
            updateStoreTag(st);
        }

        /*  97 */
        return 0;
    }

    @CacheEvict(value = {"dataCache"}, key = "(\"StoreTagManager.getStoreTagByStoreId\").concat(#storeTag.getStoreId())", condition = "#storeTag.getStoreId()>0L")
    public void updateStoreTag(StoreTag storeTag) {
        /* 102 */
        this.storeTagDao.update(storeTag);
    }

    @Cacheable(value = {"dataCache"}, key = "(\"StoreTagManager.getStoreTagByStoreId\").concat(#storeId)", condition = "#storeId>0L")
    public StoreTag getStoreTagByStoreId(Long storeId) {
        /* 107 */
        return this.storeTagDao.getStoreTagByStoreId(storeId);
    }

    public void setStoreDao(StoreDao storeDao) {
        /* 111 */
        this.storeDao = storeDao;
    }

    public void setBrandDao(BrandDao brandDao) {
        /* 115 */
        this.brandDao = brandDao;
    }

    public void setStoreTagDao(StoreTagDao storeTagDao) {
        /* 119 */
        this.storeTagDao = storeTagDao;
    }

    public void setLandMarkDao(LandMarkDao landMarkDao) {
        /* 123 */
        this.landMarkDao = landMarkDao;
    }

    public void setBusinessCircleDao(BusinessCircleDao businessCircleDao) {
        /* 127 */
        this.businessCircleDao = businessCircleDao;
    }

    public void setBrandCuisineDao(BrandCuisineDao brandCuisineDao) {
        /* 131 */
        this.brandCuisineDao = brandCuisineDao;
    }

    public void setCompanyDao(CompanyDao companyDao) {
        /* 135 */
        this.companyDao = companyDao;
    }
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\StoreTagManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */