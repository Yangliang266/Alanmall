package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.HeadWarehouseInDto;
import com.itcrazy.alanmall.mscard.model.HeadWarehouseIn;

import java.util.List;

/**
 * 总部入库接口
 * @author luxf
 * 2018-09-04
 */
public interface HeadWarehouseInManager {
    // 历史记录
	public List<HeadWarehouseIn> getPageHistory(HeadWarehouseInDto headWarehouseInDto);

	// 制卡状态
	public List<HeadWarehouseIn> getPagePrepare(HeadWarehouseInDto headWarehouseInDto);

	// 最新入库单号取得
	public String getMaxReciptNo(HeadWarehouseIn headWarehouseInDto);

	// 总部入库（卡状态更新，入库记录）
	public String OperaHeadWarehouseIn(String[] cardNoList, Long userId, Long companyId) throws Exception;

    // 制卡状态数据条数
	public int getPreparePageTotal(HeadWarehouseInDto headWarehouseInDto);

	// 历史记录数据条数
	public int getHistoryPageTotal(HeadWarehouseInDto headWarehouseInDto);
}
