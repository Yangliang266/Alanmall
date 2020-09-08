package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.PayMode;

public interface PayModeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PayMode record);

    int insertSelective(PayMode record);

    PayMode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PayMode record);

    int updateByPrimaryKey(PayMode record);
}