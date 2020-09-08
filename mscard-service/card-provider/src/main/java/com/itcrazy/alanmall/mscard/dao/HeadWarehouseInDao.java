package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.HeadWarehouseInDto;
import com.itcrazy.alanmall.mscard.model.HeadWarehouseIn;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 总部入库DAO层接口
 *
 * @author luxf 2018-09-04
 */
@Component
public interface HeadWarehouseInDao extends BaseDao<HeadWarehouseIn, Long> {

	public List<HeadWarehouseIn> getPageHistory(HeadWarehouseInDto headWarehouseInDto);

	public List<HeadWarehouseIn> getPagePrepare(HeadWarehouseInDto headWarehouseInDto);

	public int getPreparePageTotal(HeadWarehouseInDto headWarehouseInDto);

	public int getHistoryPageTotal(HeadWarehouseInDto headWarehouseInDto);

	public String getMaxReciptNo(HeadWarehouseIn headWarehouseInDto);

	public int insertHeadWarehouseIn(HeadWarehouseIn headWarehouseIn);

	public int updateCardInformation(HeadWarehouseIn headWarehouseIn);

}
