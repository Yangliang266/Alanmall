package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.ReportAccountPeriodDto;
import com.itcrazy.alanmall.mscard.model.ReportAccountPeriod;

import java.util.List;

public interface ReportAccountPeriodManager {
	// 营收账款余额表（时段）
	public List<ReportAccountPeriod> getReportAccountPeriodList(ReportAccountPeriodDto reportAccountPeriodDto);
}
