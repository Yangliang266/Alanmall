package com.itcrazy.alanmall.mscard.report;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.ReportCreditAccountDto;
import com.itcrazy.alanmall.mscard.model.RechargeHistory;
import com.itcrazy.alanmall.mscard.model.ReportCreditAccount;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 挂账／清账报表DAO层接口
 * @author luxf
 * 2018-10-11
 */
@Component
public interface ReportCreditAccountDao extends BaseDao<RechargeHistory, Long> {

	List<ReportCreditAccount> getReportCreditAccountList(ReportCreditAccountDto reportCreditAccountDto);

	Integer getReportCreditAccountTotal(ReportCreditAccountDto reportCreditAccountDto);

	Integer getReportCardCreditAccountTotal(ReportCreditAccountDto reportCreditAccountDto);

	List<ReportCreditAccount> getReportCardCreditAccountList(ReportCreditAccountDto reportCreditAccountDto);

	public ReportCreditAccount getTotalInfo(ReportCreditAccountDto reportCreditAccountDto);

	public ReportCreditAccount getTotalCardInfo(ReportCreditAccountDto reportCreditAccountDto);

}
