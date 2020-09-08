package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.StoreWarehouseOutDto;
import com.itcrazy.alanmall.mscard.model.StoreWarehouseOut;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 门店入库DAO层接口
 * @author yinxiang
 * 2018-09-04
 */

public interface StoreWarehouseOutDao extends BaseDao<StoreWarehouseOut, Long> {

	// 门店出库
	public List<StoreWarehouseOut> getPageList(StoreWarehouseOutDto storeWarehouseOutDto);
	public Integer getPageTotal(StoreWarehouseOutDto storeWarehouseOutDto);

	// 门店调拨
	public List<StoreWarehouseOut> getPageOutList(StoreWarehouseOutDto storeWarehouseOutDto);
	public Integer getPageOutTotal(StoreWarehouseOutDto storeWarehouseOutDto);

	// 门店调拨入库
	public List<StoreWarehouseOut> getPagePrepareInList(StoreWarehouseOutDto storeWarehouseOutDto);
	public Integer getPagePrepareInTotal(StoreWarehouseOutDto storeWarehouseOutDto);

	// 门店出库插入
	public int insertStoreWarehouseOut(StoreWarehouseOut storeWarehouseOut);

    // 门店出库单号
	public String getLastReceiptNo(@Param("companyId") Long companyId);

	// 更新卡状态门店出库状态
    public int updateCardInformation(StoreWarehouseOut storeWarehouseOut);

    // 调拨出库单（目的门店未入库）
    public Integer getPageOutHistoryTotal(StoreWarehouseOutDto storeWarehouseOutDto);
 	public List<StoreWarehouseOut> getPageInHistory(StoreWarehouseOutDto storeWarehouseOutDto);

	// 已入库的《门店入库单》
 	public Integer getPageInHistoryTotal(StoreWarehouseOutDto storeWarehouseOutDto);

 	// 门店出库
 	public List<StoreWarehouseOut> getPageHistory(StoreWarehouseOutDto storeWarehouseOutDto);
}



