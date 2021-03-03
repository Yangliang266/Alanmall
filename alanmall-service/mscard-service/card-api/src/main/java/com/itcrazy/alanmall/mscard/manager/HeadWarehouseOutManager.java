package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.HeadWarehouseOutDto;
import com.itcrazy.alanmall.mscard.model.HeadWarehouseOut;

import java.util.List;

/**
 * 总部入库接口
 * @author luxf
 * 2018-09-04
 */
public interface HeadWarehouseOutManager {

	// 历史记录
    public List<HeadWarehouseOut> getPageHistory(HeadWarehouseOutDto HeadWarehouseOutDto);

    // 制卡状态
 	public List<HeadWarehouseOut> getPagePrepare(HeadWarehouseOutDto HeadWarehouseOutDto);

 	// 最新入库单号取得
 	public String getMaxReciptNo(HeadWarehouseOut HeadWarehouseOutDto);

	// 卡状态为制卡状态进行更新
	public String OperaHeadWarehouseOut(String[] cardNoList, HeadWarehouseOut headWarehouseOut) throws Exception;

	// 数据条数
	public int getPreparePageTotal(HeadWarehouseOutDto HeadWarehouseOutDto);

	public int getHistoryPageTotal(HeadWarehouseOutDto HeadWarehouseOutDto);
}
