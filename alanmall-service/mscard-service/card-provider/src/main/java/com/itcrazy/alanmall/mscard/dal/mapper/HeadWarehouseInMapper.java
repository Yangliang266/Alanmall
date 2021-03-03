package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.HeadWarehouseIn;
import org.apache.ibatis.annotations.Param;

public interface HeadWarehouseInMapper {
    int deleteByPrimaryKey(@Param("cardNo") String cardNo, @Param("companyId") Long companyId);

    int insert(HeadWarehouseIn record);

    int insertSelective(HeadWarehouseIn record);

    HeadWarehouseIn selectByPrimaryKey(@Param("cardNo") String cardNo, @Param("companyId") Long companyId);

    int updateByPrimaryKeySelective(HeadWarehouseIn record);

    int updateByPrimaryKey(HeadWarehouseIn record);
}