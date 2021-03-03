package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.*;
import com.itcrazy.alanmall.mscard.dto.Base.*;
import com.itcrazy.alanmall.mscard.manager.ReportManager;
import com.itcrazy.alanmall.mscard.model.*;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.ExcelUtil;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import com.itcrazy.alanmall.merchant.manager.StoreManager;
import com.itcrazy.alanmall.merchant.model.Store;
import com.itcrazy.alanmall.mscard.vo.card.*;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.model.User;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.*;


public class ReportAction extends InterfaceBaseAction{

	private static final long serialVersionUID = 4210031200936073021L;

	private ReportRechargeHistoryDto reportRechargeHistoryDto;
	private ReportRechargeDetilDto reportRechargeDetilDto;
	private ReportStorageSalesDto reportStorageSalesDto;
	private ReportCenterInventoryDto reportCenterInventoryDto;
	private ReportAccountPeriodDto reportAccountPeriodDto;
	private ReportAccountTodayDto reportAccountTodayDto;
	private ReportCreditAccountDto reportCreditAccountDto;
	private ReportMemberActivePercentageDto reportMemberActivePercentageDto;
	private String selectFlag;

	@Reference
	ReportManager reportManager;
	@Reference
	UserManager userManager;
	@Reference
	StoreManager storeManager;


	// 会员卡售卡提成统计表
	public String rptReportMemberActivePercentageHistory() {
		if (reportMemberActivePercentageDto == null) {
			reportMemberActivePercentageDto = new ReportMemberActivePercentageDto();
		}
		reportMemberActivePercentageDto.setCompanyId(user.getCompanyId());
		pageSet(reportMemberActivePercentageDto);
		if ("0".equals(selectFlag)) {
			// 显示所有卡类别
			List<ReportMemberActivePercentage> categoryList = reportManager.getTotalCategory(reportMemberActivePercentageDto);
			pageData.rows = categoryList;
		} else if ("1".equals(selectFlag)) {
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			List<ReportMemberActivePercentage> mapList = reportManager.getMemberActivePercentageHistory(reportMemberActivePercentageDto);
			List<ReportMemberActivePercentageVo> mapListVo = new ArrayList<ReportMemberActivePercentageVo>();
			// 遍历所有数据
			if (mapList != null && mapList.size() > 0) {
				for (ReportMemberActivePercentage rmap : mapList) {
					ReportMemberActivePercentageVo mapVo = new ReportMemberActivePercentageVo();
					mapVo.setCardNo(rmap.getCardNo());
					mapVo.setMotherCardNo(rmap.getMotherCardNo());
					mapVo.setName(rmap.getName());
					//mapVo.setStore(rmap.getStore());

					mapVo.setCreateTime(String.valueOf(format1.format(rmap.getCreateTime())));
					mapVo.setRecharge(String.valueOf(rmap.getRecharge()));
					mapVo.setReward(String.valueOf(rmap.getReward()));
					mapVo.setBill(String.valueOf(rmap.getBill()));
					mapVo.setBillReward(String.valueOf(rmap.getBillReward()));

					mapVo.setRechargeToday(String.valueOf(rmap.getRechargeBalance().subtract(rmap.getRechargeTotal().subtract(rmap.getBillTotal()))));
					mapVo.setRewardToday(String.valueOf(rmap.getRechargeReward().subtract(rmap.getRewardTotal().subtract(rmap.getRewardBillTotal()))));
					//mapVo.setRechargeBalance(String.valueOf(rmap.getRechargeBalance()));

					Store rechargeStore = storeManager.getStoreById(rmap.getStore());
					mapVo.setStore(rechargeStore != null ? rechargeStore.getName() : "卡中心");

					mapListVo.add(mapVo);


				}
			}
			pageData.rows = mapListVo;
			Integer t = reportManager.getMemberActivePercentageTotal(reportMemberActivePercentageDto);
			pageData.setTotal(t);
		}
		result.setSuccessInfo();
		return SUCCESS;
	}


	// 发卡中心-发卡充值统计表
	public String rptReportRechargeHistory() {
		if(reportRechargeHistoryDto == null) {
			result.setSuccessInfo();
			return SUCCESS;
		}
		pageSet(reportRechargeHistoryDto);
		reportRechargeHistoryDto.setCompanyId(user.getCompanyId());
		List<RechargeHistory> reList = reportManager.getRechargeHistoryList(reportRechargeHistoryDto);
		List<RechargeHistoryVo> reListVo = new ArrayList<RechargeHistoryVo>();
		if(reList != null && reList.size()>0){
			for( RechargeHistory rh : reList) {
				RechargeHistoryVo rhv = new RechargeHistoryVo();
					rhv.setCardNo(rh.getCardNo()+"");
					rhv.setCategoryName(rh.getCategoryName());
					rhv.setPayModeStr(rh.getPayModeStr());
					rhv.setRechargeAmount(rh.getRechargeAmount().toString());
					rhv.setRechargeTime(DateFormat.dateToString(rh.getRechargeTime()));
					rhv.setReward(rh.getReward().toString());

					Store rechargeStore = storeManager.getStoreById(rh.getRechargeStore());
					rhv.setRechargeStore(rechargeStore != null ? rechargeStore.getName() : "卡中心");

					User rechargePerson = userManager.getUserById(rh.getRechargePerson());
					rhv.setRechargePerson(rechargePerson != null ? rechargePerson.getRealName() : "");

					reListVo.add(rhv);
			}
		}

		Integer t = reportManager.getRechargeHistoryTotal(reportRechargeHistoryDto);
		pageData.setTotal(t.intValue());
		if(reportRechargeHistoryDto.getStart() + reportRechargeHistoryDto.getLimit() >= t.intValue()) {
			// 查询合计信息
			RechargeHistory totalInfo = reportManager.getTotalRechargeHistory(reportRechargeHistoryDto);
			if(totalInfo != null) {
				RechargeHistoryVo totalInfoVo = new RechargeHistoryVo();
				totalInfoVo.setCardNo("合计");
				totalInfoVo.setRechargeAmount(totalInfo.getRechargeAmount().toString());
				totalInfoVo.setReward(String.valueOf(totalInfo.getReward()));
				reListVo.add(totalInfoVo);
			}
		}
		pageData.rows = reListVo;
		result.setSuccessInfo();
		return SUCCESS;

	}


