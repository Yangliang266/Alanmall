package com.itcrazy.alanmall.mscard.dal.mapper;

import com.itcrazy.alanmall.mscard.dal.entity.StoreWarehouseOut;
import org.apache.ibatis.annotations.Param;

public interface StoreWarehouseOutMapper {
    int deleteByPrimaryKey(@Param("cardNo") String cardNo, @Param("receiptNo") String receiptNo, @Param("companyId") Long companyId);

    int insert(StoreWarehouseOut record);

    int insertSelective(StoreWarehouseOut record);

    StoreWarehouseOut selectByPrimaryKey(@Param("cardNo") String cardNo, @Param("receiptNo") String receiptNo, @Param("companyId") Long companyId);

    int updateByPrimaryKeySelective(StoreWarehouseOut record);

    int updateByPrimaryKeyWithBLOBs(StoreWarehouseOut record);

    int updateByPrimaryKey(StoreWarehouseOut record);
}