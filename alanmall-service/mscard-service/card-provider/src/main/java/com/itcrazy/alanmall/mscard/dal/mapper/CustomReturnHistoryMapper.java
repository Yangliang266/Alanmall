package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.CustomReturnHistory;

public interface CustomReturnHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CustomReturnHistory record);

    int insertSelective(CustomReturnHistory record);

    CustomReturnHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CustomReturnHistory record);

    int updateByPrimaryKeyWithBLOBs(CustomReturnHistory record);

    int updateByPrimaryKey(CustomReturnHistory record);
}