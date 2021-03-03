package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.CardChangeHistory;

public interface CardChangeHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CardChangeHistory record);

    int insertSelective(CardChangeHistory record);

    CardChangeHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CardChangeHistory record);

    int updateByPrimaryKey(CardChangeHistory record);
}