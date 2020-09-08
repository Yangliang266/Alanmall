package com.itcrazy.alanmall.mscard.report;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.ReportRechargeHistoryDto;
import com.itcrazy.alanmall.mscard.model.RechargeHistory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 发卡中心-充值统计表DAO层接口
 * @author huangchunbo
 * 2018-10-11
 */
@Component
public interface ReportRechargeHistoryDao extends BaseDao<RechargeHistory, Long> {

	List<RechargeHistory> getRechargeHistoryList(ReportRechargeHistoryDto reportRechargeHistoryDto);

	Integer getRechargeHistoryTotal(ReportRechargeHistoryDto reportRechargeHistoryDto);

	RechargeHistory getTotalRechargeHistory(ReportRechargeHistoryDto reportRechargeHistoryDto);



}
