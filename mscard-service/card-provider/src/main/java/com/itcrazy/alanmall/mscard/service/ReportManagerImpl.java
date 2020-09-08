package com.itcrazy.alanmall.mscard.service;


import com.itcrazy.alanmall.mscard.dataSource.DataSources;
import com.itcrazy.alanmall.mscard.dataSource.DynamicSwitchDataSource;
import com.itcrazy.alanmall.mscard.dto.Base.*;
import com.itcrazy.alanmall.mscard.manager.ReportManager;
import com.itcrazy.alanmall.mscard.model.*;
import com.itcrazy.alanmall.mscard.report.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
@Service
public class ReportManagerImpl implements ReportManager {
	@Autowired
	private ReportRechargeHistoryDao reportRechargeHistoryDao;
	@Autowired
	private ReportRechargeDetilDao reportRechargeDetilDao;
	@Autowired
	private ReportCenterInventoryDao reportCenterInventoryDao;
	@Autowired
	private ReportStorageSalesDao reportStorageSalesDao;
	@Autowired
	private ReportAccountPeriodDao reportAccountPeriodDao;
	@Autowired
	private ReportAccountTodayDao reportAccountTodayDao;
	@Autowired
	private ReportCreditAccountDao reportCreditAccountDao;
	@Autowired
	private ReportMemberActivePercentageDao reportMemberActivePercentageDao;

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	// 发卡中心-发卡充值统计表
	public List<RechargeHistory> getRechargeHistoryList(ReportRechargeHistoryDto reportRechargeHistoryDto) {
		return reportRechargeHistoryDao.getRechargeHistoryList(reportRechargeHistoryDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	// 发卡中心-发卡充值统计表分页
	public Integer getRechargeHistoryTotal(ReportRechargeHistoryDto reportRechargeHistoryDto) {
		return reportRechargeHistoryDao.getRechargeHistoryTotal(reportRechargeHistoryDto);
	}


	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	// 发卡中心-发卡充值统计表合计信息查询
	public RechargeHistory getTotalRechargeHistory(ReportRechargeHistoryDto reportRechargeHistoryDto) {
		return reportRechargeHistoryDao.getTotalRechargeHistory(reportRechargeHistoryDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	// 发卡/充值明细表
	public List<ReportRechangeDetil> getReportRechargeDetilList(ReportRechargeDetilDto reportRechargeDetilDto) {
		return reportRechargeDetilDao.getReportRechargeDetilList(reportRechargeDetilDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	// 发卡/充值明细表分页
	public Integer getReportRechargeDetilTotal(ReportRechargeDetilDto reportRechargeDetilDto) {
		return reportRechargeDetilDao.getReportRechargeDetilTotal(reportRechargeDetilDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	// 发卡/充值明细表合计信息查询
	public ReportRechangeDetil getTotalRechargeDetil(ReportRechargeDetilDto reportRechargeDetilDto) {
		return reportRechargeDetilDao.getTotalRechargeDetil(reportRechargeDetilDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	// 发卡中心-会员卡库存量统计表
	public List<ReportCenterInventory> getReportCenterInventoryList(ReportCenterInventoryDto reportCenterInventoryDto) {
		return reportCenterInventoryDao.getReportCenterInventoryList(reportCenterInventoryDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	// 卡消费明细表
	public List<ReportStorageSales> getReportStorageSalesList(ReportStorageSalesDto reportStorageSalesDto) {
		return reportStorageSalesDao.getReportStorageSalesList(reportStorageSalesDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	public Integer getReportStorageSalesTotal(ReportStorageSalesDto reportStorageSalesDto) {
		return reportStorageSalesDao.getReportStorageSalesTotal(reportStorageSalesDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	public Integer getReportCenterInventoryTotal(ReportCenterInventoryDto reportCenterInventoryDto) {
		return reportCenterInventoryDao.getReportCenterInventoryTotal(reportCenterInventoryDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	// 营收账款余额表（时段）实现
	public List<ReportAccountPeriod> getReportAccountPeriodList(ReportAccountPeriodDto reportAccountPeriodDto) {
		return reportAccountPeriodDao.getReportAccountPeriodList(reportAccountPeriodDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	// 营收账款余额表（时段）总记录数
	public Integer getReportAccountPeriodTotal(ReportAccountPeriodDto reportAccountPeriodDto) {
		return reportAccountPeriodDao.getReportAccountPeriodTotal(reportAccountPeriodDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	// 营收账款余额表（当日）实现
	public List<ReportAccountToday> getReportAccountTodayList(ReportAccountTodayDto reportAccountTodayDto) {
		return reportAccountTodayDao.getReportAccountTodayList(reportAccountTodayDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	// 营收账款余额表（当日）总记录数
	public Integer getReportAccountTodayTotal(ReportAccountTodayDto reportAccountTodayDto) {
		return reportAccountTodayDao.getReportAccountTodayTotal(reportAccountTodayDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	// 营收账款余额表（时段）合计
	public ReportAccountPeriod getReportAccountPeriodSum(ReportAccountPeriodDto reportAccountPeriodDto) {
		return reportAccountPeriodDao.getReportAccountPeriodSum(reportAccountPeriodDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	// 营收账款余额表（当日）合计
	public ReportAccountToday getReportAccountTodaySum(ReportAccountTodayDto reportAccountTodayDto) {
		return reportAccountTodayDao.getReportAccountTodaySum(reportAccountTodayDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	// 挂账／清账报表（汇总）
	public List<ReportCreditAccount> getReportCreditAccountList(ReportCreditAccountDto reportCreditAccountDto) {
		return reportCreditAccountDao.getReportCreditAccountList(reportCreditAccountDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	// 挂账／清账报表（汇总）分页
	public Integer getReportCreditAccountTotal(ReportCreditAccountDto reportCreditAccountDto) {
		return reportCreditAccountDao.getReportCreditAccountTotal(reportCreditAccountDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	// 挂账／清账报表（明细）
	public List<ReportCreditAccount> getReportCardCreditAccountList(ReportCreditAccountDto reportCreditAccountDto) {
		return reportCreditAccountDao.getReportCardCreditAccountList(reportCreditAccountDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	// 挂账／清账报表（明细）分页
	public Integer getReportCardCreditAccountTotal(ReportCreditAccountDto reportCreditAccountDto) {
		return reportCreditAccountDao.getReportCardCreditAccountTotal(reportCreditAccountDto);
	}
	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	// 会员卡库存量查询
	public ReportCenterInventory getTotalInfo(ReportCenterInventoryDto reportCenterInventoryDto) {
		return reportCenterInventoryDao.getTotalInfo(reportCenterInventoryDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	public ReportStorageSales getTotalReportStorageSales(ReportStorageSalesDto reportStorageSalesDto) {
		return reportStorageSalesDao.getTotalReportStorageSales(reportStorageSalesDto);
	}


	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	public ReportCreditAccount getTotalInfo(ReportCreditAccountDto reportCreditAccountDto) {
	//public List<ReportCreditAccount> getTotalInfo(ReportCreditAccountDto reportCreditAccountDto) {
		// 挂账／清账报表 (汇总)合计信息查询
		return reportCreditAccountDao.getTotalInfo(reportCreditAccountDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD_REPORT)
	public ReportCreditAccount getTotalCardInfo(ReportCreditAccountDto reportCreditAccountDto) {
	//public List<ReportCreditAccount> getTotalInfo(ReportCreditAccountDto reportCreditAccountDto) {
		// 挂账／清账报表 (明细)合计信息查询
		return reportCreditAccountDao.getTotalCardInfo(reportCreditAccountDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD)
	public List<ReportStorageSales> getReportStorageSalesList4Today(
			ReportStorageSalesDto reportStorageSalesDto) {
		return reportStorageSalesDao.getReportStorageSalesList(reportStorageSalesDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD)
	public Integer getReportStorageSalesTotal4Today(ReportStorageSalesDto reportStorageSalesDto) {
		return reportStorageSalesDao.getReportStorageSalesTotal(reportStorageSalesDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD)
	public ReportStorageSales getTotalReportStorageSales4Today(ReportStorageSalesDto reportStorageSalesDto) {
		return reportStorageSalesDao.getTotalReportStorageSales(reportStorageSalesDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD)
	public List<ReportRechangeDetil> getReportRechargeDetilList4Tody(ReportRechargeDetilDto reportRechargeDetilDto) {
		return reportRechargeDetilDao.getReportRechargeDetilList(reportRechargeDetilDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD)
	public Integer getReportRechargeDetilTotal4Today(ReportRechargeDetilDto reportRechargeDetilDto) {
		return reportRechargeDetilDao.getReportRechargeDetilTotal(reportRechargeDetilDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD)
	public ReportRechangeDetil getTotalRechargeDetil4Today(ReportRechargeDetilDto reportRechargeDetilDto) {
		return reportRechargeDetilDao.getTotalRechargeDetil(reportRechargeDetilDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD)
	public List<ReportMemberActivePercentage> getTotalCategory(ReportMemberActivePercentageDto reportMemberActivePercentageDto) {
		return reportMemberActivePercentageDao.getTotalCategory(reportMemberActivePercentageDto);
	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD)
	public List<ReportMemberActivePercentage> getMemberActivePercentageHistory(
			ReportMemberActivePercentageDto reportMemberActivePercentageDto) {
		return reportMemberActivePercentageDao.getMemberActivePercentageHistory(reportMemberActivePercentageDto);

	}

	@Override
	@DynamicSwitchDataSource(dataSource = DataSources.CARD)
	public Integer getMemberActivePercentageTotal(ReportMemberActivePercentageDto reportMemberActivePercentageDto) {
		return reportMemberActivePercentageDao.getMemberActivePercentageTotal(reportMemberActivePercentageDto);
	}

	/*@Override
	public List<ReportMemberActivePercentage> getMemberActivePercentageRechageHistory(
			ReportMemberActivePercentageDto reportMemberActivePercentageDto) {
		return reportMemberActivePercentageDao.getMemberActivePercentageRechageHistory(reportMemberActivePercentageDto);
	}

	@Override
	public List<ReportMemberActivePercentage> getMemberActivePercentageStorageHistory(
			ReportMemberActivePercentageDto reportMemberActivePercentageDto) {
		return reportMemberActivePercentageDao.getMemberActivePercentageStorageHistory(reportMemberActivePercentageDto);
	}*/
}