	/**
	 * 发卡/充值页面列表
	 */
	private List<ReportRechargeDetilVo> getPage(ReportRechargeDetilDto reportRechargeDetilDto){
		boolean limitToday = false;
		if (reportRechargeDetilDto.getChargeBeginTime() != null && !"".equals(reportRechargeDetilDto.getChargeBeginTime())) {
			String timeBegin = DateFormat.dateTimeToDateString(reportRechargeDetilDto.getChargeBeginTime());
			String timeNow = DateFormat.dateTimeToDateString(new Date());
			if(timeNow.endsWith(timeBegin)){
				reportRechargeDetilDto.setLimitToday(1);  //检索当天数据，从消费库检索
				limitToday = true;
			}
		}

		// TODO 暂时都从消费库走
		reportRechargeDetilDto.setLimitToday(1);  //检索当天数据，从消费库检索
		limitToday = true;

		pageSet(reportRechargeDetilDto);
		reportRechargeDetilDto.setCompanyId(user.getCompanyId());
		// 门店权限的情况
		if(user.getStoreId() != null){
			// 限制到自己的登录门店
			reportRechargeDetilDto.setRechargeStores(user.getStoreId().toString());
		}

		List<ReportRechangeDetil> rdList = null;
		if(limitToday){
			rdList = reportManager.getReportRechargeDetilList4Tody(reportRechargeDetilDto);
		} else {
			rdList = reportManager.getReportRechargeDetilList(reportRechargeDetilDto);
		}
		List<ReportRechargeDetilVo> rdListVo = new  ArrayList<ReportRechargeDetilVo>();
		if (rdList != null && rdList.size()>0) {
			for(ReportRechangeDetil rd : rdList) {
				ReportRechargeDetilVo rdVo = new  ReportRechargeDetilVo();
					rdVo.setCardNo(rd.getCardNo()+"");
					rdVo.setUserName(rd.getUserName());
					rdVo.setCategoryName(rd.getCategoryName());
					if(rd.getActionType().intValue() == 0) {
						rdVo.setActionType("充值");
					}else {
						rdVo.setActionType("撤销");
					}
					rdVo.setPayModeStr(rd.getPayModeStr());
					rdVo.setRechargeAmount(rd.getRechargeAmount().toString());
					rdVo.setReward(rd.getReward().toString());
					rdVo.setPublishTime(DateFormat.dateToString(rd.getPublishTime()));

					Store rechargeStore = storeManager.getStoreById(rd.getRechargeStore());
					rdVo.setRechargeStore(rechargeStore != null ? rechargeStore.getName() : "卡中心");

					Store publishStore = storeManager.getStoreById(rd.getPublishStore());
					rdVo.setPublishStore(publishStore != null ? publishStore.getName():"");

					User rechargePerson = userManager.getUserById(rd.getPublishId());
					rdVo.setPublishId(rechargePerson != null ? rechargePerson.getRealName() : "");
					rdListVo.add(rdVo);
			}

		}
		pageData.rows = rdListVo;
		Integer t = 0;
		if(limitToday){
			t = reportManager.getReportRechargeDetilTotal4Today(reportRechargeDetilDto);
		} else {
			t = reportManager.getReportRechargeDetilTotal(reportRechargeDetilDto);
		}
		if(reportRechargeDetilDto.getStart() + reportRechargeDetilDto.getLimit() >= t) {
			// 查询合计信息
			ReportRechangeDetil totalInfo = null;
			if(limitToday){
				totalInfo = reportManager.getTotalRechargeDetil4Today(reportRechargeDetilDto);
			} else {
				totalInfo = reportManager.getTotalRechargeDetil(reportRechargeDetilDto);
			}
			if(totalInfo != null) {
				ReportRechargeDetilVo totalInfoVo = new ReportRechargeDetilVo();
				totalInfoVo.setCardNo("合计");
				totalInfoVo.setUserName("");
				totalInfoVo.setCategoryName("");
				totalInfoVo.setPayModeStr("");
				totalInfoVo.setRechargeAmount(totalInfo.getRechargeAmount().toString());
				totalInfoVo.setReward(String.valueOf(totalInfo.getReward()));
				totalInfoVo.setPublishTime("");
				totalInfoVo.setRechargeStore("");
				totalInfoVo.setPublishStore("");
				totalInfoVo.setPublishId("");
				rdListVo.add(totalInfoVo);
			}
		}
		pageData.setTotal(t);
		result.setSuccessInfo();
		return rdListVo;
	}

