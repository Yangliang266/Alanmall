package com.itcrazy.alanmall.merchant.manager.impl;

import com.itcrazy.alanmall.common.client.cache.DataCache;
import com.itcrazy.alanmall.common.client.util.CollectionUtils;
import com.itcrazy.alanmall.common.framework.model.BaseModel;
import com.itcrazy.alanmall.merchant.dao.StorePosConfigDao;
import com.itcrazy.alanmall.merchant.manager.StorePosConfigManager;
import com.itcrazy.alanmall.merchant.model.Store;
import com.itcrazy.alanmall.merchant.model.StorePosConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@Slf4j
@Service
public class StorePosConfigManagerImpl
        implements StorePosConfigManager {
    @Autowired
    private StorePosConfigDao storePosConfigDao;

    @Cacheable(value = {"dataCache"}, key = "(\"StorePosConfigManager.getListByStoreId\").concat(#storeId)", condition = "#storeId>0L")
    public List<StorePosConfig> getListByStoreId(Long storeId) {
        /*  29 */
        return this.storePosConfigDao.getListByStoreId(storeId);
    }


    @CacheEvict(value = {"dataCache"}, key = "(\"StorePosConfigManager.getListByStoreId\").concat(#store.getId())", condition = "#store.getId()>0L")
    public int updateStorePosConfig(Store store, List<StorePosConfig> spcList) {
        /*  42 */
        Map<String, Object> param = new HashMap<>();
        /*  43 */
        param.put("storeId", store.getId());
        /*  44 */
        param.put("updateId", store.getUpdateId());


        /*  47 */
        this.storePosConfigDao.deleteByStoreId(param);

        /*  49 */
        int cnt = 0;

        /*  51 */
        if (spcList != null && spcList.size() > 0) {
            /*  52 */
            for (StorePosConfig spc : spcList) {
                /*  53 */
                spc.setCompanyId(store.getCompanyId());
                /*  54 */
                spc.setBrandId(store.getBrandId());
                /*  55 */
                spc.setStoreId(store.getId());
                /*  56 */
                spc.setCreateId(store.getUpdateId());

                /*  58 */
                this.storePosConfigDao.save(spc);

                /*  60 */
                if (spc.getPosCode() != null && spc.getPosStoreCode() != null) {
                    /*  61 */
                    DataCache.remove("StorePosConfigManager.getConfigBySourceCode" + spc.getPosCode() + spc.getPosStoreCode());
                }
            }

            /*  65 */
            cnt = spcList.size();
        }

        /*  68 */
        return cnt;
    }


    @Cacheable(value = {"dataCache"}, key = "(\"StorePosConfigManager.getConfigBySourceCode\").concat(#posCode).concat(#posStoreCode)")
    public StorePosConfig getConfigBySourceCode(Integer posCode, String posStoreCode) {
        /*  80 */
        StorePosConfig spc = new StorePosConfig();
        /*  81 */
        spc.setPosCode(posCode);
        /*  82 */
        spc.setPosStoreCode(posStoreCode);
        /*  83 */
        List<StorePosConfig> list = this.storePosConfigDao.getConfigBySourceCode(spc);
        /*  84 */
        if (CollectionUtils.isNotEmpty(list) && list.size() == 1) {
            /*  85 */
            return list.get(0);
        }
        /*  87 */
        return null;
    }


    @CacheEvict(value = {"dataCache"}, key = "(\"StorePosConfigManager.getListByStoreId\").concat(#storeId)", condition = "#storeId>0L")
    public int deleteConfigByStoreId(Long storeId, Long updateId) {
        /* 100 */
        Map<String, Object> param = new HashMap<>();
        /* 101 */
        param.put("storeId", storeId);
        /* 102 */
        param.put("updateId", updateId);


        /* 105 */
        return this.storePosConfigDao.deleteByStoreId(param);
    }


    public void setStorePosConfigDao(StorePosConfigDao storePosConfigDao) {
        /* 110 */
        this.storePosConfigDao = storePosConfigDao;
    }


    public List<StorePosConfig> getStorePosConfig(StorePosConfig storePosConfig) {
        /* 115 */
        return this.storePosConfigDao.getConfigBySourceCode(storePosConfig);
    }
}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\StorePosConfigManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */