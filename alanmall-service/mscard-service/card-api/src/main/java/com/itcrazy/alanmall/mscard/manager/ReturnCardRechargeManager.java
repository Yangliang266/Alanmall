package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.RechargeDto;
import com.itcrazy.alanmall.mscard.model.ReturnCardRechargeHistory;

import java.util.List;

/**
 * 退卡充值记录接口
 * @author softwise
 *
 */

public interface ReturnCardRechargeManager {

	public List<ReturnCardRechargeHistory> getPageList(RechargeDto rechargeDto);

	public Integer getPageTotal(RechargeDto rechargeDto);

}