	/**
	 * 页面充值记录数据
	 */
	private List<ReportRechargeDetilVo> RptReportRechargeDetilHistoryPrepare(ReportRechargeDetilDto reportRechargeDetilDto){
		reportRechargeDetilDto.setCompanyId(user.getCompanyId());
		reportRechargeDetilDto.setStart(0);
		reportRechargeDetilDto.setLimit(Integer.MAX_VALUE);

		List<ReportRechargeDetilVo> swivList = getPage(reportRechargeDetilDto);
		return swivList;

	}

	/**
	 * 导出发卡/充值记录数据
	 */
	@SuppressWarnings("rawtypes")
	public void rptReportRechargeDetilHistoryEexport(){
		List<ReportRechargeDetilVo> swivList = RptReportRechargeDetilHistoryPrepare(reportRechargeDetilDto);

	    String fileName = "发卡/充值明细数据" + DateFormat.dateToString(new Date());

	    //表头
	    LinkedHashMap<String,String> headerMaps = new LinkedHashMap<>();
	    headerMaps.put("卡号", "cardNo");
	    headerMaps.put("姓名", "userName");
	    headerMaps.put("卡类别", "categoryName");
	    headerMaps.put("类型", "actionType");
	    headerMaps.put("充值本金", "rechargeAmount");
	    headerMaps.put("充值奖励", "reward");
	    headerMaps.put("付款方式", "payModeStr");
	    headerMaps.put("发卡时间", "publishTime");
	    headerMaps.put("发卡操作员", "publishId");
	    headerMaps.put("发卡门店", "publishStore");
	    headerMaps.put("充值门店", "rechargeStore");

	    Iterator iter = headerMaps.entrySet().iterator();
		List<String> titleList = new ArrayList<>();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			titleList.add(key.toString());
		}

