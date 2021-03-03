package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.StoreWarehouseOutDto;
import com.itcrazy.alanmall.mscard.model.StoreWarehouseOut;

import java.util.List;

/**
 * 门店入库接口
 * @author yinxiang
 * 2018-09-14
 */
public interface StoreWarehouseOutManager {
	// 门店出库
	public List<StoreWarehouseOut> getPageList(StoreWarehouseOutDto storeWarehouseOutDto);
	public Integer getPageTotal(StoreWarehouseOutDto storeWarehouseOutDto);

	// 门店调拨
	public List<StoreWarehouseOut> getPageOutList(StoreWarehouseOutDto storeWarehouseOutDto);
	public Integer getPageOutTotal(StoreWarehouseOutDto storeWarehouseOutDto);

	// 卡状态为门店入库状态进行更新
    public String OperaStoreWarehouseOut(List<StoreWarehouseOutDto> storeWarehouseOutDtoList, StoreWarehouseOut storeWarehouseOut)throws Exception;

    // 门店调拨入库
	public List<StoreWarehouseOut> getPagePrepareInList(StoreWarehouseOutDto storeWarehouseOutDto);
	public Integer getPagePrepareInTotal(StoreWarehouseOutDto storeWarehouseOutDto);

    // 调拨出库单（目的门店未入库） 历史记录分页
    public Integer getPageOutHistoryTotal(StoreWarehouseOutDto storeWarehouseOutDto);

    // 调拨出库单（目的门店未入库） 历史记录
   	public List<StoreWarehouseOut> getPageHistory(StoreWarehouseOutDto storeWarehouseOutDto);

    // 已入库的《门店入库单》分页
    public Integer getPageInHistoryTotal(StoreWarehouseOutDto storeWarehouseOutDto);

    // 已入库的《门店入库单》
   	public List<StoreWarehouseOut> getPageInHistory(StoreWarehouseOutDto storeWarehouseOutDto);
}
