package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.StoreWarehouseInDto;
import com.itcrazy.alanmall.mscard.model.StoreWarehouseIn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 门店入库DAO层接口
 * @author yinxiang
 * 2018-09-04
 */

public interface StoreWarehouseInDao extends BaseDao<StoreWarehouseIn, Long> {

	public List<StoreWarehouseIn> getHistoryPageList(StoreWarehouseInDto storeWarehouseInDto);

	public Integer getHistoryPageTotal(StoreWarehouseInDto storeWarehouseInDto);

	public List<StoreWarehouseIn> getPerparePageList(StoreWarehouseInDto storeWarehouseInDto);

	public Integer getPerparePageTotal(StoreWarehouseInDto storeWarehouseInDto);

	// 更新卡状态门店入库状态
	public int updateCardInformation(StoreWarehouseIn storeWarehouseIn);

	// 添加到store_warehouse_in表中
	public int insertStoreWarehouseIn(StoreWarehouseIn storeWarehouseIn);

	public String getLastStoreInReceiptNo(@Param("companyId") Long companyId);
}

