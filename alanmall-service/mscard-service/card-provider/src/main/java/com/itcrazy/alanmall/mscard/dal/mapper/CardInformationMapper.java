package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.CardInformation;
import org.apache.ibatis.annotations.Param;

public interface CardInformationMapper {
    int deleteByPrimaryKey(@Param("cardNo") String cardNo, @Param("companyId") Long companyId);

    int insert(CardInformation record);

    int insertSelective(CardInformation record);

    CardInformation selectByPrimaryKey(@Param("cardNo") String cardNo, @Param("companyId") Long companyId);

    int updateByPrimaryKeySelective(CardInformation record);

    int updateByPrimaryKey(CardInformation record);
}