		try {
			List<Object[]> dataList =  ExcelUtil.formatCsvData(swivList, headerMaps);
			ExcelUtil.exportXlsx(fileName, null, titleList.toArray(new String[titleList.size()]), dataList,getRequest(), getResponse());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 发卡/充值明细表
	public String rptReportRechargeDetil() {
		if (reportRechargeDetilDto == null) {
			result.setSuccessInfo();
			return SUCCESS;
		}
		getPage(reportRechargeDetilDto);
		return SUCCESS;
	}


	/**
	 * 消费明细页面列表
	 */
	private List<ReportStorageSalesVo> getPages(ReportStorageSalesDto reportStorageSalesDto){
		boolean limitToday = false;
		if (reportStorageSalesDto.getTimeBegin() != null && !"".equals(reportStorageSalesDto.getTimeBegin())) {
			String timeBegin = DateFormat.dateTimeToDateString(reportStorageSalesDto.getTimeBegin());
			String timeNow = DateFormat.dateTimeToDateString(new Date());
			if(timeNow.endsWith(timeBegin)){
				reportStorageSalesDto.setLimitToday(1);  //检索当天数据，从消费库检索
				limitToday = true;
			}
		}

		// TODO 暂时都从消费库走
		reportStorageSalesDto.setLimitToday(1);  //检索当天数据，从消费库检索
		limitToday = true;

		reportStorageSalesDto.setCompanyId(user.getCompanyId());
		// 门店权限的情况
		if(user.getStoreId() != null){
			// 限制到自己的登录门店
			reportStorageSalesDto.setStores(user.getStoreId().toString());
		}
		pageSet(reportStorageSalesDto);

		List<ReportStorageSales> swiList = null;
		if(limitToday){
			swiList = reportManager.getReportStorageSalesList4Today(reportStorageSalesDto);
		} else {
			swiList = reportManager.getReportStorageSalesList(reportStorageSalesDto);
		}
		List<ReportStorageSalesVo> swivList = new ArrayList<ReportStorageSalesVo>();
		if (swiList != null && swiList.size() > 0) {

			for (ReportStorageSales s : swiList) {
				ReportStorageSalesVo sv = new ReportStorageSalesVo();
				sv.setCategoryName(s.getCategoryName());
			    sv.setCardNo(s.getCardNo());

			    sv.setMotherCardNo(s.getMotherCardNo());
			    sv.setMotherType(motherTypeInt2Str(s.getMotherType()));

			    sv.setSaleOrderId(s.getSaleOrderId());
			    sv.setConsumeTime(DateFormat.dateToString(s.getConsumeTime()));


			    sv.setActionType(s.getIsDeleted() == 0 ?  "消费" : "撤销");

			    sv.setBill(String.valueOf(s.getBill()));
			    sv.setReward(String.valueOf(s.getReward()));
			    sv.setCreditBill(String.valueOf(s.getCreditBill()));
			    sv.setRemarks(s.getRemarks()!= null ? s.getRemarks() : "");
			    Store store = storeManager.getStoreById(s.getStore());
			    sv.setStore(store != null ? store.getName() : "");
			    Store releaseStore = storeManager.getStoreById(s.getReleaseStore());
 				sv.setReleaseStore(releaseStore != null ? releaseStore.getName() : "");
				swivList.add(sv);
			}
		} else {
			ReportStorageSalesVo sv = new ReportStorageSalesVo();
			sv.setCardNo("合计");
			sv.setBill("0");
			sv.setReward("0");
			sv.setCreditBill("0");
			swivList.add(sv);
		}


		Integer t = 0;
		if(limitToday){
			t = reportManager.getReportStorageSalesTotal4Today(reportStorageSalesDto);
		} else {
			t = reportManager.getReportStorageSalesTotal(reportStorageSalesDto);
		}
		pageData.setTotal(t);
		if(reportStorageSalesDto.getStart() + reportStorageSalesDto.getLimit() >= t) {
			//查询合计信息
			ReportStorageSales totalrss = null;
			if(limitToday){
				totalrss = reportManager.getTotalReportStorageSales4Today(reportStorageSalesDto);
			} else {
				totalrss = reportManager.getTotalReportStorageSales(reportStorageSalesDto);
			}
			if(totalrss != null) {
				ReportStorageSalesVo totalInfoVo = new ReportStorageSalesVo();
				totalInfoVo.setCardNo("合计");
				totalInfoVo.setBill(String.valueOf(totalrss.getBill()));
				totalInfoVo.setReward(String.valueOf(totalrss.getReward()));
				totalInfoVo.setCreditBill(String.valueOf(totalrss.getCreditBill()));

				swivList.add(totalInfoVo);
			}
		}
		return swivList;
	}


	/**
	 * 页面消费明细数据
	 */
	private List<ReportStorageSalesVo> RptReportStorageSalesDetilHistoryPrepare(ReportStorageSalesDto reportStorageSalesDto){
		reportStorageSalesDto.setCompanyId(user.getCompanyId());
		reportStorageSalesDto.setStart(0);
		reportStorageSalesDto.setLimit(Integer.MAX_VALUE);

		List<ReportStorageSalesVo> swivList = getPages(reportStorageSalesDto);
		return swivList;
	}

	/**
	 * 导出消费明细数据
	 */
	@SuppressWarnings("rawtypes")
	public void rptReportStorageSalesDetilHistoryEexport(){
		List<ReportStorageSalesVo> swivList = RptReportStorageSalesDetilHistoryPrepare(reportStorageSalesDto);

	    String fileName = "卡消费明细数据" + DateFormat.dateToString(new Date());

	    //表头
	    LinkedHashMap<String,String> headerMaps = new LinkedHashMap<>();
	    headerMaps.put("订单号", "saleOrderId");
	    headerMaps.put("卡号", "cardNo");
	    headerMaps.put("母卡卡号", "motherCardNo");
	    headerMaps.put("母子卡类别", "motherType");
	    headerMaps.put("卡类别", "categoryName");
	    headerMaps.put("消费门店", "store");
	    headerMaps.put("发卡门店", "releaseStore");
	    headerMaps.put("消费时间", "consumeTime");
	    headerMaps.put("类型", "actionType");
	    headerMaps.put("充值本金消费", "bill");
	    headerMaps.put("奖励消费", "reward");
	    headerMaps.put("挂账消费", "creditBill");
	    headerMaps.put("备注", "remarks");

	    Iterator iter = headerMaps.entrySet().iterator();
		List<String> titleList = new ArrayList<>();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			titleList.add(key.toString());
		}

		try {
			List<Object[]> dataList =  ExcelUtil.formatCsvData(swivList, headerMaps);
			ExcelUtil.exportXlsx(fileName, null, titleList.toArray(new String[titleList.size()]), dataList,getRequest(), getResponse());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// 卡消费明细表
	public String rptReportStorageSales() {
		if (reportStorageSalesDto == null) {
			result.setSuccessInfo();
			return SUCCESS;
		}
		pageData.rows = getPages(reportStorageSalesDto);
		result.setSuccessInfo();
		return SUCCESS;
	}

	// 发卡中心-会员卡库存统计表
	public String rptReportCenterInventoryList() {

		if (reportCenterInventoryDto == null) {
			result.setSuccessInfo();
			return SUCCESS;
		}

		pageSet(reportCenterInventoryDto);

		reportCenterInventoryDto.setCompanyId(user.getCompanyId());

		List<ReportCenterInventory> swiList = reportManager.getReportCenterInventoryList(reportCenterInventoryDto);

		List<ReportCenterInventoryVo> swivList = new ArrayList<ReportCenterInventoryVo>();

		if (swiList != null && swiList.size() > 0) {

			for (ReportCenterInventory s : swiList) {
				ReportCenterInventoryVo sv = new ReportCenterInventoryVo();
				sv.setCategoryName(s.getCategoryName());
				sv.setCardIn(s.getCardIn());
				sv.setCardOut(s.getCardOut());
				sv.setOpeningInventory(s.getOpeningInventory());
				sv.setSaleCard(s.getSaleCard());
				sv.setCurrentBalance(s.getOpeningInventory() - s.getSaleCard() - s.getCardOut() + s.getCardIn());
                Store store = storeManager.getStoreById(s.getStore());
 				sv.setStore(store != null ? store.getName() : "");

				swivList.add(sv);
			}

		} else {
			ReportCenterInventoryVo sv = new ReportCenterInventoryVo();
			sv.setStore("合计");
			sv.setCardIn(0);
			sv.setCardOut(0);
			sv.setOpeningInventory(0);
			sv.setSaleCard(0);
			sv.setCurrentBalance(0);
			swivList.add(sv);
		}


		Integer t = reportManager.getReportCenterInventoryTotal(reportCenterInventoryDto);
		pageData.setTotal(t);

		if(reportCenterInventoryDto.getStart() + reportCenterInventoryDto.getLimit() >= t) {
			//查询合计信息
			ReportCenterInventory totalInfo = reportManager.getTotalInfo(reportCenterInventoryDto);
			if(totalInfo != null) {
				ReportCenterInventoryVo totalInfoVo = new ReportCenterInventoryVo();
				totalInfoVo.setStore("合计");
				totalInfoVo.setOpeningInventory(totalInfo.getOpeningInventory());
				totalInfoVo.setSaleCard(totalInfo.getSaleCard());
				totalInfoVo.setCardOut(totalInfo.getCardOut());
				totalInfoVo.setCardIn(totalInfo.getCardIn());
				totalInfoVo.setCurrentBalance(totalInfo.getOpeningInventory()-totalInfo.getSaleCard()-totalInfo.getCardOut()+totalInfo.getCardIn());

				swivList.add(totalInfoVo);
			}
		}
		pageData.rows = swivList;
		result.setSuccessInfo();
		return SUCCESS;
	}

	// 获取营收账款余额表（时段）历史数据
	private List<ReportAccountPeriodVo> getpagePeriod(ReportAccountPeriodDto reportAccountPeriodDto) {
		List<ReportAccountPeriod> reportAccountPeriodList = reportManager.getReportAccountPeriodList(reportAccountPeriodDto);
		List<ReportAccountPeriodVo> reportAccountPeriodVoList = new ArrayList<ReportAccountPeriodVo>();

		if (reportAccountPeriodList != null && reportAccountPeriodList.size() > 0) {
			for (ReportAccountPeriod rap : reportAccountPeriodList) {
				ReportAccountPeriodVo rav = new ReportAccountPeriodVo();
				// 卡号
				rav.setCardNo(rap.getCardNo());
				// 客户名
				if(rap.getUserName() == null) {
					rav.setUserName("");
				} else {
					rav.setUserName(rap.getUserName());
				}
				// 卡状态
				rav.setStatus(KeyValueConvert.getCardStatusValue(rap.getStatus()));
				// 卡类别
				rav.setName(rap.getName());
				// 日出余额（本金）
				rav.setBeforeBalanceSum(String.valueOf(rap.getBeforeBalanceSum()));
				// 日出余额（奖励）
				rav.setBeforeRewardSum(String.valueOf(rap.getBeforeRewardSum()));
				// 充值金额（本金）
				rav.setRechargeBalance(String.valueOf(rap.getRechargeBalance()));
				// 充值金额（奖励）
				rav.setRewardBalance(String.valueOf(rap.getRewardBalance()));
				// 消费金额（本金）
				rav.setStorageBill(String.valueOf(rap.getStorageBill()));
				// 消费金额（奖励）
				rav.setStorageReward(String.valueOf(rap.getStorageReward()));
				// 卡内结余（本金）
				rav.setSurplusBalance(String.valueOf(rap.getSurplusBalance()));
				// 卡内结余（奖励）
				rav.setSurplusReward(String.valueOf(rap.getSurplusReward()));

				reportAccountPeriodVoList.add(rav);
			}
		}
		Integer iTotalRows = reportManager.getReportAccountPeriodTotal(reportAccountPeriodDto);
		// 合计
		if (reportAccountPeriodDto.getStart() + reportAccountPeriodDto.getLimit() >= iTotalRows) {
			ReportAccountPeriod reportAccountPeriodSum = reportManager.getReportAccountPeriodSum(reportAccountPeriodDto);
			ReportAccountPeriodVo ravCount = new ReportAccountPeriodVo();
			ravCount.setCardNo("合计");
			ravCount.setStatus("");
			ravCount.setUserName("");
			ravCount.setName("");
			ravCount.setBeforeBalanceSum(String.valueOf(reportAccountPeriodSum.getBeforeBalanceSum()));
			ravCount.setBeforeRewardSum(String.valueOf(reportAccountPeriodSum.getBeforeRewardSum()));
			ravCount.setRechargeBalance(String.valueOf(reportAccountPeriodSum.getRechargeBalance()));
			ravCount.setRewardBalance(String.valueOf(reportAccountPeriodSum.getRewardBalance()));
			ravCount.setStorageBill(String.valueOf(reportAccountPeriodSum.getStorageBill()));
			ravCount.setStorageReward(String.valueOf(reportAccountPeriodSum.getStorageReward()));
			ravCount.setSurplusBalance(String.valueOf(reportAccountPeriodSum.getSurplusBalance()));
			ravCount.setSurplusReward(String.valueOf(reportAccountPeriodSum.getSurplusReward()));

			reportAccountPeriodVoList.add(ravCount);
		}
		return reportAccountPeriodVoList;
	}


	// 获取营收账款余额表（当日）历史数据
	private List<ReportAccountTodayVo> getpageToday(ReportAccountTodayDto reportAccountTodayDto) {
		List<ReportAccountToday> reportAccountTodayList = reportManager.getReportAccountTodayList(reportAccountTodayDto);
		List<ReportAccountTodayVo> reportAccountTodayVoList = new ArrayList<ReportAccountTodayVo>();
		if (reportAccountTodayList != null && reportAccountTodayList.size() > 0) {
			for (ReportAccountToday rat : reportAccountTodayList) {
				ReportAccountTodayVo rav = new ReportAccountTodayVo();
				// 卡号
				rav.setCardNo(rat.getCardNo());
				// 客户名
				if(rat.getUserName() == null) {
					rav.setUserName("");
				} else {
					rav.setUserName(rat.getUserName());
				}
				// 卡状态
				rav.setStatus(KeyValueConvert.getCardStatusValue(rat.getStatus()));
				// 卡类别
				rav.setName(rat.getName());
				// 上日余额（本金）
				rav.setYesterdayBalance(String.valueOf(rat.getYesterdayBalance()));
				// 上日余额（奖励）
				rav.setYesterdayReward(String.valueOf(rat.getYesterdayReward()));
				// 借方合计（本金）
				rav.setStorageBill(String.valueOf(rat.getStorageBill()));
				// 借方合计（奖励）
				rav.setStorageReward(String.valueOf(rat.getStorageReward()));
				//贷方合计（本金）
				rav.setLoanRecharge(String.valueOf(rat.getLoanRecharge()));
				// 贷方合计（奖励）
				rav.setLoanReward(String.valueOf(rat.getLoanReward()));
				// 本日余额（本金）
				rav.setSurplusBalance(String.valueOf(rat.getSurplusBalance()));
				// 本日余额（奖励）
				rav.setSurplusReward(String.valueOf(rat.getSurplusReward()));

				reportAccountTodayVoList.add(rav);
			}
		}

		Integer iTotalRows = reportManager.getReportAccountTodayTotal(reportAccountTodayDto);
		// 合计
		if (reportAccountTodayDto.getStart() + reportAccountTodayDto.getLimit() >= iTotalRows) {
			ReportAccountToday reportAccountTodaySum = reportManager.getReportAccountTodaySum(reportAccountTodayDto);
			ReportAccountTodayVo ravCount = new ReportAccountTodayVo();
			ravCount.setCardNo("合计");
			ravCount.setStatus("");
			ravCount.setUserName("");
			ravCount.setName("");

			ravCount.setYesterdayBalance(String.valueOf(reportAccountTodaySum.getYesterdayBalance()));
			ravCount.setYesterdayReward(String.valueOf(reportAccountTodaySum.getYesterdayReward()));
			ravCount.setLoanRecharge(String.valueOf(reportAccountTodaySum.getLoanRecharge()));
			ravCount.setLoanReward(String.valueOf(reportAccountTodaySum.getLoanReward()));
			ravCount.setStorageBill(String.valueOf(reportAccountTodaySum.getStorageBill()));
			ravCount.setStorageReward(String.valueOf(reportAccountTodaySum.getStorageReward()));
			ravCount.setSurplusBalance(String.valueOf(reportAccountTodaySum.getSurplusBalance()));
			ravCount.setSurplusReward(String.valueOf(reportAccountTodaySum.getSurplusReward()));

			reportAccountTodayVoList.add(ravCount);
		}
		return reportAccountTodayVoList;
	}


	// 营收账款余额表（时段与当日）
	public String rptReportAccountPeriodAndTodayHistory() {
		if ("0".equals(selectFlag)) {
			if (reportAccountPeriodDto == null) {
				reportAccountPeriodDto = new ReportAccountPeriodDto();
			}
			pageSet(reportAccountPeriodDto);
			reportAccountPeriodDto.setCompanyId(user.getCompanyId());
			reportAccountPeriodDto.setIsDeleted(0);
			Integer iTotalRows = reportManager.getReportAccountPeriodTotal(reportAccountPeriodDto);
			pageData.rows = getpagePeriod(reportAccountPeriodDto);
			pageData.setTotal(iTotalRows);
			result.setSuccessInfo();
			return SUCCESS;
		} else {
			if (reportAccountTodayDto == null) {
				reportAccountTodayDto = new ReportAccountTodayDto();
			}
			pageSet(reportAccountTodayDto);
			reportAccountTodayDto.setCompanyId(user.getCompanyId());
			reportAccountTodayDto.setIsDeleted(0);
			pageData.rows = getpageToday(reportAccountTodayDto);
			Integer iTotalRows = reportManager.getReportAccountTodayTotal(reportAccountTodayDto);
			pageData.setTotal(iTotalRows);
			result.setSuccessInfo();
			return SUCCESS;
		}
	}

	// 初始化页面不显示
	public String rptReportAccountPeriodAndTodayList() {
		return null;
	}


	// 挂账／清账报表（汇总）
	private List<ReportCreditAccountVo> getpageToday(ReportCreditAccountDto reportCreditAccountDto) {
		List<ReportCreditAccount> reportCreditAccountList = reportManager.getReportCreditAccountList(reportCreditAccountDto);
		List<ReportCreditAccountVo> reportCreditAccountVoList = new ArrayList<ReportCreditAccountVo>();

		if (reportCreditAccountList != null && reportCreditAccountList.size() > 0) {
			for (ReportCreditAccount rap : reportCreditAccountList) {
				ReportCreditAccountVo rav = new ReportCreditAccountVo();
				// 卡号
				rav.setCardNo(rap.getCardNo());
				// 客户名
				if(rap.getUserName() == null) {
					rav.setUserName("");
				} else {
					rav.setUserName(rap.getUserName());
				}
				// 卡状态
				rav.setStatus(KeyValueConvert.getCardStatusValue(rap.getStatus()));
				// 卡类别
				rav.setName(rap.getName());
				// 总挂账笔数
				if(rap.getCreditNum() == null) {
					rav.setCreditNum("0");
				} else {
					rav.setCreditNum(String.valueOf(rap.getCreditNum()));
				}
				// 总挂账金额
				if(rap.getCreditBill() == null) {
					rav.setCreditBill("0");
				} else {
					rav.setCreditBill(String.valueOf(rap.getCreditBill()));
				}
				// 全清账笔数
				if(rap.getAllClearNum() == null) {
					rav.setAllClearNum("0");
				} else {
					rav.setAllClearNum(String.valueOf(rap.getAllClearNum()));
				}
				// 全清账金额
				if(rap.getAllClearBill() == null) {
					rav.setAllClearBill("0");
				} else {
					rav.setAllClearBill(String.valueOf(rap.getAllClearBill()));
				}
				// 部分清账笔数
				if(rap.getPartClearNum() == null) {
					rav.setPartClearNum("0");
				} else {
					rav.setPartClearNum(String.valueOf(rap.getPartClearNum()));
				}
				// 部分清账金额
				if(rap.getPartClearBill() == null) {
					rav.setPartClearBill("0");
				} else {
					rav.setPartClearBill(String.valueOf(rap.getPartClearBill()));
				}
				// 未清账笔数（包括全清、部分清账）
				if(rap.getNotClearNum() == null) {
					rav.setNotClearNum("0");
				} else {
					rav.setNotClearNum(String.valueOf(rap.getNotClearNum()));
				}
				// 未清账金额（包括全清、部分清账）
				if(rap.getNotClearBill() == null) {
					rav.setNotClearBill("0");
				} else {
					rav.setNotClearBill(String.valueOf(rap.getNotClearBill()));
				}

				reportCreditAccountVoList.add(rav);
			}
		}
		Integer iTotalRows = reportManager.getReportCreditAccountTotal(reportCreditAccountDto);
		if(reportCreditAccountDto.getStart() + reportCreditAccountDto.getLimit() >= iTotalRows) {
			// 查询合计信息
			ReportCreditAccount totalInfo = reportManager.getTotalInfo(reportCreditAccountDto);
			if(totalInfo != null) {
				ReportCreditAccountVo totalInfoVo = new ReportCreditAccountVo();
				totalInfoVo.setCardNo("合计");
				totalInfoVo.setCreditNum(String.valueOf(totalInfo.getCreditNum()));
				totalInfoVo.setCreditBill(String.valueOf(totalInfo.getCreditBill()));
				totalInfoVo.setAllClearNum(String.valueOf(totalInfo.getAllClearNum()));
				totalInfoVo.setAllClearBill(String.valueOf(totalInfo.getAllClearBill()));
				totalInfoVo.setPartClearNum(String.valueOf(totalInfo.getPartClearNum()));
				totalInfoVo.setPartClearBill(String.valueOf(totalInfo.getPartClearBill()));
				totalInfoVo.setNotClearNum(String.valueOf(totalInfo.getNotClearNum()));
				totalInfoVo.setNotClearBill(String.valueOf(totalInfo.getNotClearBill()));

				reportCreditAccountVoList.add(totalInfoVo);
			}
		}
		return reportCreditAccountVoList;
	}
	// 挂账／清账报表（汇总）
	public String rptReportCreditAccount() {
			if (reportCreditAccountDto == null) {
				reportCreditAccountDto = new ReportCreditAccountDto();
			}
			pageSet(reportCreditAccountDto);
			reportCreditAccountDto.setCompanyId(user.getCompanyId());
			pageData.rows = getpageToday(reportCreditAccountDto);
			Integer iTotalRows = reportManager.getReportCreditAccountTotal(reportCreditAccountDto);
			pageData.setTotal(iTotalRows);
			result.setSuccessInfo();
			return SUCCESS;
	}

    // 挂账／清账报表（明细）
	private List<ReportCreditAccountVo> getCardpageToday(ReportCreditAccountDto reportCreditAccountDto) {
		List<ReportCreditAccount> reportCardCreditAccountList = reportManager.getReportCardCreditAccountList(reportCreditAccountDto);
		List<ReportCreditAccountVo> reportCardCreditAccountVoList = new ArrayList<ReportCreditAccountVo>();

		if (reportCardCreditAccountList != null && reportCardCreditAccountList.size() > 0) {
			for (ReportCreditAccount rap : reportCardCreditAccountList) {
				ReportCreditAccountVo rav = new ReportCreditAccountVo();
				// 卡号
				rav.setCardNo(rap.getCardNo());
				// 客户名
				if(rap.getUserName() == null) {
					rav.setUserName("");
				} else {
					rav.setUserName(rap.getUserName());
				}
				// 卡状态
				rav.setStatus(KeyValueConvert.getCardStatusValue(rap.getStatus()));
				// 卡类别
				rav.setName(rap.getName());
				// 账单编号
				rav.setIdCard(rap.getIdCard());
				// 消费时间
				rav.setConsumeTime(DateFormat.dateToString(rap.getConsumeTime()));
				// 账单总金额
				if(rap.getBill() == null) {
					rav.setAllClearNum("0");
				} else {
					rav.setBill(String.valueOf(rap.getBill()));
				}
				// 挂账金额
				if(rap.getCreditCardBill() == null) {
					rav.setCreditCardBill("0");
				} else {
					rav.setCreditCardBill(String.valueOf(rap.getCreditCardBill()));
				}
				// 已清账金额
				if(rap.getClearBill() == null) {
					rav.setClearBill("0");
				} else {
					rav.setClearBill(String.valueOf(rap.getClearBill()));
				}
				// 未清账金额
				if(rap.getCredit() == null) {
					rav.setCredit("0");
				} else {
					rav.setCredit(String.valueOf(rap.getCredit()));
				}
				reportCardCreditAccountVoList.add(rav);
			}
		}
		Integer iTotalCardRows = reportManager.getReportCardCreditAccountTotal(reportCreditAccountDto);
		if(reportCreditAccountDto.getStart() + reportCreditAccountDto.getLimit() >= iTotalCardRows) {
			// 查询合计信息
			ReportCreditAccount totalCardInfo = reportManager.getTotalCardInfo(reportCreditAccountDto);
			if(totalCardInfo != null) {
				ReportCreditAccountVo totalCardInfoVo = new ReportCreditAccountVo();
				totalCardInfoVo.setCardNo("合计");
				totalCardInfoVo.setBill(String.valueOf(totalCardInfo.getBill()));
				totalCardInfoVo.setCreditCardBill(String.valueOf(totalCardInfo.getCreditCardBill()));
				totalCardInfoVo.setClearBill(String.valueOf(totalCardInfo.getClearBill()));
				totalCardInfoVo.setCredit(String.valueOf(totalCardInfo.getCredit()));
				reportCardCreditAccountVoList.add(totalCardInfoVo);
			}
		}
		return reportCardCreditAccountVoList;
	}

	// 挂账／清账报表（明细）
	public String rptReportCardCreditAccount() {
			if (reportCreditAccountDto == null) {
				reportCreditAccountDto = new ReportCreditAccountDto();
			}
			pageSet(reportCreditAccountDto);
			reportCreditAccountDto.setCompanyId(user.getCompanyId());
			pageData.rows = getCardpageToday(reportCreditAccountDto);
			Integer iTotalCardRows = reportManager.getReportCardCreditAccountTotal(reportCreditAccountDto);
			pageData.setTotal(iTotalCardRows);
			result.setSuccessInfo();
			return SUCCESS;
	}




	public ReportRechargeHistoryDto getReportRechargeHistoryDto() {
		return reportRechargeHistoryDto;
	}

	public void setReportRechargeHistoryDto(ReportRechargeHistoryDto reportRechargeHistoryDto) {
		this.reportRechargeHistoryDto = reportRechargeHistoryDto;
	}

	public ReportRechargeDetilDto getReportRechargeDetilDto() {
		return reportRechargeDetilDto;
	}

	public void setReportRechargeDetilDto(ReportRechargeDetilDto reportRechargeDetilDto) {
		this.reportRechargeDetilDto = reportRechargeDetilDto;
	}

	public ReportStorageSalesDto getReportStorageSalesDto() {
		return reportStorageSalesDto;
	}

	public void setReportStorageSalesDto(ReportStorageSalesDto reportStorageSalesDto) {
		this.reportStorageSalesDto = reportStorageSalesDto;
	}

	public ReportCenterInventoryDto getReportCenterInventoryDto() {
		return reportCenterInventoryDto;
	}

	public void setReportCenterInventoryDto(ReportCenterInventoryDto reportCenterInventoryDto) {
		this.reportCenterInventoryDto = reportCenterInventoryDto;
	}

	public ReportAccountPeriodDto getReportAccountPeriodDto() {
		return reportAccountPeriodDto;
	}

	public void setReportAccountPeriodDto(ReportAccountPeriodDto reportAccountPeriodDto) {
		this.reportAccountPeriodDto = reportAccountPeriodDto;
	}

	public String getSelectFlag() {
		return selectFlag;
	}

	public void setSelectFlag(String selectFlag) {
		this.selectFlag = selectFlag;
	}

	public ReportAccountTodayDto getReportAccountTodayDto() {
		return reportAccountTodayDto;
	}

	public void setReportAccountTodayDto(ReportAccountTodayDto reportAccountTodayDto) {
		this.reportAccountTodayDto = reportAccountTodayDto;
	}

	public ReportCreditAccountDto getReportCreditAccountDto() {
		return reportCreditAccountDto;
	}

	public void setReportCreditAccountDto(ReportCreditAccountDto reportCreditAccountDto) {
		this.reportCreditAccountDto = reportCreditAccountDto;
	}

	public ReportMemberActivePercentageDto getReportMemberActivePercentageDto() {
		return reportMemberActivePercentageDto;
	}


	public void setReportMemberActivePercentageDto(ReportMemberActivePercentageDto reportMemberActivePercentageDto) {
		this.reportMemberActivePercentageDto = reportMemberActivePercentageDto;
	}


	/**
	 * 母子卡类别转换
	 * @param integer
	 * @return
	 */
	private String motherTypeInt2Str(Integer integer) {
		if (integer == null) {
			return "";
		}
		switch (integer) {
		case 1:
			return "亲情卡子卡";
		case 2:
			return "亲情卡母卡";
		case 3:
			return "挂账卡子卡";
		case 4:
			return "挂账卡母卡";
		default:
			return "";
		}
	}
}

