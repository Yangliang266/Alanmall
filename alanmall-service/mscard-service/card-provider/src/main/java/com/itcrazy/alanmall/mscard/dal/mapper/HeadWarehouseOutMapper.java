package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.HeadWarehouseOut;
import org.apache.ibatis.annotations.Param;

public interface HeadWarehouseOutMapper {
    int deleteByPrimaryKey(@Param("cardNo") String cardNo, @Param("companyId") Long companyId);

    int insert(HeadWarehouseOut record);

    int insertSelective(HeadWarehouseOut record);

    HeadWarehouseOut selectByPrimaryKey(@Param("cardNo") String cardNo, @Param("companyId") Long companyId);

    int updateByPrimaryKeySelective(HeadWarehouseOut record);

    int updateByPrimaryKey(HeadWarehouseOut record);
}