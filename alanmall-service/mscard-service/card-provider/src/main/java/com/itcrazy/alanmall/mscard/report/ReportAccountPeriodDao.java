package com.itcrazy.alanmall.mscard.report;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.ReportAccountPeriodDto;
import com.itcrazy.alanmall.mscard.model.CardBaseModel;
import com.itcrazy.alanmall.mscard.model.ReportAccountPeriod;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface ReportAccountPeriodDao extends BaseDao<CardBaseModel, Long> {
	// 营收账款余额表（时段）
	public List<ReportAccountPeriod> getReportAccountPeriodList(ReportAccountPeriodDto reportAccountPeriodDto);

	// 总历史记录数
	public Integer getReportAccountPeriodTotal(ReportAccountPeriodDto reportAccountPeriodDto);

	// 合计
	public ReportAccountPeriod getReportAccountPeriodSum(ReportAccountPeriodDto reportAccountPeriodDto);
}
