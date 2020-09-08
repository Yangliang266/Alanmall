package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.StoreWarehouseIn;
import org.apache.ibatis.annotations.Param;

public interface StoreWarehouseInMapper {
    int deleteByPrimaryKey(@Param("cardNo") String cardNo, @Param("receiptNo") String receiptNo, @Param("companyId") Long companyId);

    int insert(StoreWarehouseIn record);

    int insertSelective(StoreWarehouseIn record);

    StoreWarehouseIn selectByPrimaryKey(@Param("cardNo") String cardNo, @Param("receiptNo") String receiptNo, @Param("companyId") Long companyId);

    int updateByPrimaryKeySelective(StoreWarehouseIn record);

    int updateByPrimaryKey(StoreWarehouseIn record);
}