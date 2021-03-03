package com.itcrazy.alanmall.mscard.report;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.ReportRechargeDetilDto;
import com.itcrazy.alanmall.mscard.model.ReportRechangeDetil;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 发卡/充值明细表Dao接口
 * @author huangchunbo
 * 2018-10-10
 */
@Component
public interface ReportRechargeDetilDao extends BaseDao<ReportRechangeDetil, Long> {

	List<ReportRechangeDetil> getReportRechargeDetilList(ReportRechargeDetilDto reportRechargeDetilDto);

	Integer getReportRechargeDetilTotal(ReportRechargeDetilDto reportRechargeDetilDto);

	ReportRechangeDetil getTotalRechargeDetil(ReportRechargeDetilDto reportRechargeDetilDto);

}
