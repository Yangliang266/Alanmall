package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.CardCategory;

public interface CardCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CardCategory record);

    int insertSelective(CardCategory record);

    CardCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CardCategory record);

    int updateByPrimaryKeyWithBLOBs(CardCategory record);

    int updateByPrimaryKey(CardCategory record);
}