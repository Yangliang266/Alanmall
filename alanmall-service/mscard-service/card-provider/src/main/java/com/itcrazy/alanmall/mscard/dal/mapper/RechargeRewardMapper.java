package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.RechargeReward;

public interface RechargeRewardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RechargeReward record);

    int insertSelective(RechargeReward record);

    RechargeReward selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RechargeReward record);

    int updateByPrimaryKeyWithBLOBs(RechargeReward record);

    int updateByPrimaryKey(RechargeReward record);
}