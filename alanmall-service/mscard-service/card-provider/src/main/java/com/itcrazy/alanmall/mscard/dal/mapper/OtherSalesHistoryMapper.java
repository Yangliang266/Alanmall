package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.OtherSalesHistory;

public interface OtherSalesHistoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(OtherSalesHistory record);

    int insertSelective(OtherSalesHistory record);

    OtherSalesHistory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OtherSalesHistory record);

    int updateByPrimaryKey(OtherSalesHistory record);
}