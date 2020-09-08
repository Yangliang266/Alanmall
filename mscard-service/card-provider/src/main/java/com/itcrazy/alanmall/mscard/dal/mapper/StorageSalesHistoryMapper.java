package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.StorageSalesHistory;

public interface StorageSalesHistoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(StorageSalesHistory record);

    int insertSelective(StorageSalesHistory record);

    StorageSalesHistory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StorageSalesHistory record);

    int updateByPrimaryKeyWithBLOBs(StorageSalesHistory record);

    int updateByPrimaryKey(StorageSalesHistory record);
}