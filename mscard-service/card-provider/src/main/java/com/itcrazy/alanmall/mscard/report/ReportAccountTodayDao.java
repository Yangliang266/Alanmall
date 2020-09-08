package com.itcrazy.alanmall.mscard.report;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.ReportAccountTodayDto;
import com.itcrazy.alanmall.mscard.model.CardBaseModel;
import com.itcrazy.alanmall.mscard.model.ReportAccountToday;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReportAccountTodayDao extends BaseDao<CardBaseModel, Long> {
	// 营收账款余额表（当日）
	public List<ReportAccountToday> getReportAccountTodayList(ReportAccountTodayDto reportAccountTodayDto);

	// 总历史记录数
	public Integer getReportAccountTodayTotal(ReportAccountTodayDto reportAccountTodayDto);

	// 营收账款余额表（当日）合计
	public ReportAccountToday getReportAccountTodaySum(ReportAccountTodayDto reportAccountTodayDto);
}
