package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.StoreWarehouseInDto;
import com.itcrazy.alanmall.mscard.model.StoreWarehouseIn;

import java.util.List;


/**
 * 门店入库接口
 * @author yinxiang
 * 2018-09-04
 */
public interface StoreWarehouseInManager {
	public List<StoreWarehouseIn> getHistoryPageList(StoreWarehouseInDto storeWarehouseInDto);

	public Integer getHistoryPageTotal(StoreWarehouseInDto storeWarehouseInDto);

	public List<StoreWarehouseIn> getPerparePageList(StoreWarehouseInDto storeWarehouseInDto);

	public Integer getPerparePageTotal(StoreWarehouseInDto storeWarehouseInDto);

	// 卡状态为门店入库状态进行更新
	public String OperaStoreWarehouseIn(List<StoreWarehouseInDto> storeWarehouseInDtoList, StoreWarehouseIn storeWarehouseIn) throws Exception;


}
