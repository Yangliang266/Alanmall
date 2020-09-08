package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.CardDiscarded;

public interface CardDiscardedMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CardDiscarded record);

    int insertSelective(CardDiscarded record);

    CardDiscarded selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CardDiscarded record);

    int updateByPrimaryKeyWithBLOBs(CardDiscarded record);

    int updateByPrimaryKey(CardDiscarded record);
}