package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.JumpNumberRule;

public interface JumpNumberRuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JumpNumberRule record);

    int insertSelective(JumpNumberRule record);

    JumpNumberRule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JumpNumberRule record);

    int updateByPrimaryKey(JumpNumberRule record);
}