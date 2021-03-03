package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.*;
import com.itcrazy.alanmall.mscard.model.*;

import java.util.List;

public interface ReportManager {
	// 发卡中心-发卡充值统计表列表
	public List<RechargeHistory> getRechargeHistoryList(ReportRechargeHistoryDto reportRechargeHistoryDto);
	// 发卡中心-发卡充值统计表分页
	public Integer getRechargeHistoryTotal(ReportRechargeHistoryDto reportRechargeHistoryDto);
	// 发卡中心-发卡充值统计表合计信息查询
	public RechargeHistory getTotalRechargeHistory(ReportRechargeHistoryDto reportRechargeHistoryDto);

	// 发卡-充值明细表列表
	public List<ReportRechangeDetil> getReportRechargeDetilList(ReportRechargeDetilDto reportRechargeDetilDto);
	public List<ReportRechangeDetil> getReportRechargeDetilList4Tody(ReportRechargeDetilDto reportRechargeDetilDto);
	// 发卡-充值明细表分页
	public Integer getReportRechargeDetilTotal(ReportRechargeDetilDto reportRechargeDetilDto);
	public Integer getReportRechargeDetilTotal4Today(ReportRechargeDetilDto reportRechargeDetilDto);
	// 发卡-充值明细表合计信息查询
	public ReportRechangeDetil getTotalRechargeDetil(ReportRechargeDetilDto reportRechargeDetilDto);
	public ReportRechangeDetil getTotalRechargeDetil4Today(ReportRechargeDetilDto reportRechargeDetilDto);

	// 发卡中心-会员卡库存量统计表
	public List<ReportCenterInventory> getReportCenterInventoryList(ReportCenterInventoryDto reportCenterInventoryDto);
	public Integer getReportCenterInventoryTotal(ReportCenterInventoryDto reportCenterInventoryDto);


	// 卡消费明细表
	public List<ReportStorageSales> getReportStorageSalesList(ReportStorageSalesDto reportStorageSalesDto);
	public Integer getReportStorageSalesTotal(ReportStorageSalesDto reportStorageSalesDto);
	public List<ReportStorageSales> getReportStorageSalesList4Today(ReportStorageSalesDto reportStorageSalesDto);
	public Integer getReportStorageSalesTotal4Today(ReportStorageSalesDto reportStorageSalesDto);

	// 营收账款余额表（时段）
	public List<ReportAccountPeriod> getReportAccountPeriodList(ReportAccountPeriodDto reportAccountPeriodDto);

	// 营收账款余额表（时段）总历史记录数
	public Integer getReportAccountPeriodTotal(ReportAccountPeriodDto reportAccountPeriodDto);

	// 营收账款余额表（当日）
	public List<ReportAccountToday> getReportAccountTodayList(ReportAccountTodayDto reportAccountTodayDto);

	// 营收账款余额表（当日）总历史记录数
	public Integer getReportAccountTodayTotal(ReportAccountTodayDto reportAccountTodayDto);

	// 营收账款余额表（时段）合计
	public ReportAccountPeriod getReportAccountPeriodSum(ReportAccountPeriodDto reportAccountPeriodDto);

	// 营收账款余额表（当日）合计
	public ReportAccountToday getReportAccountTodaySum(ReportAccountTodayDto reportAccountTodayDto);

	// 挂账／清账报表（汇总）
	public List<ReportCreditAccount> getReportCreditAccountList(ReportCreditAccountDto reportCreditAccountDto);

    // 挂账／清账报表（汇总）分页
	public Integer getReportCreditAccountTotal(ReportCreditAccountDto reportCreditAccountDto);

	// 挂账／清账报表 (明细)
	public List<ReportCreditAccount> getReportCardCreditAccountList(ReportCreditAccountDto reportCreditAccountDto);

	// 挂账／清账报表（明细）分页
	public Integer getReportCardCreditAccountTotal(ReportCreditAccountDto reportCreditAccountDto);

	// 会员卡库存量合计查询
	public ReportCenterInventory getTotalInfo(ReportCenterInventoryDto reportCenterInventoryDto);

	// 卡消费明细表合计查询
	public ReportStorageSales getTotalReportStorageSales(ReportStorageSalesDto reportStorageSalesDto);
	public ReportStorageSales getTotalReportStorageSales4Today(ReportStorageSalesDto reportStorageSalesDto);

	// 挂账／清账报表 (汇总)合计信息查询
	public ReportCreditAccount getTotalInfo(ReportCreditAccountDto reportCreditAccountDto);

	// 挂账／清账报表 (明细)合计信息查询
	public ReportCreditAccount getTotalCardInfo(ReportCreditAccountDto reportCreditAccountDto);

	// 会员卡售卡提成,获取卡类别
	public List<ReportMemberActivePercentage> getTotalCategory(ReportMemberActivePercentageDto reportMemberActivePercentageDto);

	// 会员卡售卡提成统计
	public List<ReportMemberActivePercentage> getMemberActivePercentageHistory(ReportMemberActivePercentageDto reportMemberActivePercentageDto);

	public Integer getMemberActivePercentageTotal(ReportMemberActivePercentageDto reportMemberActivePercentageDto);

}
