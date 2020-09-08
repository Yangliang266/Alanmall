package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.RegisteredCard;
import org.apache.ibatis.annotations.Param;

public interface RegisteredCardMapper {
    int deleteByPrimaryKey(@Param("cardNo") String cardNo, @Param("companyId") Long companyId);

    int insert(RegisteredCard record);

    int insertSelective(RegisteredCard record);

    RegisteredCard selectByPrimaryKey(@Param("cardNo") String cardNo, @Param("companyId") Long companyId);

    int updateByPrimaryKeySelective(RegisteredCard record);

    int updateByPrimaryKey(RegisteredCard record);
}