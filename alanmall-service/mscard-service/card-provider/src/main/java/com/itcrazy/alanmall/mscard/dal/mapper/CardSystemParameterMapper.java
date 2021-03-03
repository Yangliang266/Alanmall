package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.CardSystemParameter;

public interface CardSystemParameterMapper {
    int deleteByPrimaryKey(Long companyId);

    int insert(CardSystemParameter record);

    int insertSelective(CardSystemParameter record);

    CardSystemParameter selectByPrimaryKey(Long companyId);

    int updateByPrimaryKeySelective(CardSystemParameter record);

    int updateByPrimaryKey(CardSystemParameter record);
}