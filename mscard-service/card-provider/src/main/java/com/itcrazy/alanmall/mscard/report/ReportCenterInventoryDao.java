package com.itcrazy.alanmall.mscard.report;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.ReportCenterInventoryDto;
import com.itcrazy.alanmall.mscard.model.CardBaseModel;
import com.itcrazy.alanmall.mscard.model.ReportCenterInventory;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface ReportCenterInventoryDao extends BaseDao<CardBaseModel, Long> {

	public List<ReportCenterInventory> getReportCenterInventoryList(ReportCenterInventoryDto reportCenterInventoryDto);

	public Integer getReportCenterInventoryTotal(ReportCenterInventoryDto reportCenterInventoryDto);

	public ReportCenterInventory getTotalInfo(ReportCenterInventoryDto reportCenterInventoryDto);
}
