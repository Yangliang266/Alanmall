package com.itcrazy.alanmall.merchant.manager.impl;

import com.itcrazy.alanmall.common.framework.model.BaseModel;
import com.itcrazy.alanmall.merchant.dao.VersionChgDao;
import com.itcrazy.alanmall.merchant.dto.VersionChgDto;
import com.itcrazy.alanmall.merchant.manager.VersionChgManager;
import com.itcrazy.alanmall.merchant.model.VersionChg;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@org.apache.dubbo.config.annotation.Service
@Service("versionChgService")
public class VersionChgManagerImpl
        implements VersionChgManager {
    @Autowired
    private VersionChgDao versionChgDao;


    public List<VersionChg> getPageList(VersionChgDto versionChgDto) {
        /* 22 */
        List<VersionChg> versionChgList = this.versionChgDao.getPageList(versionChgDto);
        /* 23 */
        if (versionChgList != null && versionChgList.size() > 0) {

            /* 26 */
            return versionChgList;

        }
        /* 28 */
        return null;

    }


    public Integer getPageTotal(VersionChgDto versionChgDto) {
        /* 34 */
        return this.versionChgDao.getPageTotal(versionChgDto);

    }


    @Cacheable(value = {"dataCache"}, key = "(\"versionChgManager\").concat(#id)", condition = "#id>0L")
    public VersionChg getVersionChgById(Long id) {
        /* 41 */
        return (VersionChg) this.versionChgDao.get(id);

    }


    public VersionChg addVersionChg(VersionChg versionChg) {
        /* 47 */
        this.versionChgDao.save(versionChg);
        /* 48 */
        return versionChg;

    }


    @CacheEvict(value = {"dataCache"}, key = "(\"versionChgManager\").concat(#versionChg.getId())")
    public int updateVersionChg(VersionChg versionChg) {
        /* 55 */
        return this.versionChgDao.update(versionChg);

    }


    @CacheEvict(value = {"dataCache"}, key = "(\"versionChgManager\").concat(#versionChg.getId())")
    public int removeVersionChg(VersionChg versionChg) {
        /* 62 */
        return this.versionChgDao.remove(versionChg);

    }


    public VersionChgDao getVersionChgDao() {
        /* 72 */
        return this.versionChgDao;

    }


    public void setVersionChgDao(VersionChgDao versionChgDao) {
        /* 76 */
        this.versionChgDao = versionChgDao;

    }

}


/* Location:              C:\Users\xiaomi\Desktop\temp\merchant-service\BOOT-INF\classes\!\com\meishi\merchant\manager\impl\VersionChgManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */