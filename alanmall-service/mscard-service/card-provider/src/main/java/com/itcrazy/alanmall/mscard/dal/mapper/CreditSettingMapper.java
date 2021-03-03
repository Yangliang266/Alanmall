package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.CreditSetting;

public interface CreditSettingMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CreditSetting record);

    int insertSelective(CreditSetting record);

    CreditSetting selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CreditSetting record);

    int updateByPrimaryKey(CreditSetting record);
}