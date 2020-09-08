package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.RechargHistory;

public interface RechargHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RechargHistory record);

    int insertSelective(RechargHistory record);

    RechargHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RechargHistory record);

    int updateByPrimaryKeyWithBLOBs(RechargHistory record);

    int updateByPrimaryKey(RechargHistory record);
}