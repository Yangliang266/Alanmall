package com.itcrazy.alanmall.mscard.report;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.ReportStorageSalesDto;
import com.itcrazy.alanmall.mscard.model.CardBaseModel;
import com.itcrazy.alanmall.mscard.model.ReportStorageSales;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface ReportStorageSalesDao extends BaseDao<CardBaseModel, Long> {

	public List<ReportStorageSales> getReportStorageSalesList(ReportStorageSalesDto reportStorageSalesDto);
	public Integer getReportStorageSalesTotal(ReportStorageSalesDto reportStorageSalesDto);
	public ReportStorageSales getTotalReportStorageSales(ReportStorageSalesDto reportStorageSalesDto);

}
