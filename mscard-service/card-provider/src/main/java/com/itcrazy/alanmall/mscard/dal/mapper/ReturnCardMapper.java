package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.ReturnCard;

public interface ReturnCardMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ReturnCard record);

    int insertSelective(ReturnCard record);

    ReturnCard selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ReturnCard record);

    int updateByPrimaryKeyWithBLOBs(ReturnCard record);

    int updateByPrimaryKey(ReturnCard record);
}