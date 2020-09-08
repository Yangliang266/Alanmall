package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dataSource.DataSources;
import com.itcrazy.alanmall.mscard.dataSource.DynamicSwitchDataSource;
import com.itcrazy.alanmall.mscard.dto.Base.ReportAccountPeriodDto;
import com.itcrazy.alanmall.mscard.manager.ReportAccountPeriodManager;
import com.itcrazy.alanmall.mscard.model.ReportAccountPeriod;
import com.itcrazy.alanmall.mscard.report.ReportAccountPeriodDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Slf4j
@Service
public class ReportAccountPeriodManagerImpl implements ReportAccountPeriodManager{
	@Autowired
	private ReportAccountPeriodDao reportAccountPeriodDao;

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	// 营收账款余额表（时段）实现
	public List<ReportAccountPeriod> getReportAccountPeriodList(ReportAccountPeriodDto reportAccountPeriodDto) {
		return reportAccountPeriodDao.getReportAccountPeriodList(reportAccountPeriodDto);
	}

}
