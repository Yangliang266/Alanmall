package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.CardType;

public interface CardTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CardType record);

    int insertSelective(CardType record);

    CardType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CardType record);

    int updateByPrimaryKey(CardType record);
}