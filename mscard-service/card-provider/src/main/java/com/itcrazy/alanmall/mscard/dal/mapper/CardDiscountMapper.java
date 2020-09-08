package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.CardDiscount;

public interface CardDiscountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CardDiscount record);

    int insertSelective(CardDiscount record);

    CardDiscount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CardDiscount record);

    int updateByPrimaryKey(CardDiscount record);
}