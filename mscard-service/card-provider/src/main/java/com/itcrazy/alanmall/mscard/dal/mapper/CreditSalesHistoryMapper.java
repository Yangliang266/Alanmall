package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.CreditSalesHistory;

public interface CreditSalesHistoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(CreditSalesHistory record);

    int insertSelective(CreditSalesHistory record);

    CreditSalesHistory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CreditSalesHistory record);

    int updateByPrimaryKey(CreditSalesHistory record);
}