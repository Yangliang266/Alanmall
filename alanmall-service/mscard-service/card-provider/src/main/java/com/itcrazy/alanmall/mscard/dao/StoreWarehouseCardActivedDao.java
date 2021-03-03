package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.StoreWarehouseCardActivedDto;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import com.itcrazy.alanmall.mscard.model.StoreWarehouseIn;

import java.util.List;

/**
 * 门店卡激活Dao接口
 * @author huangchunbo
 * 2018-09-17
 */

public interface StoreWarehouseCardActivedDao extends BaseDao<CardInformation, Long> {

	public List<CardInformation> getPageList(StoreWarehouseCardActivedDto storeWarehouseCardActivedDto);

	public int getPageTotal(StoreWarehouseCardActivedDto storeWarehouseCardActivedDto);

	public int updateCardInformation(StoreWarehouseIn storeWarehouseIn);

	public void updateCardInformationBill(StoreWarehouseIn storeWarehouseIn);

}
