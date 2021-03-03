package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.StoreWarehouseCardActivedDto;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import com.itcrazy.alanmall.mscard.model.StoreWarehouseIn;

import java.util.List;

/**
 * 卡激活接口
 * @author huangchunbo
 * 2018-09-17
 */
public interface StoreWareCardActivedManager {

	List<CardInformation> getPageList(StoreWarehouseCardActivedDto storeWarehouseCardActivedDto);

	Integer getPageTotal(StoreWarehouseCardActivedDto storeWarehouseCardActivedDto);

	 public void OperaHeadWarehouseOut(List<StoreWarehouseCardActivedDto> storeWarehouseCardActivedDtoList,
                                       StoreWarehouseIn storeWarehouseIn) throws Exception;;

}

