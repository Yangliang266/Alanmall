package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.RechargeDto;
import com.itcrazy.alanmall.mscard.model.RechargeHistory;

import java.util.List;

/**
 * 卡充值记录接口
 * @author chenfei
 * 2018-09-13
 */
public interface RechargeHistoryManager {

	public List<RechargeHistory> getPageList(RechargeDto rechargeDto);

	public Integer getPageTotal(RechargeDto rechargeDto);

}
