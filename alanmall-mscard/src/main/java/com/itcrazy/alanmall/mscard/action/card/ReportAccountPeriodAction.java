package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.ReportAccountPeriodDto;
import com.itcrazy.alanmall.mscard.manager.ReportAccountPeriodManager;
import com.itcrazy.alanmall.mscard.model.ReportAccountPeriod;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.mscard.vo.card.ReportAccountPeriodVo;
import java.util.ArrayList;
import java.util.List;

public class ReportAccountPeriodAction extends InterfaceBaseAction{

	private static final long serialVersionUID = 4210031200936073021L;

	private ReportAccountPeriodDto reportAccountPeriodDto;

	@Reference
	ReportAccountPeriodManager reportAccountPeriodManager;

	// 营收账款余额表（时段）
	public String getReportAccountPeriodHistory() {
		if (reportAccountPeriodDto != null) {
			reportAccountPeriodDto = new ReportAccountPeriodDto();
		}

		reportAccountPeriodDto.setCompanyId(user.getId());
		List<ReportAccountPeriod> reportAccountPeriodList = reportAccountPeriodManager.getReportAccountPeriodList(reportAccountPeriodDto);

		List<ReportAccountPeriodVo> reportAccountPeriodVoList = new ArrayList<ReportAccountPeriodVo>();

		if (reportAccountPeriodList != null && reportAccountPeriodList.size() > 0) {
			for (ReportAccountPeriod rap : reportAccountPeriodList) {
				ReportAccountPeriodVo rav = new ReportAccountPeriodVo();
				// 卡号
				rav.setCardNo(rap.getCardNo());
				// 客户名
				rav.setUserName(rap.getUserName());
				// 卡状态
				rav.setStatus(KeyValueConvert.getCardStatusValue(rap.getStatus()));
				// 卡类别
				rav.setName(rap.getName());
				// 日出余额（本金）
				rav.setBeforeBalanceSum(String.valueOf(rap.getBeforeBalanceSum()));
				// 日出余额（奖励）
				rav.setBeforeRewardSum(String.valueOf(rap.getBeforeRewardSum()));
				/*// 充值金额（本金）
				rav.setRecharge(String.valueOf(rap.getRecharge()));
				// 充值金额（奖励）
				rav.setReward(String.valueOf(rap.getReward()));
				// 消费金额（本金）
				rav.setBill(String.valueOf(rap.getBill()));*/
				// 消费金额（奖励）
				rav.setStorageReward(String.valueOf(rap.getStorageReward()));
				// 卡内结余（本金）
				rav.setSurplusBalance(String.valueOf(rap.getSurplusBalance()));
				// 卡内结余（奖励）
				rav.setSurplusReward(String.valueOf(rap.getSurplusReward()));

				reportAccountPeriodVoList.add(rav);
			}
		}

		result.setSuccessInfo();
		return SUCCESS;
	}

	public ReportAccountPeriodDto getReportAccountPeriodDto() {
		return reportAccountPeriodDto;
	}

	public void setReportAccountPeriodDto(ReportAccountPeriodDto reportAccountPeriodDto) {
		this.reportAccountPeriodDto = reportAccountPeriodDto;
	}

}
