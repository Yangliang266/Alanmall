package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.HeadWarehouseOutDto;
import com.itcrazy.alanmall.mscard.model.HeadWarehouseOut;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 总部出库DAO层接口
 *
 * @author luxf 2018-09-04
 */
@Component
public interface HeadWarehouseOutDao extends BaseDao<HeadWarehouseOut, Long> {

	public List<HeadWarehouseOut> getPageHistory(HeadWarehouseOutDto headWarehouseOutDto);

	public List<HeadWarehouseOut> getPagePrepare(HeadWarehouseOutDto headWarehouseOutDto);

	public int getPreparePageTotal(HeadWarehouseOutDto headWarehouseOutDto);

	public int getHistoryPageTotal(HeadWarehouseOutDto headWarehouseOutDto);

	public String getMaxReciptNo(HeadWarehouseOut headWarehouseOutDto);

	public int insertHeadWarehouseOut(HeadWarehouseOut headWarehouseOut);

	public int updateCardInformation(HeadWarehouseOut headWarehouseOut);

}
