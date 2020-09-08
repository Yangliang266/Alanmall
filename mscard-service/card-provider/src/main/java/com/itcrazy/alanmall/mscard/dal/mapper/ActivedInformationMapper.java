package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.ActivedInformation;
import org.apache.ibatis.annotations.Param;

public interface ActivedInformationMapper {
    int deleteByPrimaryKey(@Param("cardNo") String cardNo, @Param("companyId") Long companyId);

    int insert(ActivedInformation record);

    int insertSelective(ActivedInformation record);

    ActivedInformation selectByPrimaryKey(@Param("cardNo") String cardNo, @Param("companyId") Long companyId);

    int updateByPrimaryKeySelective(ActivedInformation record);

    int updateByPrimaryKey(ActivedInformation record);
}